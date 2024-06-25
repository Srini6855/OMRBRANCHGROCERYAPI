package com.omrbranch.pojo.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityList_Output {
    private int status;
    private String message;
    private ArrayList <DatumCity> data;
}