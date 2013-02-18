package by.undead;

import by.undead.entity.Laptop;
import by.undead.service.IService;
import by.undead.service.ServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Dzmitry Khralovich
 * Date: 14.02.13
 * Time: 23:52
 */
@ManagedBean(name = "addLaptop")
@ViewScoped
public class AddLaptop implements Serializable {

    private Laptop laptop;

    private IService service;

    private Map<String, String> manufacturers = new HashMap<String, String>();
    private Map<String, String> sellers = new HashMap<String, String>();
    private Map<String, String> platforms = new HashMap<String, String>();
    private Map<String, String> photos = new HashMap<String, String>();

    public AddLaptop() {
        service = ServiceImpl.getService();
    }

    @PostConstruct
    public void init() {
        laptop = new Laptop();

        for (String str : Equipment.getManufacturers()) {
            manufacturers.put(str, str);
        }

        for (String str : Equipment.getSeller()) {
            sellers.put(str, str);
        }

        for (String str : Equipment.getPlatform()) {
            platforms.put(str, str);
        }

        for (String str : Equipment.getPhoto()) {
            photos.put(str, str);
        }

    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Map<String, String> getManufacturers() {
        return manufacturers;
    }

    public Map<String, String> getSellers() {
        return sellers;
    }

    public Map<String, String> getPlatforms() {
        return platforms;
    }

    public Map<String, String> getPhotos() {
        return photos;
    }

    public void saveLaptop() {
        service.createLaptop(laptop);
    }
}
