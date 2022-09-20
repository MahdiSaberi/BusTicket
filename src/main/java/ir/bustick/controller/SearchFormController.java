package ir.bustick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/searchform")
public class SearchFormController {

    @RequestMapping(method = RequestMethod.GET)
    public String showSearchForm(ModelMap model){
        return "search";
    }
}
