package com.jt.vo;

import com.jt.pojo.Item;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Package: com.jt.vo
 * Description： TODO
 * Author: wengzejiang
 * Date: Created in 2021/4/28 0028 21:53
 * Company: 暂无
 * Version: 0.0.1
 * Modified By:
 */
@ApiModel("EasyUITable的封装")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EasyUITable implements Serializable {
    @ApiModelProperty("记录总数")
    private Long total;
    @ApiModelProperty("每页的数据")
    private List<Item> rows;
}
