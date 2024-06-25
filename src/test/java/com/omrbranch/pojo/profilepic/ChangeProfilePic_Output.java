package com.omrbranch.pojo.profilepic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeProfilePic_Output {
    private int status;
    private String message;
    private DataProfilePic data;
    private int cart_count;
}