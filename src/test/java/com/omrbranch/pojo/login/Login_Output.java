package com.omrbranch.pojo.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login_Output {
    private int status;
    private String message;
    private DataLogin data;
    private String refer_msg;
    private int cart_count;
    private String role;
}