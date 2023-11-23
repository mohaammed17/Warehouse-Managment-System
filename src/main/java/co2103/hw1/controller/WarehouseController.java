package co2103.hw1.controller;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Warehouse;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class WarehouseController {

    @InitBinder
    protected void initBinder(WebDataBinder Binder){
        Binder.addValidators(new WarehouseValidator());
    }

    // Handles GET requests for "/warehouses", retrieves the list of warehouses, and displays the warehouse list view.
    @GetMapping("/warehouses")
    public String warehouses(Model model) {
        model.addAttribute("warehouses", Hw1Application.warehouses);
        return "warehouses/list";
    }

    // Handles GET requests for "/newWarehouse", prepares a new Warehouse instance, and displays the warehouse form view.
    @RequestMapping("/newWarehouse")
    public String newWarehouse(Model model) {
        model.addAttribute("warehouse", new Warehouse());
        return "warehouses/form"; // Adjusted the path here
    }

    // Handles POST requests for "/addWarehouse", adds a new warehouse to the list, and redirects to the warehouse list view.
    @PostMapping("/addWarehouse")
    public String addWarehouse(@Valid @ModelAttribute Warehouse warehouse, BindingResult results) {
        if(results.hasErrors()){
            return "warehouses/form";
        }
        Hw1Application.warehouses.add(warehouse);
        return "redirect:/warehouses";
    }
}

