<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>پیام</title>
    <style>
        .box{
            margin: auto;
            text-align: center;
            width: 20%;
            height: 20%;
            font-family: Arial, Helvetica, sans-serif;
            font-size: large;
            border-radius: 15px;
            padding: 22px 22px 22px 22px;
            box-shadow: rgba(3, 102, 214, 0.3) 0px 0px 0px 3px;
        }
    </style>
</head>
<body>
    <div class="box">
        <%
            String message = (String) session.getAttribute("message");
            out.print(message);
        %>
        <br>
        <%
            String travelId = request.getParameter("travelID");
            out.print("شناسه بلیط: "+travelId);
        %>
        <br>
        <a href="/ticket">بازگشت</a>
    </div>
</body>
</html>