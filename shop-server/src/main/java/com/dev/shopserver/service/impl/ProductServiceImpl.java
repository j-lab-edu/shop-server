package com.dev.shopserver.service.impl;

import com.dev.shopserver.dto.ProductDTO;
import com.dev.shopserver.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    public void register(String id, ProductDTO productDTO) {
    }

    public List<ProductDTO> getProducts(int accountId){
        return null;
    }

    public void updateProducts(ProductDTO productDTO){

    }

    public void deleteProducts(ProductDTO productDTO){

    }
}
