package com.dev.shopserver.service.impl;

import com.dev.shopserver.dto.ProductDTO;
import com.dev.shopserver.mapper.ProductMapper;
import com.dev.shopserver.mapper.UserMapper;
import com.dev.shopserver.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final UserMapper userMapper;

    @Override
    public ProductDTO register(String userId, ProductDTO productDTO) {
        int accountId = userMapper.getAccountId(userId);
        productDTO.setAccountId(accountId);
        productDTO.setProductStatus(ProductDTO.Status.SELLING);
        productDTO.setCreateDate(new Date());
        productDTO.setUpdateDate(new Date());
        productDTO.setReviewCount(0);
        productDTO.setTotalStarRating(0);
        productDTO.setPurchaseCount(0);

        productMapper.register(productDTO);
        return productDTO;
    }

    @Override
    public List<ProductDTO> getProducts(String userId){
        int accountId = userMapper.getAccountId(userId);
        return productMapper.getMyProducts(accountId);
    }

    @Override
    public void updateProducts(String userId, ProductDTO productDTO){
        int accountId = userMapper.getAccountId(userId);
        productDTO.setAccountId(accountId);
        productMapper.updateProduct(productDTO);
    }

    @Override
    public void deleteProduct(String userId, int productId){
        int accountId = userMapper.getAccountId(userId);
        productMapper.deleteProduct(accountId, productId);
    }
}
