package by.undead;

import by.undead.entity.Laptop;
import by.undead.service.IService;
import by.undead.service.ServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * User: Dzmitry Khralovich
 * Date: 16.02.13
 * Time: 17:31
 */
@RunWith(JUnit4.class)
@ManagedBean(name = "test")
@SessionScoped
public class ServiceTest extends Assert {

    private IService service;


    public ServiceTest() {
        service = ServiceImpl.getService();
    }

    @Test
    public void test_service() {
        assertNotNull(service);
    }

    @Test
    public void test_create_get_Laptop() {
        Laptop laptop = new Laptop();
        Laptop laptopCreate = service.createLaptop(laptop);
        assertNotNull(laptopCreate);
        Laptop laptopRead = service.getLaptop(laptopCreate.getId());
        assertEquals(laptop, laptopRead);
        service.deleteLaptop(laptopRead);
    }

    @Test
    public void test_create_get_all_Laptops() {
        Laptop laptop1 = new Laptop();
        Laptop laptop2 = new Laptop();
        Laptop laptopCreate1 = service.createLaptop(laptop1);
        Laptop laptopCreate2 = service.createLaptop(laptop2);
        List<Laptop> list = service.getAllLaptops();
        assertNotNull(list);
        //assertEquals(2, list.size());
        //for (Laptop laptop : list) {
            service.deleteLaptop(laptopCreate1);
            service.deleteLaptop(laptopCreate2);
        //}
    }

    @Test
    public void test_create_update_Laptops() {
        Laptop laptop = new Laptop();
        Laptop laptopCreate = service.createLaptop(laptop);
        assertNotNull(laptopCreate);
        Laptop laptopRead = service.getLaptop(laptopCreate.getId());
        assertNotNull(laptopRead);
        laptopRead.setPlatform("AMD");
        service.updateLaptop(laptopRead);
        Laptop laptopUpdate = service.getLaptop(laptopCreate.getId());
        assertEquals(laptopRead, laptopUpdate);
        assertEquals("AMD", laptopUpdate.getPlatform());
        service.deleteLaptop(laptopUpdate);
    }

    @Test
    public void test_create_delete_Laptops() {
        Laptop laptop = new Laptop();
        Laptop laptopCreate = service.createLaptop(laptop);
        assertNotNull(laptopCreate);
        Laptop laptopRead = service.getLaptop(laptopCreate.getId());
        service.deleteLaptop(laptopRead);
        Laptop laptopDelete = service.getLaptop(laptopCreate.getId());
        assertNull(laptopDelete);
    }

}
