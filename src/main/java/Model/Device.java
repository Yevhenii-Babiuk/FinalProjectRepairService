package model;

import java.util.Objects;


/**
 * Class realizing entity of device
 */
public class Device {
    private int id;
    private int client;
    private String brand;
    private String model;
    private String imei;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device)) return false;
        Device device = (Device) o;
        return getId() == device.getId() &&
                getClient() == device.getClient() &&
                getBrand().equals(device.getBrand()) &&
                getModel().equals(device.getModel()) &&
                getImei().equals(device.getImei());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClient(), getBrand(), getModel(), getImei());
    }
}
