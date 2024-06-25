package com.omrbranch.pojo.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchProduct_Output {
    private int status;
    private String message;
    private ArrayList <DatumProduct> data;
    private String currency;
}