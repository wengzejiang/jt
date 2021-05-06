package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemCatMapper;
import com.jt.pojo.ItemCat;
import com.jt.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
@Service
public class ItemCatServiceImpl implements ItemCatService{

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public String findItemCatNameById(Long itemCatId) {
        ItemCat itemCat = itemCatMapper.selectById(itemCatId);
        return itemCat.getName();
    }

    //查询结果是VO对象
    //问题:VO中的数据信息从哪里来?
    //数据来源: VO的数据应该从数据库记录中转化而来.
    @Override
    public List<EasyUITree> findItemCatListByParentId(Long parentId) {
        //1.动态获取数据库记录信息
        List<ItemCat> itemCatList=selectItemCatListByParentId(parentId);
        //2.定义空的VOList信息
        List<EasyUITree> treeList=new ArrayList<EasyUITree>(itemCatList.size());
        //3.将itemCat对象转化为EasyUITree对象
        for (ItemCat itemCat: itemCatList) {
            Long id=itemCat.getId();
            String text=itemCat.getName();
            //如果是父级则closed,否则open
            String state=itemCat.getIsParent()?"closed":"open";
            EasyUITree uiTree=new EasyUITree(id,text,state);
            treeList.add(uiTree);
        }
        System.out.println(treeList);
        return treeList;
    }

    private List<ItemCat> selectItemCatListByParentId(Long parentId) {
        QueryWrapper<ItemCat> itemCatQueryWrapper = new QueryWrapper<>();
        //(字段信息,查询的值)
        itemCatQueryWrapper.eq("parent_id",parentId);
        return itemCatMapper.selectList(itemCatQueryWrapper);
    }
}
