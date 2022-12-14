package com.dev.shopserver.common;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SearchCriteria {
    public enum SortCriteria{
        SALES_VOLUME, STAR_RATING, REVIEW, HIGH_PRICE, LOW_PRICE
    }

    private String productName;

    private Integer categoryId;

    private SortCriteria sortCriteria;

}
