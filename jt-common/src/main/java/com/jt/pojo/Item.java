package com.jt.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@JsonIgnoreProperties(ignoreUnknown=true) //表示JSON转化时忽略未知属性
@TableName("tb_item")
@Data
@Accessors(chain=true)
@EqualsAndHashCode(callSuper = true)
//子类继承父类，父类实现了序列号接口，所以子类也实现了序列号接口
@ApiModel("tb_item表")
public class Item extends BasePojo{
	@TableId(type=IdType.AUTO)
	@ApiModelProperty("商品id")
	private Long id;				//商品id
	@ApiModelProperty("商品标题")
	private String title;			//商品标题
	@ApiModelProperty("商品卖点信息")
	private String sellPoint;		//商品卖点信息
	@ApiModelProperty("商品价格")
	private Long   price;			//商品价格 Long > double
	@ApiModelProperty("商品数量")
	private Integer num;			//商品数量
	@ApiModelProperty("条形码")
	private String barcode;			//条形码
	@ApiModelProperty("商品图片信息")
	private String image;			//商品图片信息   1.jpg,2.jpg,3.jpg
	@ApiModelProperty("商品的分类id")
	private Long   cid;				//表示商品的分类id
	@ApiModelProperty("1正常，2下架")
	private Integer status;			//1正常，2下架
	
	//为了满足页面调用需求,添加get方法
	public String[] getImages(){
		
		return image.split(",");
	}
}
