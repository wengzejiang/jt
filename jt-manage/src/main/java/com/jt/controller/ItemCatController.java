package com.jt.controller;

import com.jt.service.ItemCatService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Package: com.jt.controller
 * Description： TODO
 * Author: wengzejiang
 * Date: Created in 2021/4/29 0029 22:37
 * Company: 暂无
 * Version: 0.0.1
 * Modified By:
 */
@Controller
@ResponseBody
@RequestMapping("/item/cat")
@Api(tags = "叶子类目")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    /**
     * 业务:根据商品分类ID查询商品分类名称
     * url: /item/cat/queryItemName
     * 参数: {itemCatId:val}
     * 返回值: 商品分类名称 name
     *
     * 知识扩展:
     * 问题:用户提交的参数是如何给方法的参数赋值?
     * 铺垫:
     *      url:http://localhost:8091/user?id=1&name=tomcat猫
     *      1.SpringMVC封装了Servlet request对象 response对象
     *      2.servlet中获取用户的参数
     * 知识讲解:
     *      1.利用Serlvet对象的Request对象利用getParameter方法动态获取
     *  属性的值.取值的名称必须正确.否则获取的值必然为null
     *      String idString = request.getParameter("itemCatId");
     Long idLong = Long.parseLong(idString);

     2.SpringMVC将上述的操作进行封装.
     规定!!!!:springMVC中的参数名称,必须与页面中name属性的名称一致
     *      <input type="text" name="id" value="100"/>
     */
    @RequestMapping(value = "/queryItemName",method = RequestMethod.POST)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "itemCatId",value = "id值", required = true,paramType = "query",dataType = "long")
    )
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数错误")
    })
    public String findItemCatNameById(Long itemCatId){
        return itemCatService.findItemCatNameById(itemCatId);
    }


}
