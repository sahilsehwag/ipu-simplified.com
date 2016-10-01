package org.ipunagri.controllers;




import org.ipunagri.models.PDFLink;
import org.ipunagri.services.PDFLinkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    PDFLinkDao pdfLinkDao;

    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView landing(HttpSession session, ModelMap model){
        List<PDFLink> results = pdfLinkDao.getRows(PDFLink.RESULT, 0, 15);
        List<PDFLink> notices = pdfLinkDao.getRows(PDFLink.NOTICE, 0, 15);
        List<PDFLink> datesheets = pdfLinkDao.getRows(PDFLink.DATESHEET, 0, 15);

        model.addAttribute("results", results);
        model.addAttribute("notices", notices);
        model.addAttribute("datesheets", datesheets);
        return new ModelAndView("downloads", model);
    }

    @RequestMapping(value="index", method=RequestMethod.GET)
    public String index(){
        return "under-development";
    }

    @RequestMapping(value="results", method=RequestMethod.GET)
    public String results(){
        return "under-development";
    }

    @RequestMapping(value="downloads", method=RequestMethod.GET)
    public String downloads(){
        return "downloads";
    }

    @RequestMapping(value="notices", method=RequestMethod.GET)
    public String notices(){
        return "under-development";
    }

    @RequestMapping("*")
    public String pageNotFound(){
        return "404";
    }

}
