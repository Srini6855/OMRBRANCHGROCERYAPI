package com.omrbranch.globaldatas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GlobalDatas {
    private int statusCode;
    private String stateIdInString;
    private int stateIdInInteger;
    private int cityIdInInteger;
    private String logToken;
    private String addressId;
}