package com.prueba.pruebaimagineapps.controller;

import com.prueba.pruebaimagineapps.model.Product;
import com.prueba.pruebaimagineapps.model.User;
import com.prueba.pruebaimagineapps.service.ProductService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final Logger LOOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products/show";
    }

    @GetMapping("/create")
    public String create() {
        return "products/create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        User user = new User(1, "Fermin Colorado", "fermincolorado", "fermin.ciro@rsumer.edu.co", "Cll 25 a 38", "3023290274", "ADMIN", "12345678");
        product.setUser(user);
        productService.save(product);
        LOOGGER.info("Este es el objeto del prodcuto {}", product);
        return "redirect:/products";
    }

    @GetMapping ("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Product product = new Product();
        Optional<Product> optionalProduct=productService.get(id);
        product= optionalProduct.get();

        LOOGGER.info("Producto buscado: {}", product);
        model.addAttribute("product", product);
        return "products/edit";
    }

    @PostMapping ("/update")
    public String update(Product product){
        productService.update(product);
        return "redirect:/products";
    }


}
