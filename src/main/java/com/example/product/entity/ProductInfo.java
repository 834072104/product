package com.example.product.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data //lombok的getset方法产生注释
//@Table(name = "product_info") //此处对应数据库的表名。但下面的类名和数据库一致，可直接被找到
@Entity
public class ProductInfo {
    /*商品id*/
    @Id //主键
    private String productId;

    /*商品名称*/
    private String productName;

    /*商品单价*/
    private BigDecimal productPrice;

    /*商品库存*/
    private Integer productStock;

    /*商品描述*/
    private String productDescription;

    /*商品小图*/
    private String productIcon;

    /*商品状态*/
    private Integer productStatus;

    /*类目编号*/
    private Integer categoryType;

    /*创建时间*/
    private Date createTime;
    private Date updateTime;
}
