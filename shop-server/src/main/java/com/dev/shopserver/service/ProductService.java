package com.dev.shopserver.service;

import com.dev.shopserver.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    void register(String id, ProductDTO productDTO);

    List<ProductDTO> getProducts(int accountId);

    void updateProducts(ProductDTO productDTO);

    void deleteProducts(ProductDTO productDTO);
}
