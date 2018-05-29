package db;

import models.Basket;
import models.Customer;
import models.stock.Stock;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBBasket {

    private static Session session;

    public static List<Stock> getStockFromBasket(Basket basket) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Stock> results = null;
        try {
            Criteria criteria = session.createCriteria(Stock.class);
            criteria.add(Restrictions.eq("basket", basket));
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Basket getbasketForCustomer(Customer customer){
        session = HibernateUtil.getSessionFactory().openSession();
        Basket basket = null;
        try {
            Criteria criteria = session.createCriteria(Basket.class);
            criteria.createAlias("customer", "cust");
            criteria.add(Restrictions.eq("cust.id", customer.getId()));
            basket = (Basket)criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return basket;
    }
}
