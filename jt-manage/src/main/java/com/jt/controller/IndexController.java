package com.jt.controller;

import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "返回js页面")
public class IndexController {

	@ApiOperation("返回页面")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "moduleName",value = "jsp页面", required = true,paramType = "path",dataType = "string")
	})
	@ApiResponses({
			@ApiResponse(code=404,message="请求路径错误或不存在")
	})
	@RequestMapping(value="/page/{moduleName}",method = RequestMethod.GET)
	public String module(@ApiParam(value = "value",name = "moduleName")@PathVariable String moduleName) {
		return moduleName;
	}

}
