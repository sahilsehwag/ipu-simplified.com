//package org.ipunagri.controllers;
//
//
//import org.ipunagri.models.PDFLink;
//import org.ipunagri.services.PDFLinkDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController("/api/downloads")
//public class RESTController {
//
//    @Autowired
//    PDFLinkDao pdfLinkDao;
//
////    @RequestMapping("datesheets")
////    public List<PDFLink> getDatesheets(@RequestParam(value="s") int start, @RequestParam(value="e") int end){
////        return pdfLinkDao.getRows(PDFLink.DATESHEET, start, end);
////    }
////
////    @RequestMapping(value = "notices")
////    public List<PDFLink> getNotices(@RequestParam(value="start", defaultValue = "1") int start, @RequestParam(value="end", defaultValue = "10") int end){
////        return pdfLinkDao.getR    ows(PDFLink.NOTICE, start, end);
////    }
////
////    @RequestMapping("results")
////    public List<PDFLink> getResults(@RequestParam(value="start") int start, @RequestParam(value="end") int end){
////        return pdfLinkDao.getRows(PDFLink.RESULT, start, end);
////    }
//
//}
