package com.example.product.service.impl;

import com.example.product.ProductApplicationTests;
import com.example.product.entity.ProductCategory;
import com.example.product.service.ProductCategoryService;
import com.netflix.discovery.converters.Auto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@Component
public class ProductCategoryServiceImplTest extends ProductApplicationTests{
    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> list=productCategoryService.findByCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(list.size()>0);
    }

}