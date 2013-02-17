package by.undead.filter;

import by.undead.Equipment;
import by.undead.EquipmentDB;
import by.undead.entity.Laptop;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
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
@ViewScoped
public class Filter implements Serializable {
    private boolean cpuAMD;
    private boolean cpuIntel;

    private String manufacturer = "";

    private Map<String, String> manufacturers = new HashMap<String, String>();

    private int costMin = 0;

    private int costMax = 0;

    @ManagedProperty(value = "#{equipment}")
    private Equipment equipment;

    @ManagedProperty(value = "#{equipmentDB}")
    private EquipmentDB equipmentDB;

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void setEquipmentDB(EquipmentDB equipmentDB) {
        this.equipmentDB = equipmentDB;
    }

    public Filter() {
        for (String str : Equipment.getManufacturers()) {
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
        return costMax;
    }

    public void setCostMax(int costMax) {
        this.costMax = costMax;
    }

    public String update() {
        //FacesContext context = FacesContext.getCurrentInstance();
        equipment.setLaptops(updateLaptop(equipment.getLaptopsCopy()));
        return null;
    }

    public String updateDB() {
        equipmentDB.setLaptops(updateLaptop(equipmentDB.getLaptopsCopy()));
        return null;
    }

    private List<Laptop> updateLaptop(List<Laptop> list) {

        if (!cpuAMD && !cpuIntel && manufacturer.equals("") && costMin == 0 && costMax == 0) return list;

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
            if (!(costMin == 0 && costMax == 0)) {
                if (!(costMin < laptop.getCost() && laptop.getCost() < costMax)) {
                    continue;
                }
            }
            laptops.add(laptop);
        }
        return laptops;
    }
}
