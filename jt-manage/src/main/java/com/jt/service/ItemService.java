package com.jt.service;

import com.jt.pojo.Item;
import com.jt.vo.EasyUITable;

public interface ItemService {

    EasyUITable findItemByPage(Integer page, Integer rows);

    void saveItem(Item item);
}
