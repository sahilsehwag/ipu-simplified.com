package org.ipunagri.controllers;




import org.ipunagri.models.PDFLink;
import org.ipunagri.services.PDFLinkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    PDFLinkDao pdfLinkDao;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String landing(HttpSession session, ModelMap model){
        return "redirect:results";
    }

    @RequestMapping(value="index", method=RequestMethod.GET)
    public String index(){
        return "redirect:results";
    }


    @RequestMapping("notices")
    public ModelAndView notices(ModelMap map, @RequestParam(defaultValue="1") int page){
        if(page < 1 || page > pdfLinkDao.getTotalPages(PDFLink.RESULT))
            return new ModelAndView("redirect:page-not-found");

        List<PDFLink> notices = pdfLinkDao.getRows(PDFLink.NOTICE, page);

        List<Integer> pageCounts = this.generatePageCountArray(page, PDFLink.NOTICE);

        map.addAttribute("notices", notices);
        map.addAttribute("pageCounts", pageCounts);
        map.addAttribute("page", page);

        return new ModelAndView("downloads/notices", map);
    }

    @RequestMapping("results")
    public ModelAndView results(ModelMap map, @RequestParam(defaultValue="1") int page){
        if(page < 1 || page > pdfLinkDao.getTotalPages(PDFLink.RESULT))
            return new ModelAndView("redirect:page-not-found");

        List<PDFLink> results = pdfLinkDao.getRows(PDFLink.RESULT, page);

        List<Integer> pageCounts = this.generatePageCountArray(page, PDFLink.RESULT);

        map.addAttribute("results", results);
        map.addAttribute("pageCounts", pageCounts);
        map.addAttribute("page", page);

        return new ModelAndView("downloads/results", map);
    }

    @RequestMapping("datesheets")
    public ModelAndView datesheets(ModelMap map, @RequestParam(defaultValue="1") int page){
        if(page < 1 || page > pdfLinkDao.getTotalPages(PDFLink.RESULT))
            return new ModelAndView("redirect:page-not-found");

        List<PDFLink> datesheets = pdfLinkDao.getRows(PDFLink.DATESHEET, page);

        List<Integer> pageCounts = this.generatePageCountArray(page, PDFLink.DATESHEET);

        map.addAttribute("datesheets", datesheets);
        map.addAttribute("pageCounts", pageCounts);
        map.addAttribute("page", page);

        return new ModelAndView("downloads/datesheets", map);
    }


    @RequestMapping(value="downloads", method=RequestMethod.GET)
    public ModelAndView downloads(HttpSession session, ModelMap model, @RequestParam(defaultValue = "1") int page){
        return new ModelAndView("base/404", model);
    }


    @RequestMapping(value="getyourresult", method=RequestMethod.GET)
    public ModelAndView getYourResult(){
        return new ModelAndView("redirect:under-development");
    }


    @RequestMapping(value="under-development", method=RequestMethod.GET)
    public String underDevelopment(){
        return "base/under-development";
    }

    @RequestMapping("page-not-found")
    public String pageNotFoundURL(){
        return "base/404";
    }

    @RequestMapping("*")
    public String pageNotFound(){
        return "base/404";
    }




    private List<Integer> generatePageCountArray(int page, String pdfType){
        int pageButtonsPerPage = 20;
        int totalPages = pdfLinkDao.getTotalPages(pdfType);

        List<Integer> pageCounts = new ArrayList<>(10);
        if(totalPages-page <= pageButtonsPerPage/2) {
            for(int i = totalPages-pageButtonsPerPage; i <= totalPages; i++) {
                pageCounts.add(i);
            }
        }else{
            for (int i = 1; i <= pageButtonsPerPage; i++) {
                if (page > pageButtonsPerPage / 2)
                    pageCounts.add(i + page - (pageButtonsPerPage / 2));
                else
                    pageCounts.add(i);
            }
        }

        return pageCounts;
    }
}
