package com.jt.service;

import com.jt.pojo.Item;
import com.jt.vo.EasyUITable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.mapper.ItemMapper;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMapper itemMapper;

	//select * from tb_item limit (page-1)rows,rows;
	@Override
	public EasyUITable findItemByPage(Integer page, Integer rows) {
		long total = itemMapper.selectCount(null);
		int start=(page-1)*rows;
		List<Item> itemList=itemMapper.findItemByPage(start,rows);
		return new EasyUITable(total,itemList);
	}
}
