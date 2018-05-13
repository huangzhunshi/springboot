package com.yihui.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message<T> {
    private int code;
    private String message;
    private T data;
}
