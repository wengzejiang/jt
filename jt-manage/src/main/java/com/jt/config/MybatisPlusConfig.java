package com.jt.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Package: com.jt.config
 * Description： TODO
 * Author: wengzejiang
 * Date: Created in 2021/4/29 0029 21:04
 * Company: 暂无
 * Version: 0.0.1
 * Modified By:
 */
@Configuration
public class MybatisPlusConfig {

    //需要实现一个MP的分页的拦截器对象,交给Spring容器管理
    @Bean   //Map<方法名称,分页对象>
    public PaginationInterceptor paginationInterceptor() {

        return new PaginationInterceptor();
    }
    //将给对象交给Spring容器管理之后,如果需要可以直接注入引用.
    //springBoot整合MybatisPlus时执行分页操作时,自动的完成注入
    //.前提是需要提前实例化对象
}
