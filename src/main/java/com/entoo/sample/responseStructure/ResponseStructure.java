package com.entoo.sample.responseStructure;

import lombok.Data;

@Data
public class ResponseStructure<T>
{
    private int httpStatus;
    private String message;
    private T body;
}
