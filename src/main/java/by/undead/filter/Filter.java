package by.undead.filter;

import by.undead.Equipment;
import by.undead.entity.Laptop;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Dzmitry Khralovich
 * Date: 15.02.13
 * Time: 20:17
 */
@ManagedBean(name = "filter")
@SessionScoped
public class Filter implements Serializable {
    private boolean cpuAMD;
    private boolean cpuIntel;

    private String manufacturer = "";

    private Map<String, String> manufacturers = new HashMap<String, String>();

    private int costMin = 100;

    private int CostMax = 1000;

    @ManagedProperty(value = "#{equipment}")
    private Equipment equipment;

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Filter() {
        for (String str : Equipment.manufacturers) {
            manufacturers.put(str, str);
        }

    }

    public boolean isCpuAMD() {
        return cpuAMD;
    }

    public void setCpuAMD(boolean cpuAMD) {
        this.cpuAMD = cpuAMD;
    }

    public boolean isCpuIntel() {
        return cpuIntel;
    }

    public void setCpuIntel(boolean cpuIntel) {
        this.cpuIntel = cpuIntel;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Map<String, String> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Map<String, String> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public int getCostMin() {
        return costMin;
    }

    public void setCostMin(int costMin) {
        this.costMin = costMin;
    }

    public int getCostMax() {
        return CostMax;
    }

    public void setCostMax(int costMax) {
        CostMax = costMax;
    }

    public String update() {
        FacesContext context = FacesContext.getCurrentInstance();
        //equipment.setLaptops((ArrayList<Laptop>) context.getExternalContext().getSessionMap().get("laptops"));
        equipment.setLaptops(updateLaptop(equipment.getLaptopsCopy()));
        return null;
    }

    private List<Laptop> updateLaptop(List<Laptop> list) {

        if (!cpuAMD && !cpuIntel && manufacturer.equals("")) return list;

        List<Laptop> laptops = new ArrayList<Laptop>();
        for (Laptop laptop : list) {
            if (!(cpuAMD && cpuIntel)) {
                if (cpuAMD) {
                    if (!(laptop.getPlatform().equals("AMD"))) {
                        continue;
                    }
                }
                if (cpuIntel) {
                    if (!laptop.getPlatform().equals("Intel")) {
                        continue;
                    }
                }
            }
            if (!manufacturer.equals("")) {
                if (!laptop.getManufacturer().equals(manufacturer)) {
                    continue;
                }
            }
            laptops.add(laptop);
        }
        return laptops;
    }
}
