package co2103.hw1.domain;

import co2103.hw1.domain.Product;

import java.util.ArrayList;
import java.util.List;
public class Warehouse {
    private List<Product> products;
    public Warehouse() {
        this.products = new ArrayList<>();
    }

    // Getter for products
    public List<Product> getProducts() {
        return products;
    }
    private int id;

    private String founder;

    private String industry;


    //id getter
    public int getId() {
        return id;
    }

    //id setter
    public void setId(int id) {

        this.id = id;
    }

    // founder getter
    public String getFounder() {
        return founder;
    }

    //founder setter
    public void setFounder(String founder) {
        this.founder = founder;
    }

    //products setter
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    //industry getter
    public String getIndustry() {
        return industry;
    }

    //industry setter
    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
