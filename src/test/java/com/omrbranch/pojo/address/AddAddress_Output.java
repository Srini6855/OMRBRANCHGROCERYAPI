package com.omrbranch.pojo.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddAddress_Output {
    private int status;
    private String message;
    private int address_id;
}