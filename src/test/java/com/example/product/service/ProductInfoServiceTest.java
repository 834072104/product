package com.example.product.service;

import com.example.product.ProductApplicationTests;
import com.example.product.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductInfoServiceTest extends ProductApplicationTests {
    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list=productInfoService.findUpAll();
        Assert.assertTrue(list.size()>0);
    }

}