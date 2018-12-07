package com.example.product.service.impl;

import com.example.product.enmus.ProductStatusEnum;
import com.example.product.entity.ProductInfo;
import com.example.product.repository.ProductInfoRepository;
import com.example.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
