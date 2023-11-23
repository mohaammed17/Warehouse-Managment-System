package co2103.hw1.domain;

public class Product {
    private String name;
    private String slogan;
    private String flavour;
    private int price;

    //slogan getter
    public String getSlogan() {
        return slogan;
    }

    //slogan setter
    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    //name getter
    public String getName() {
        return name;
    }

    //name setter
    public void setName(String name) {
        this.name = name;
    }

    //price getter
    public int getPrice() {
        return price;
    }

    //price setter
    public void setPrice(int price) {
        this.price = price;
    }

    //flavour getter
    public String getFlavour() {
        return flavour;
    }

    //flavour setter
    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }
}
