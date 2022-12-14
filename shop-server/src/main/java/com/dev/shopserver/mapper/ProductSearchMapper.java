package com.dev.shopserver.mapper;

import com.dev.shopserver.common.SearchCriteria;
import com.dev.shopserver.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductSearchMapper {
    List<ProductDTO> searchProducts(SearchCriteria searchCriteria);
}
