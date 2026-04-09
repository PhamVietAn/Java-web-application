package ra.edu.demo1.model;

import java.util.Date;

public class Product {
    int id;
    String name;
    String product;
    int yearMaking;
    Date source;
    double price;

    public Product() {
    }

    public Product(int id, String name, String product, int yearMaking, Date source, double price) {
        this.id = id;
        this.name = name;
        this.product = product;
        this.yearMaking = yearMaking;
        this.source = source;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getYearMaking() {
        return yearMaking;
    }

    public void setYearMaking(int yearMaking) {
        this.yearMaking = yearMaking;
    }

    public Date getSource() {
        return source;
    }

    public void setSource(Date source) {
        this.source = source;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
