package by.undead.dao;

import org.apache.log4j.Logger;
import org.hibernate.*;

import java.io.Serializable;
import java.util.List;

/**
 * User: Dzmitry Khralovich
 * Date: 16.02.13
 * Time: 14:43
*/
public class DaoImpl<T, PK extends Serializable> implements Dao<T, PK> {

    private SessionFactory sessionFactory;

    private static Logger log = Logger.getLogger(DaoImpl.class);
    private Class<T> type;
    private String typeName;

    public DaoImpl(Class<T> type) {
        this.type = type;
        typeName = type.getSimpleName();
        log.debug(String.format("Created Dao for %s.", typeName));
    }

    public DaoImpl() {
    }

    public DaoImpl(Class<T> type, SessionFactory sessionFactory) {
        this.type = type;
        typeName = type.getSimpleName();
        log.debug(String.format("Created Dao for %s.", typeName));
        this.sessionFactory = sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public PK create(T t) {
        log.debug(String.format("Create %s: %s.", typeName, t));
        Transaction tr = getSession().beginTransaction();
        PK pk = null;
        try {
            pk = (PK) getSession().save(t);
            tr.commit();
        } catch (HibernateException ex){
            tr.rollback();
            log.debug(String.format("Error create. " + ex.getMessage()));
        }

        log.debug(String.format("Created Dao for %s.", typeName));
        return pk;
    }

    @Override
    public T read(PK id) {
        log.debug(String.format("Get %s with id=%s.", typeName, id));
        Transaction tr = getSession().beginTransaction();
        T t = null;
        try {
            t = (T) getSession().get(type, id);
            tr.commit();
        } catch (HibernateException ex){
            tr.rollback();
            log.debug(String.format("Error get entity. " + ex.getMessage()));
        }
        log.debug(String.format("Got %s: %s.", typeName, t));
        return t;
    }

    @Override
    public List<T> readAll() {
        log.debug(String.format("Get all <%s>.", typeName));
        Transaction tr = getSession().beginTransaction();
        List<T> list = null;
        try {
            list = getSession().createCriteria(type).list();
            tr.commit();
        } catch (HibernateException ex){
            tr.rollback();
            log.debug(String.format("Error get list. " + ex.getMessage()));
        }
        log.debug(String.format("Got %d products", list == null ? 0 : list.size()));
        return list;
    }

    @Override
    public T update(T t) {
        log.debug(String.format("Update %s: %s.", typeName, t));
        Transaction tr = getSession().beginTransaction();
        try {
            getSession().update(t);
            tr.commit();
        } catch (HibernateException ex){
            tr.rollback();
            log.debug(String.format("Error update. " + ex.getMessage()));
        }
        log.debug(String.format("Updated %s: %s.", typeName, t));
        return t;
    }

    @Override
    public void delete(T t) {
        log.debug(String.format("Delete %s: %s.", typeName, t));
        if (t != null) {
            Transaction tr = getSession().beginTransaction();
            try {
                getSession().delete(t);
                tr.commit();
            } catch (HibernateException ex){
                tr.rollback();
                log.debug(String.format("Error delete. " + ex.getMessage()));
            }
            log.debug(String.format("Deleted %s: %s.", typeName, t));
        }
    }

    public Session getSession(){
        Session session = sessionFactory.getCurrentSession();
        log.debug(String.format("Got current session for %s: %s.", typeName, session));
        return session;
    }

}
