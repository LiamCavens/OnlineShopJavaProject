package db;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DBCustomer {

    private static Session session;
    private static Transaction transaction;

    public static <T> T findByUsername(String username, Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        try {
            Criteria criteria = session.createCriteria(classType);
            criteria.add(Restrictions.eq("username", username));
            result = (T) criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

}
