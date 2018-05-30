package db;

import models.Customer;
import models.stock.Stock;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCustomer {

    private static Session session;
    private static Transaction transaction;

    public static Customer findByUsername(String username, Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        Customer result = null;
        try {
            Criteria criteria = session.createCriteria(classType);
            criteria.add(Restrictions.eq("username", username));
            result = (Customer) criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
