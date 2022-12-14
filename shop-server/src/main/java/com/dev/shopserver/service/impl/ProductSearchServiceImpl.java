package com.dev.shopserver.service.impl;

import com.dev.shopserver.common.SearchCriteria;
import com.dev.shopserver.dto.ProductDTO;
import com.dev.shopserver.mapper.ProductSearchMapper;
import com.dev.shopserver.service.ProductSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductSearchServiceImpl implements ProductSearchService {
    private final ProductSearchMapper productSearchMapper;

    @Override
    public List<ProductDTO> searchProducts(SearchCriteria searchCriteria) {
        if (searchCriteria.getProductName() == null
                && searchCriteria.getCategoryId() == null) {
            throw new NullPointerException("제품 이름 또는 카테고리를 입력해주세요.");
        }
        return productSearchMapper.searchProducts(searchCriteria);
    }
}
