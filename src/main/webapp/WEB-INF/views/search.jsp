<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <style>
        body {
            align-items: center;
            background: url("https://s25.picofile.com/file/8453285968/busground.jpg") no-repeat right center;
            display: flex;
            justify-content: center;
            height: 100vh;
        }

        .form {
            background-color: #15172b;
            border-radius: 20px;
            box-sizing: border-box;
            height: 500px;
            padding: 20px;
            width: 320px;
        }

        .title {
            color: #eee;
            font-family: sans-serif;
            font-size: 36px;
            font-weight: 600;
            direction: rtl;
            margin-top: 30px;
        }

        .subtitle {
            color: #eee;
            font-family: sans-serif;
            font-size: 16px;
            font-weight: 600;
            direction: rtl;
            margin-top: 10px;
        }

        .input-container {
            height: 50px;
            position: relative;
            width: 100%;
            direction: rtl;
        }

        .ic1 {
            margin-top: 40px;
            direction: rtl;
        }

        .ic2 {
            margin-top: 30px;
            direction: rtl;
        }

        .input {
            background-color: #303245;
            border-radius: 12px;
            border: 0;
            box-sizing: border-box;
            color: #eee;
            font-size: 18px;
            height: 100%;
            outline: 0;
            padding: 4px 20px 0;
            width: 100%;
            direction: rtl;
        }

        .cut {
            background-color: #15172b;
            border-radius: 10px;
            height: 20px;
            left: 20px;
            position: absolute;
            top: -20px;
            transform: translateY(0);
            transition: transform 200ms;
            width: 76px;
        }

        .cut-short {
            width: 50px;
        }

        .input:focus ~ .cut,
        .input:not(:placeholder-shown) ~ .cut {
            transform: translateY(8px);
        }

        .placeholder {
            color: #65657b;
            font-family: sans-serif;
            left: 20px;
            line-height: 14px;
            pointer-events: none;
            position: absolute;
            transform-origin: 0 50%;
            transition: transform 200ms, color 200ms;
            top: 20px;
        }

        .input:focus ~ .placeholder,
        .input:not(:placeholder-shown) ~ .placeholder {
            transform: translateY(-30px) translateX(10px) scale(0.75);
        }

        .input:not(:placeholder-shown) ~ .placeholder {
            color: #808097;
        }

        .input:focus ~ .placeholder {
            color: #dc2f55;
        }

        .submit {
            background-color: #08d;
            border-radius: 12px;
            border: 0;
            box-sizing: border-box;
            color: #eee;
            cursor: pointer;
            font-size: 18px;
            height: 50px;
            margin-top: 38px;
        // outline: 0;
            text-align: center;
            width: 100%;
        }

        .submit:active {
            background-color: #06b;
        }

    </style>
</head>
<div class="form">
    <div class="title">جستجوی بلیط</div>

    <form action="/searchform" method="post">
    <div class="input-container ic1">
        <input id="origin" name="orig" class="input" type="text" placeholder=" " />
        <div class="cut"></div>
        <label for="origin" class="placeholder">مبدا</label>
    </div>
    <div class="input-container ic2">
        <input id="destination" name="dest" class="input" type="text" placeholder=" " />
        <div class="cut"></div>
        <label for="destination" class="placeholder">مقصد</label>
    </div>
    <div class="input-container ic2">
        <input id="date" name="date" class="input" type="date" />
        <div class="cut cut-short"></div>
        <label for="date" class="placeholder" >تاریخ</label>
    </div>
    <button type="text" class="submit">جستجو</button>
    </form>
</div>
</html>