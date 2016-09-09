package org.ipunagri.services;


import org.hibernate.Session;
import org.ipunagri.models.IModel;
import org.ipunagri.models.PDFLink;
import org.ipunagri.support.models.ParsedRow;
import org.ipunagri.support.parsers.html.ParseType;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;


@NamedQueries({
        @NamedQuery(name = "getRowsByPDFType", query = "FROM PDFLink AS pdf WHERE pdf.pdfType = :pdfType"),
        @NamedQuery(name = "getRowsByDateRange", query = "FROM PDFLink AS pdf WHERE (pdf.uploadDate >= :startDate and pdf.uploadDate <= :endDate)"),
})
public class PDFLinkDao extends Dao<PDFLink> {

    public List<PDFLink> getRows(String pdfType) {
        return (List<PDFLink>) hibernateTemplate.findByNamedQuery("getRowsByPDFType", pdfType);
    }

    public List<PDFLink> getRowsByDateRange(String startDate, String endDate) {
        return (List<PDFLink>) hibernateTemplate.findByNamedQuery("getRowsByDateRange", startDate, endDate);
    }

    public void saveOrUpdateAll(List<ParsedRow> rows, String pdfType) {

        PDFLink pdfLink=null;

        for (ParsedRow row : rows) {
            pdfLink = new PDFLink(pdfType, row.getName(), row.getUrl(), row.getDate());

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(pdfLink);
            session.getTransaction().commit();

        }

    }

}
