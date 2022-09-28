package ir.bustick.controller;

import ir.bustick.entity.User;
import ir.bustick.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String signUpAndLogin(){
        return "login-register";
    }

    @PostMapping("/signup")
    public String processSignupForm(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute("user") User user, HttpSession session){

        if(userService.findByUserAndPassword(user.getUsername(),user.getPassword()) != null) {
            session.setAttribute("error", null);
            session.setAttribute("user",user);
            return "redirect:/searchform";
        }

        else
            session.setAttribute("error", "Something went Wrong");

        return "redirect:/users";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession session){
        session.setAttribute("user",null);
        return "login-register";
    }
}
