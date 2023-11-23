package co2103.hw1;
// Import necessary classes for the application
import co2103.hw1.domain.Product;
import co2103.hw1.domain.Warehouse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

// Mark the class as a Spring Boot application and implement CommandLineRunner
@SpringBootApplication
public class Hw1Application implements CommandLineRunner {
    // Create a static list to store instances of Warehouse
    public static List<Warehouse> warehouses;

    // Main method to run the Spring Boot application
    public static void main(String[] args) {
        SpringApplication.run(Hw1Application.class, args);
    }

    // Override the run method from CommandLineRunner
    @Override
    public void run(String... args) {
        // Create a new list to store instances of Warehouse
        warehouses = new ArrayList<>();

        // Create an instance of Warehouse
        Warehouse warehouse1 = new Warehouse();
        // Set properties of warehouse1
        warehouse1.setId(1);
        warehouse1.setIndustry("Computers");
        warehouse1.setFounder("Alan Turing");

        // Create instances of Product
        Product product1 = new Product();
        // Set properties of product1
        product1.setName("Macbook");
        product1.setFlavour("Unix");
        product1.setPrice(1059);
        product1.setSlogan("Think Different");

        Product product2 = new Product();
        // Set properties of product2
        product2.setName("HP spectre");
        product2.setFlavour("Windows");
        product2.setPrice(2099);
        product2.setSlogan("Make it Matter Keep Reinventing");

        // Create a list to store instances of Product
        List<Product> products = new ArrayList<>();
        // Add products to the list
        products.add(product1);
        products.add(product2);

        // Set the list of products for warehouse1
        warehouse1.setProducts(products);

        // Add warehouse1 to the list of warehouses
        warehouses.add(warehouse1);
    }
}
