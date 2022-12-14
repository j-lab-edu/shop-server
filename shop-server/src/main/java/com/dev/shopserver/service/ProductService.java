package com.dev.shopserver.service;

import com.dev.shopserver.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO register(String userId, ProductDTO productDTO);

    List<ProductDTO> getProducts(String userId);

    void updateProducts(String userId, ProductDTO productDTO);

    void deleteProduct(String userId, int productId);
}
