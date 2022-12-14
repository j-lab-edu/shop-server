package com.dev.shopserver.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    public enum Status{
        SELLING, DELETED
    }
    private Integer productId;
    private Long price;
    private Integer accountId;
    private String productName;
    private Status productStatus;
    private Date createDate;
    private Date updateDate;
    private Long deliveryCharge;
    private Long reviewCount;
    private Long totalStarRating;
    private Integer categoryId;
    private Long productQuantity;
    private Long purchaseCount;

    @Builder
    public ProductDTO(@NonNull Integer productId, Long price, Integer accountId, String productName, Status productStatus,
                      Date createDate, Date updateDate, Long deliveryCharge, Long reviewCount, Long totalStarRating,
                      Integer categoryId, Long productQuantity, Long purchaseCount){
        this.productId = productId;
        this.price = price;
        this.accountId = accountId;
        this.productName = productName;
        this.productStatus = productStatus;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.deliveryCharge = deliveryCharge;
        this.reviewCount = reviewCount;
        this.totalStarRating = totalStarRating;
        this.categoryId = categoryId;
        this.productQuantity = productQuantity;
        this.purchaseCount = purchaseCount;
    }
}
