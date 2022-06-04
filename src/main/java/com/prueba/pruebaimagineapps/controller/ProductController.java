package com.prueba.pruebaimagineapps.controller;

import com.prueba.pruebaimagineapps.model.Product;
import com.prueba.pruebaimagineapps.model.User;
import com.prueba.pruebaimagineapps.service.ProductService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductController {

    private final Logger LOOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping ("")
    public String show() {
        return "productos/show";
    }

    @GetMapping ("/create")
    public String create(){
        return "productos/create";
    }

    @PostMapping ("/save")
    public String save(Product product){
        User user = new User(1,"Fermin Colorado", "fermincolorado","fermin.ciro@rsumer.edu.co", "Cll 25 a 38", "3023290274", "ADMIN", "12345678");
        product.setUser(user);
        productService.save(product);
        LOOGGER.info("Este es el objeto del prodcuto {}", product);
        return "redirect:/productos";

    }

}
