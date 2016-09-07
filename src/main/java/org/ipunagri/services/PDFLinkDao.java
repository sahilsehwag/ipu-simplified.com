package org.ipunagri.services;


import org.ipunagri.models.PDFLink;
import org.ipunagri.support.models.ParsedRow;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;
import java.util.Map;


@NamedQueries({
        @NamedQuery(name="getRowsByPDFType", query="FROM PDFLink AS pdf WHERE pdf.pdfType = :pdfType"),
        @NamedQuery(name="getRowsByDateRange", query="FROM PDFLink AS pdf WHERE (pdf.uploadDate >= :startDate and pdf.uploadDate <= :endDate)"),
})
public class PDFLinkDao extends Dao{

    public List<PDFLink> getRows(String pdfType) {
        return (List<PDFLink>)hibernateTemplate.findByNamedQuery("getRowsByPDFType", pdfType);
    }

    public List<PDFLink> getRowsByDateRange(String startDate, String endDate){
        return (List<PDFLink>)hibernateTemplate.findByNamedQuery("getRowsByDateRange", startDate, endDate);
    }

    public void saveOrUpdateAll(List<PDFLink> rows){

    }

}
