package com.dev.shopserver.controller;


import com.dev.shopserver.aop.LogExecutionTime;
import com.dev.shopserver.aop.LoginCheck;
import com.dev.shopserver.dto.ProductDTO;
import com.dev.shopserver.service.impl.ProductServiceImpl;
import com.dev.shopserver.service.impl.UserServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @LoginCheck(checkLevel = LoginCheck.UserLevel.SELLER)
    @PostMapping("/register")
    public ResponseEntity<ProductDTO> registerProduct(@SessionAttribute("LOGIN_SELLER_ID") String userId,
                                                      @RequestBody ProductDTO productDTO){
        ProductDTO registerProduct = productService.register(userId, productDTO);
        return new ResponseEntity<>(registerProduct, HttpStatus.CREATED);
    }

    @LogExecutionTime
    @LoginCheck(checkLevel = LoginCheck.UserLevel.SELLER)
    @PostMapping("/get-products")
    public ResponseEntity<List<ProductDTO>> productInfo(@SessionAttribute("LOGIN_SELLER_ID") String userId){
        List<ProductDTO> productList = productService.getProducts(userId);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @LoginCheck(checkLevel = LoginCheck.UserLevel.SELLER)
    @PatchMapping("/update/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@SessionAttribute("LOGIN_SELLER_ID") String userId,
                              @PathVariable(name = "productId") int productId,
                              @RequestBody UpdateProductRequest updateProductRequest){
        ProductDTO productUpdateDTO = ProductDTO.builder()
                .productId(productId)
                .price(updateProductRequest.getPrice())
                .productName(updateProductRequest.getProductName())
                .productQuantity(updateProductRequest.getProductQuantity())
                .productStatus(updateProductRequest.getProductStatus())
                .updateDate(new Date())
                .categoryId(updateProductRequest.getCategoryId())
                .deliveryCharge(updateProductRequest.getDeliveryCharge())
                .purchaseCount(updateProductRequest.getPurchaseCount())
                .reviewCount(updateProductRequest.getReviewCount())
                .totalStarRating(updateProductRequest.getTotalStarRating())
                .build();
        productService.updateProducts(userId, productUpdateDTO);
        return new ResponseEntity<>(productUpdateDTO, HttpStatus.OK);
    }



    @LoginCheck(checkLevel = LoginCheck.UserLevel.SELLER)
    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@SessionAttribute("LOGIN_SELLER_ID") String userId,
                               @PathVariable(name = "productId") int productId){
        productService.deleteProduct(userId, productId);
    }

    @Getter
    @Setter
    private static class UpdateProductRequest{
        private long price;
        private String productName;
        private ProductDTO.Status productStatus;
        private long deliveryCharge;
        private long reviewCount;
        private long totalStarRating;
        private int categoryId;
        private long productQuantity;
        private long purchaseCount;
    }
}
