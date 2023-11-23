package co2103.hw1.controller;

import co2103.hw1.domain.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;

public class ProductValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz){
        return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Name cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "slogan", "", "Slogan cannot be empty");

        // Validate flavour
        if (!isValidFlavour(product.getFlavour())) {
            errors.rejectValue("flavour", "", "Invalid flavour ");
        }

        // Validate price
        if (!isValidPrice(product.getPrice())) {
            errors.rejectValue("price", "", "Price must be between 1 and 3 (inclusive");
        }
    }

    private boolean isValidFlavour(String flavour) {
        List<String> allowedFlavours = Arrays.asList("Orange", "Banana", "Apple", "Strawberry");
        return allowedFlavours.contains(flavour);
        //return "Orange".equals(flavour) || "Banana".equals(flavour) || "Apple".equals(flavour);
    }

    private boolean isValidPrice(double price) {
        // checking if it's between 1 and 3 (inclusive)
        return price >= 1 && price <= 3;
    }
}
