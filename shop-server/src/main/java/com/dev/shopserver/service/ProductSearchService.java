package com.dev.shopserver.service;

import com.dev.shopserver.common.SearchCriteria;
import com.dev.shopserver.dto.ProductDTO;

import java.util.List;

public interface ProductSearchService {
    List<ProductDTO> searchProducts(SearchCriteria searchCriteria);
}
