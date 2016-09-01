package org.ipunagri.services;


import org.ipunagri.models.PDFLink;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;


@NamedQueries({
        @NamedQuery(name="getRowsByPDFType", query="FROM PDFLink AS pdf WHERE pdf.pdfType = :pdfType"),
})
public class PDFLinkDao extends Dao{

    public List<PDFLink> getRows(String pdfType) {
        return (List<PDFLink>)hibernateTemplate.findByNamedQuery("getRowsByPDFType", pdfType);
    }

}
