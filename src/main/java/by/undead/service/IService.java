package by.undead.service;


import by.undead.entity.Laptop;


import java.util.List;

/**
 * User: Dzmitry Khralovich
 * Date: 16.02.13
 * Time: 15:15
 */
public interface IService {

    Laptop createLaptop(Laptop laptop);

    List<Laptop> getAllLaptops();

    Laptop getLaptop(Long id);

    void updateLaptop(Laptop laptop);

    void deleteLaptop(Laptop laptop);

}
