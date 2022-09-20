package com.mashibing.mapper;

import com.mashibing.bean.ZhCustomer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 业主信息表 Mapper 接口
 * </p>
 *
 * @author lian
 * @since 2020-04-18
 */
public interface ZhCustomerMapper extends BaseMapper<ZhCustomer> {

    /**
     * 查询全部业主信息
     * @return 查询的全部业主信息结果
     */
    List<ZhCustomer> selectAll();

}
