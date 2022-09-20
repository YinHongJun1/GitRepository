package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Category;

/**
 * 第三天
 */
public interface CategoryService extends IService<Category> {

    public void remove(Long id);

}
