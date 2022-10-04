package com.dev.shopserver.controller;


import com.dev.shopserver.dto.ProductDTO;
import com.dev.shopserver.service.impl.ProductServiceImpl;
import com.dev.shopserver.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;
    private final UserServiceImpl userService;

    public ProductController(ProductServiceImpl productService, UserServiceImpl userService){
        this.productService = productService;
        this.userService = userService;
    }


    public void registerProduct(ProductDTO productDTO){

    }

    public void updateProduct(int productId){

    }

    public void productInfo(){

    }

    public void deleteProducts(){

    }
}
