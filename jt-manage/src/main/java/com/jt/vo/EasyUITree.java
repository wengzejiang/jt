package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Package: com.jt.vo
 * Description： TODO
 * Author: wengzejiang
 * Date: Created in 2021/5/6 0006 21:00
 * Company: 暂无
 * Version: 0.0.1
 * Modified By:
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EasyUITree implements Serializable {
    private static final long serialVersionUID = -3374824151482249728L;
    private Long id;    //节点id信息
    private String text;    //节点名称
    private String state;      //节点状态  open/closed
}
