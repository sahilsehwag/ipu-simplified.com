package org.ipunagri.services;


import org.hibernate.Session;
import org.ipunagri.models.PDFLink;
import org.ipunagri.support.models.ParsedRow;

import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
            BigInteger[] qAndR = rowCount.divideAndRemainder(BigInteger.valueOf(ROWS_PER_PAGE));
            if (qAndR[1].intValue() != 0)
                totalPages = qAndR[0].add(new BigInteger("1"));
            else totalPages = qAndR[0];
        }catch(Exception e){
            e.printStackTrace();
        }
        return totalPages.intValue();
    }

    public ArrayList<String> getTodaysOldRows(String pdfType) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.getNamedNativeQuery("PDFLink.getByToday");

            query.setParameter("pdfType", pdfType);
            query.setParameter("uploadDate", getCorrectDate());

            List rows = query.getResultList();
            ArrayList<String> urlRows = new ArrayList<>();

            for (Object row : rows) {
                urlRows.add(((String) row).trim());
            }

            return urlRows;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getCorrectDate() {
        Date today = new Date();
        String todayString = null;
        String correctMonth = (new Integer(today.getMonth() + 1)).toString();
        String correctDate = (new Integer(today.getDate())).toString();

        if (today.getMonth() < 9) correctMonth = "0" + correctMonth;
        if (today.getDate() < 10) correctDate = "0" + correctDate;

        todayString = (today.getYear() + 1900) + "-" + correctMonth + "-" + correctDate;

        return todayString;
    }

}
