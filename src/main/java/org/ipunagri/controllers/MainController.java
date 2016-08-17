package org.ipunagri.controllers;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.MalformedURLException;
import java.net.URL;


@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(value="", method=RequestMethod.GET)
    public String landing(HttpSession session, Model model) throws MalformedURLException{
        return "index";
    }

    @RequestMapping(value="index", method=RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value="results", method=RequestMethod.GET)
    public String results(){
        return "results";
    }

    @RequestMapping(value="downloads", method=RequestMethod.GET)
    public String downloads(){
        return "downloads";
    }

    @RequestMapping("*")
    public String pageNotFound(){
        return "404";
    }

}
