package com.jt.controller;

import com.jt.vo.EasyUITable;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.service.ItemService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;


	/*
	 * url:http://localhost:8091/item/query?page=1&rows=50
	 * args: 1.page=1 页数   2.rows 行数
	 *   返回值: EasyUITable对象
	 */
	@ApiOperation("查询商品")
	@RequestMapping("/query")
	public EasyUITable findItemByPage(@ApiParam(name = "页数",value = "page")Integer page,@ApiParam(name ="行数",value = "rows")Integer rows){
		return itemService.findItemByPage(page,rows);
	}


}
