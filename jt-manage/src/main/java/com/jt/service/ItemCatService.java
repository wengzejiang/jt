package com.jt.service;

import com.jt.vo.EasyUITree;

import java.util.List;

/**
 * Package: com.jt.service
 * Description： TODO
 * Author: wengzejiang
 * Date: Created in 2021/4/29 0029 22:35
 * Company: 暂无
 * Version: 0.0.1
 * Modified By:
 */
public interface ItemCatService {
    String findItemCatNameById(Long itemCatId);

    List<EasyUITree> findItemCatListByParentId(Long parentId);
}
