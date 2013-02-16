package by.undead;

import by.undead.entity.Laptop;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Dzmitry Khralovich
 * Date: 14.02.13
 * Time: 23:52
 */
@ManagedBean(name = "equipment")
@SessionScoped
public class Equipment implements Serializable {

    private List<Laptop> laptops;

    private final static String[] model;
    public final static String[] manufacturers;
    private final static String[] seller;
    private final static String[] platform;
    private final static String[] photo;

    static {
        model = new String[6];
        model[0] = "1124";
        model[1] = "5577";
        model[2] = "1358";
        model[3] = "4555";
        model[4] = "2489";
        model[5] = "3355";


        manufacturers = new String[6];
        manufacturers[0] = "ASUS";
        manufacturers[1] = "DELL";
        manufacturers[2] = "Samsung";
        manufacturers[3] = "Lenovo";
        manufacturers[4] = "HP";
        manufacturers[5] = "Acer";

        seller = new String[6];
        seller[0] = "GoodNote";
        seller[1] = "OffLine";
        seller[2] = "ICO";
        seller[3] = "Prof";
        seller[4] = "BestIT";
        seller[5] = "iShop";

        photo = new String[6];
        photo[0] = "note_1.jpg";
        photo[1] = "note_2.jpg";
        photo[2] = "note_3.jpg";
        photo[3] = "note_4.jpg";
        photo[4] = "note_5.jpg";
        photo[5] = "note_6.jpg";

        platform = new String[2];
        platform[0] = "Intel";
        platform[1] = "AMD";
    }


    public Equipment() {
        laptops = new ArrayList<Laptop>();
        randomLaptops(laptops, 10);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("laptops", laptops);
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    private void randomLaptops(List<Laptop> list, int size) {
        for(int i = 0 ; i < size ; i++)
            list.add(new Laptop(getRandomModel(), getRandomManufacturer(), getRandomSeller(), getRandomPhoto(),getRandomPlatform(),getRandomCost()));
    }

    private String getRandomModel() {
        return model[(int) (Math.random() * 6)];
    }

    private String getRandomManufacturer() {
        return manufacturers[(int) (Math.random() * 6)];
    }

    private String getRandomSeller() {
        return seller[(int) (Math.random() * 6)];
    }

    private String getRandomPhoto() {
        return seller[(int) (Math.random() * 6)];
    }

    private String getRandomPlatform() {
        return platform[(int) (Math.random() * 2)];
    }

    private int getRandomCost() {
        return (int) (Math.random() * 100 + 500);
    }
}
