package com.omrbranch.pojo.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatumProduct {
    private String image;
    private String type;
    private String text;
    private int id;
    private int category_id;
}