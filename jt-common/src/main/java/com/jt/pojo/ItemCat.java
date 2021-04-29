package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Package: com.jt.pojo
 * Description： TODO
 * Author: wengzejiang
 * Date: Created in 2021/4/29 0029 22:15
 * Company: 暂无
 * Version: 0.0.1
 * Modified By:
 */
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("tb_item_cat表")
@Accessors(chain = true)
@TableName("tb_item_cat")
@Data
public class ItemCat extends BasePojo {

    @TableId(type= IdType.AUTO)  //设置主键并且自增
    @ApiModelProperty("商品分类id号")
    private Long id;            //商品分类id号
    @ApiModelProperty("父级分类Id")
    private Long parentId;      //父级分类Id
    //如果有父子级关系,可以使用parentId进行关联
    @ApiModelProperty("名称")
    private String name;        //名称
    @ApiModelProperty("商品分类状态")
    private Integer status;     //商品分类状态
    @ApiModelProperty("排序号")
    private Integer sortOrder;  //排序号
    @ApiModelProperty("是否为父级")
    private Boolean isParent;   //是否为父级
    //tinyint 0 false /1 true
}
