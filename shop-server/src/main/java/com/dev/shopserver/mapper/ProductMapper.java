package com.dev.shopserver.mapper;

import com.dev.shopserver.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    void register(ProductDTO productDTO);
    List<ProductDTO> getMyProducts(int accountId);
    void updateProduct(ProductDTO productDTO);
    void deleteProduct(int accountId, int productId);
}
