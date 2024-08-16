package com.learn.resp;

import lombok.Data;

import java.util.List;

@Data
public class RecItemsResp {
    private Integer categoryId;
    private String categoryName;
    private String slogan;
    private String categoryImage;
    private String backgroundColor;

    private List<ItemResp> itemList;

}
