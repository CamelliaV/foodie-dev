package com.learn.resp;

import lombok.Data;

import java.util.List;

@Data
public class CategoryResp {
    private Integer id;
    private String name;
    private Integer type;
    private Integer fatherId;
    private List<CategoryResp> children;
}
