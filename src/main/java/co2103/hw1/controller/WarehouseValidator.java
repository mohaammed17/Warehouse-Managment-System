package co2103.hw1.controller;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Warehouse;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

// Validator for the Warehouse class, implementing the Spring Validator interface.
public class WarehouseValidator implements Validator {
    // Checks if the validator supports the given class.
    @Override
    public boolean supports(Class<?> clazz){
        return Warehouse.class.equals(clazz);
    }

    // Performs validation on the Warehouse object.
    @Override
    public void validate(Object target, Errors errors){
        // Casts the target object to a Warehouse instance.
        Warehouse w = (Warehouse) target;

        // Checks if the warehouse ID already exists in the system.
        for(Warehouse wa : Hw1Application.warehouses){
            if(wa.getId() == w.getId()){
                errors.rejectValue("id", "", "ID already exists");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "founder","", "Enter the Founder name" );
        // Validates that the founder name is not empty or whitespace.

        // Validates that the industry is not empty or whitespace.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"industry", "", "Enter the Industry" );
    }

}
