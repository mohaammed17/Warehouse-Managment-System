// Import statements for required classes and packages
package co2103.hw1.controller;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Product;
import co2103.hw1.domain.Warehouse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import static co2103.hw1.Hw1Application.warehouses;

@Controller
public class ProductsController {

    // Initiates a binder for the "product" object to apply validation
    @InitBinder("product")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProductValidator());
    }

    // Handles GET requests to "/products" endpoint
    @GetMapping("/products")
    public String listProducts(@RequestParam("warehouse") int warehouseId, Model model) {
        // Retrieve the corresponding warehouse based on the warehouseId
        Warehouse warehouse = null;

        for (Warehouse w : warehouses) {
            if (w.getId() == warehouseId) {
                warehouse = w;
                break;
            }
        }

        // Add the list of products to the model
        model.addAttribute("products", warehouse.getProducts());
        model.addAttribute("warehouse", warehouse);

        // Returns the view name "products/list"
        return "products/list";
    }

    // Handles GET requests to "/newProduct" endpoint
    @RequestMapping("/newProduct")
    public String newProduct(@RequestParam("warehouse") int warehouse, Model model) {
        // Adds a new Product object and the warehouse ID to the model
        model.addAttribute("product", new Product());
        model.addAttribute("warehouse", warehouse);

        // Returns the view name "products/form"
        return "products/form";
    }

    // Handles POST requests to "/addProduct" endpoint
    @PostMapping("/addProduct")
    public String addProduct(@Valid @ModelAttribute Product product, BindingResult results,
                             @RequestParam("warehouse") int warehouse, Model model) {
        // Adds the warehouse ID to the model
        model.addAttribute("warehouse", warehouse);

        // Checks for validation errors
        if (results.hasErrors()) {
            // If validation fails, returns to the form view
            return "products/form";
        }

        // Adds the new product to the corresponding warehouse
        for (Warehouse w : warehouses) {
            if (w.getId() == warehouse) {
                w.getProducts().add(product);
            }
        }

        // Redirects to the warehouses page
        return "redirect:/warehouses";
    }
}

