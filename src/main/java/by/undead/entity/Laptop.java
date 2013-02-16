package by.undead.entity;

import java.io.Serializable;

/**
 * User: Dzmitry Khralovich
 * Date: 14.02.13
 * Time: 22:32
 */
public class Laptop implements Serializable {
    private String model;
    private String manufacturer;
    private String seller;
    private String photo;
    private String platform;
    private int cost;

    public Laptop() {
    }

    public Laptop(String model, String manufacturer, String seller, String photo, String platform, int cost) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.seller = seller;
        this.photo = photo;
        this.platform = platform;
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        if (cost != laptop.cost) return false;
        if (manufacturer != null ? !manufacturer.equals(laptop.manufacturer) : laptop.manufacturer != null)
            return false;
        if (model != null ? !model.equals(laptop.model) : laptop.model != null) return false;
        if (photo != null ? !photo.equals(laptop.photo) : laptop.photo != null) return false;
        if (platform != null ? !platform.equals(laptop.platform) : laptop.platform != null) return false;
        if (seller != null ? !seller.equals(laptop.seller) : laptop.seller != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (seller != null ? seller.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        result = 31 * result + cost;
        return result;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", seller='" + seller + '\'' +
                ", photo='" + photo + '\'' +
                ", platform='" + platform + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
