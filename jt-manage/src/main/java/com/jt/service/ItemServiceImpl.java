package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.pojo.Item;
import com.jt.vo.EasyUITable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.mapper.ItemMapper;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;

	//select * from tb_item limit (page-1)rows,rows;
//	@Override
//	public EasyUITable findItemByPage(Integer page, Integer rows) {
//		long total = itemMapper.selectCount(null);
//		int start=(page-1)*rows;
//		List<Item> itemList=itemMapper.findItemByPage(start,rows);
//		return new EasyUITable(total,itemList);
//	}

	//new Page<>(查询的页数, 每页条数);
	//如果使用MP的方式进行分页查询,则需要配置拦截器.
	@Override
	public EasyUITable findItemByPage(Integer page, Integer rows) {
		Page<Item> mpPage=new Page<>(page,rows);
		QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("updated");
		IPage<Item> itemIPage = itemMapper.selectPage(mpPage, queryWrapper);
		long total=itemIPage.getTotal();
		List<Item> itemList=itemIPage.getRecords();
		return new EasyUITable(total,itemList);
	}

	@Override
	public void saveItem(Item item) {
		item.setStatus(1)
				.setCreated(new Date())
				.setUpdated(item.getCreated());//保证时间一致.
		itemMapper.insert(item);
	}
}
