package org.ipunagri.services;


import org.hibernate.Session;
import org.ipunagri.models.PDFLink;
import org.ipunagri.support.models.ParsedRow;

import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;


public class PDFLinkDao extends Dao<PDFLink> {

    private static int ROWS_PER_PAGE;
    private static int PAGE_PER_PAGE;

    static{
        ROWS_PER_PAGE = 20;
    }

    public List<PDFLink> getRows(String pdfType, int page) {
        List<PDFLink> pdfLinks = null;

        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Query query = session.getNamedNativeQuery("PDFLink.byPDFTypeInRange");
            query.setParameter("pdfType", pdfType);
            query.setParameter("start",(ROWS_PER_PAGE*page)- ROWS_PER_PAGE);
            query.setParameter("rowCount", ROWS_PER_PAGE);

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

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();

            for (ParsedRow row : rows) {
                pdfLink = new PDFLink(pdfType, row.getName(), row.getUrl(), row.getDate());

                session.saveOrUpdate(pdfLink);
            }
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            try{
                session.getTransaction().commit();
            }catch (Exception e){e.printStackTrace();}
        }
    }

    public int getRowsPerPage(){
        return ROWS_PER_PAGE;
    }

    public int getTotalPages(String pdfType){
        BigInteger totalPages = null;

        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Query query = session.getNamedNativeQuery("PDFLink.getRowCount");
            query.setParameter("pdfType", pdfType);

            BigInteger rowCount = (BigInteger)query.getSingleResult();
            totalPages = rowCount.divide(BigInteger.valueOf(ROWS_PER_PAGE));
        }catch(Exception e){
            e.printStackTrace();
        }
        return totalPages.intValue();
    }

}
