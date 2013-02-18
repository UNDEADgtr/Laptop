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
import java.util.List;

/**
 * User: Dzmitry Khralovich
 * Date: 14.02.13
 * Time: 23:52
 */
@ManagedBean(name = "equipmentDB")
@ViewScoped
public class EquipmentDB implements Serializable {

    private List<Laptop> laptops;
    private List<Laptop> laptopsCopy;

    private Laptop selectedLaptop;

    private IService service;

    public EquipmentDB() {
        service = ServiceImpl.getService();
    }

    @PostConstruct
    public void init()
    {
        laptops = service.getAllLaptops();
        laptopsCopy = new ArrayList<Laptop>(laptops);
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public List<Laptop> getLaptopsCopy() {
        return laptopsCopy;
    }

    public Laptop getSelectedLaptop() {
        return selectedLaptop;
    }

    public void setSelectedLaptop(Laptop selectedLaptop) {
        this.selectedLaptop = selectedLaptop;
    }
}
