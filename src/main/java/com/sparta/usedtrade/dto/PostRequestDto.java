package com.sparta.usedtrade.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String content;
    private int price;
    private String username;
}
