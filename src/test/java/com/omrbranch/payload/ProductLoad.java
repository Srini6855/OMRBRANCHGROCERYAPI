package com.omrbranch.payload;

import com.omrbranch.pojo.product.SearchProduct_Input;

public class ProductLoad {
    public SearchProduct_Input searchProduct (String productName) {
        return new SearchProduct_Input (productName);
    }
}