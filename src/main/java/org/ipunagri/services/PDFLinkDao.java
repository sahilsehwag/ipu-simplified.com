package org.ipunagri.services;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ipunagri.models.IModel;
import org.ipunagri.models.PDFLink;
import org.ipunagri.support.models.ParsedRow;
import org.ipunagri.support.parsers.html.ParseType;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;




public class PDFLinkDao extends Dao<PDFLink> {

    public List<PDFLink> getRows(String pdfType, int start, int end) {
        List<PDFLink> pdfLinks = null;

        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            //Query query = session.getNamedQuery("getRowsByPDFType");
            Query query = session.getNamedNativeQuery("PDFLink.byPDFTypeInRange");
            query.setParameter("pdfType", pdfType);
            query.setParameter("start", start);
            query.setParameter("end", end);

            pdfLinks = query.getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return pdfLinks;
    }

    public List<PDFLink> getRowsByDateRange(String startDate, String endDate) {
        return (List<PDFLink>) hibernateTemplate.findByNamedQuery("getRowsByDateRange", startDate, endDate);
    }

    public synchronized void saveOrUpdateAll(List<ParsedRow> rows, String pdfType) {

        PDFLink pdfLink=null;
        Session session = null;

        //System.out.println(pdfType);

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();

            for (ParsedRow row : rows) {
                //System.out.println(pdfType);
                pdfLink = new PDFLink(pdfType, row.getName(), row.getUrl(), row.getDate());

                session.saveOrUpdate(pdfLink);
            }
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.getTransaction().commit();
        }


    }

}
