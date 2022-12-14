package com.dev.shopserver.controller;


import com.dev.shopserver.common.SearchCriteria;
import com.dev.shopserver.dto.ProductDTO;
import com.dev.shopserver.service.impl.ProductSearchServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/search")
@RequiredArgsConstructor
public class ProductSearchController {
    private final ProductSearchServiceImpl productSearchService;


    @GetMapping
    public SearchProductsResponse searchProducts(@RequestBody SearchCriteria searchCriteria){
        return new SearchProductsResponse(productSearchService.searchProducts(searchCriteria));

    }


    @Getter
    @AllArgsConstructor
    private static class SearchProductsResponse{
        private List<ProductDTO> productDTOList;
    }

}
