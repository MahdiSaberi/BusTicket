package ir.bustick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class LogRegController {

    @RequestMapping(method = RequestMethod.GET)

    public String firstPage(ModelMap model){
        return "login-register";
    }

}
