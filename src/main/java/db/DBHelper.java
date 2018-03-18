package db;

import models.Actor;
import models.Director;
import models.Film;
import models.Studio;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void saveOrUpdate(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> T find(Class classType, int id){
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        Criteria criteria = session.createCriteria(classType);
        criteria.add(Restrictions.idEq(id));
        result = getUnique(criteria);
        return result;
    }

    public static <T> List<T> getAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria criteria = session.createCriteria(classType);
        results = getList(criteria);
        return results;
    }

    //    get Films of a Director, Studio or Actor
//    do individually, then do one for all3

    public static List<Film> getFilmsByDirector(Director director){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> films = null;
        Criteria criteria = session.createCriteria(Film.class);
        criteria.add(Restrictions.eq("director", director));
        films = getList(criteria);
        return films;
    }

//  get films by field
    public static List<Film> getFilmsByField(String fieldname, Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> films = null;
        Criteria criteria = session.createCriteria(Film.class);
        criteria.add(Restrictions.eq(fieldname, object));
        films = getList(criteria);
        return films;
    }


//    get Actors in a Film
//    all films of a year

    public static <T> T getUnique(Criteria criteria){
        T result = null;
        try {
            transaction = session.beginTransaction();
            result = (T)criteria.uniqueResult();
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static <T> List<T> getList(Criteria criteria){
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);   // remove duplicates
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = criteria.list();
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }



}
