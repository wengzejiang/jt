package com.jt.controller;

import com.jt.vo.EasyUITable;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.service.ItemService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/item")
@Api(tags = "商品管理")
public class ItemController {
	
	@Autowired
	private ItemService itemService;


	/*
	 * url:http://localhost:8091/item/query?page=1&rows=50
	 * args: 1.page=1 页数   2.rows 行数
	 *   返回值: EasyUITable对象
	 */
	@ApiOperation("查询商品")
	@RequestMapping(value="/query",method = RequestMethod.GET)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page",value = "页数", required = true,paramType = "query",dataType = "int"),
			@ApiImplicitParam(name = "rows",value = "行数", required = true,paramType= "query",dataType = "int")
	})
	@ApiResponses({
			@ApiResponse(code=400,message="请求参数错误")
	})
	public EasyUITable findItemByPage(Integer page,Integer rows){
		return itemService.findItemByPage(page,rows);
	}




}
