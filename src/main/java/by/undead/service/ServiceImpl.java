package by.undead.service;

import by.undead.dao.Dao;
import by.undead.dao.DaoImpl;
import by.undead.entity.Laptop;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 * User: Dzmitry Khralovich
 * Date: 16.02.13
 * Time: 15:48
 */
@ManagedBean(name = "service")
@SessionScoped
public class ServiceImpl implements Serializable, IService {


    private static Logger log = Logger.getLogger(ServiceImpl.class);
    private Dao<Laptop, Long> laptopDao;
    private static SessionFactory sessionFactory = null;
    private static ServiceImpl service = new ServiceImpl();

    public ServiceImpl(){
        try {
            Configuration config = new AnnotationConfiguration();
            this.sessionFactory = config.configure().buildSessionFactory();
        } catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        laptopDao = new DaoImpl<Laptop, Long>(Laptop.class,sessionFactory);
    }

    public static ServiceImpl getService() {
        return service;
    }

    @Override
    public Laptop createLaptop(Laptop laptop) {
        try {
            laptopDao.create(laptop);
        } catch (HibernateException he) {
            log.error(String.format("Failed to create laptop: %s.", laptop));
        }
        return laptop;
    }

    @Override
    public List<Laptop> getAllLaptops() {
        List<Laptop> entities = null;
        try {
            entities = laptopDao.readAll();
        } catch (HibernateException he) {
            log.error("Failed to get list of laptops. " + he.getMessage());

        }
        return entities;
    }

    @Override
    public Laptop getLaptop(Long id) {
        Laptop entity = null;
        try {
            entity = laptopDao.read(id);
        } catch (HibernateException he) {
            log.error(String.format("Failed to get laptop by id=%d.", id));
        }
        return entity;
    }

    @Override
    public void updateLaptop(Laptop laptop) {
        try {
            laptopDao.update(laptop);
        } catch (HibernateException he) {
            log.error(String.format("Failed to update laptop: %s.", laptop));
        }
    }

    @Override
    public void deleteLaptop(Laptop laptop) {
        try {
            laptopDao.delete(laptop);
        } catch (HibernateException he) {
            log.error(String.format("Failed to delete laptop: %s.", laptop));
        }
    }

}
