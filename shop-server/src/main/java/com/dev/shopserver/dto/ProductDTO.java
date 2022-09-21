package com.dev.shopserver.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductDTO {
    public enum Status{
        SELLING, SOLDOUT, DELETED
    }
    private int productId;
    private long price;
    private int accountId;
    private String productName;
    private Status productStatus;
    private Date createDate;
    private Date updateDate;
    private long deliveryCharge;
    private long reviewCount;
    private long totalStarRating;
    private int categoryId;
    private long productQuantity;
    private long purchaseCount;

    public ProductDTO(@NonNull int productId, long price, int accountId, String productName, Status productStatus,
                      Date updateDate, long deliveryCharge, long reviewCount, long totalStarRating, int categoryId,
                      long productQuantity, long purchaseCount){
        this.productId = productId;
        this.price = price;
        this.accountId = accountId;
        this.productName = productName;
        this.productStatus = productStatus;
        this.createDate = new Date();
        this.updateDate = updateDate;
        this.deliveryCharge = deliveryCharge;
        this.reviewCount = reviewCount;
        this.totalStarRating = totalStarRating;
        this.productQuantity = productQuantity;
        this.purchaseCount = purchaseCount;
    }
}
