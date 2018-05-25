package db;

import models.Shop;
import models.Stock.Stock;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBShop {

    private static Session session;

    public static List<Stock> getStockFromShop(Shop shop) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Stock> results = null;
        try {
            Criteria criteria = session.createCriteria(Stock.class);
            criteria.add(Restrictions.eq("shop", shop));
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
