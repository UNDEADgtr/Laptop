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

    //@ManagedProperty(value = "#{service}")
    //private IService service;
    //private ServiceImpl service;

    public ServiceTest() {
    }

//    public void setService(ServiceImpl service) {
//        this.service = service;
//    }

    @Test
    public void test_service() {
        //assertNotNull(service);
    }

    @Test
    public void test_create_get_Laptop() {
        Laptop laptop = new Laptop();
        Laptop laptopCreate = ServiceImpl.getService().createLaptop(laptop);
        assertNotNull(laptopCreate);
        Laptop laptopRead = ServiceImpl.getService().getLaptop(laptopCreate.getId());
        assertEquals(laptop, laptopRead);
        ServiceImpl.getService().deleteLaptop(laptopRead);
    }

    @Test
    public void test_create_get_all_Laptops() {
        Laptop laptop1 = new Laptop();
        Laptop laptop2 = new Laptop();
        Laptop laptopCreate1 = ServiceImpl.getService().createLaptop(laptop1);
        Laptop laptopCreate2 = ServiceImpl.getService().createLaptop(laptop2);
        List<Laptop> list = ServiceImpl.getService().getAllLaptops();
        assertNotNull(list);
        //assertEquals(2, list.size());
        //for (Laptop laptop : list) {
            ServiceImpl.getService().deleteLaptop(laptopCreate1);
            ServiceImpl.getService().deleteLaptop(laptopCreate2);
        //}
    }

    @Test
    public void test_create_update_Laptops() {
        Laptop laptop = new Laptop();
        Laptop laptopCreate = ServiceImpl.getService().createLaptop(laptop);
        assertNotNull(laptopCreate);
        Laptop laptopRead = ServiceImpl.getService().getLaptop(laptopCreate.getId());
        assertNotNull(laptopRead);
        laptopRead.setPlatform("AMD");
        ServiceImpl.getService().updateLaptop(laptopRead);
        Laptop laptopUpdate = ServiceImpl.getService().getLaptop(laptopCreate.getId());
        assertEquals(laptopRead, laptopUpdate);
        assertEquals("AMD", laptopUpdate.getPlatform());
        ServiceImpl.getService().deleteLaptop(laptopUpdate);
    }

    @Test
    public void test_create_delete_Laptops() {
        Laptop laptop = new Laptop();
        Laptop laptopCreate = ServiceImpl.getService().createLaptop(laptop);
        assertNotNull(laptopCreate);
        Laptop laptopRead = ServiceImpl.getService().getLaptop(laptopCreate.getId());
        ServiceImpl.getService().deleteLaptop(laptopRead);
        Laptop laptopDelete = ServiceImpl.getService().getLaptop(laptopCreate.getId());
        assertNull(laptopDelete);
    }

}
