package com.example.product.controller;

import com.example.product.ViewObject.ProductInfoVO;
import com.example.product.ViewObject.ProductVO;
import com.example.product.ViewObject.ResultVO;
import com.example.product.entity.ProductCategory;
import com.example.product.entity.ProductInfo;
import com.example.product.service.ProductCategoryService;
import com.example.product.service.ProductInfoService;
import com.example.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品
 *
 * */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductInfoService productInfoService;
    /**
     * 1.查询所有在架商品
     * 2.获取类目type列表
     * 3.查询类目
     * 4.构造数据
     * */
    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        //1.查询所有在架商品
        List<ProductInfo> productInfoList=productInfoService.findUpAll();

        //2.获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //3.从数据库查询类目
        List<ProductCategory> categoryList=productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //4.构造数据
        List<ProductVO> productVOList=new ArrayList<>();
        for(ProductCategory productCategory : categoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productCategory.getCategoryType() == productInfo.getCategoryType()){
                ProductInfoVO productInfoVO = new ProductInfoVO();
                BeanUtils.copyProperties(productInfo,productInfoVO);
                productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
