package by.undead.dao;

import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;

/**
 * User: Dzmitry Khralovich
 * Date: 16.02.13
 * Time: 14:32
 */
public interface Dao<T, PK extends Serializable> {

    PK create(T t);

    T read(PK id);

    List<T> readAll();

    T update(T t);

    void delete(T t);
}
