package com.example.product.service;

import com.example.product.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
