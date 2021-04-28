package com.jt.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@ApiOperation("返回页面")
	@RequestMapping("/page/{moduleName}")
	public String module(@ApiParam(value = "value",name = "moduleName")@PathVariable String moduleName) {
		return moduleName;
	}

}
