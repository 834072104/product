package com.example.product.ViewObject;

import com.example.product.entity.ProductCategory;
import jdk.nashorn.internal.codegen.DumpBytecode;
import lombok.Data;

@Data
public class ResultVO<T> {
    /*错误码*/
    private Integer code;
    /*提示信息*/
    private String msg;
    /*具体数据*/
    private T data;
}
