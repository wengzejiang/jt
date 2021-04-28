package com.jt.pojo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

//pojo基类，完成2个任务，2个日期，实现序列化
@Data
@Accessors(chain=true)
@ApiModel("公共字段created/updated")
public class BasePojo implements Serializable{

	private static final long serialVersionUID=-561654145564656L;
	@ApiModelProperty("创建时间")
	private Date created;
	@ApiModelProperty("修改时间")
	private Date updated;

}
