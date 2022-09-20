package com.mashibing.service;

import com.mashibing.bean.ZhCustomer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mashibing.bean.ZhCustomerEstate;
import com.mashibing.vo.CustomerMessage;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 业主信息表 服务类
 * </p>
 *
 * @author lian
 * @since 2020-04-18
 */
public interface ZhCustomerService extends IService<ZhCustomer> {

    Integer insertCustomer(ZhCustomer zhCustomer);

    /**
     *
     * @return
     */
    List<ZhCustomer> selectAllCustomer();

    /**
     *
     * @return 查询到的业主信息
     */
    List<ZhCustomer> selectCustomerByColumnAndValue(String column,String value);

    /**
     * 根据业主类型来进行查询的业主信息
     * @param customerType 业主类型
     */
    List<ZhCustomer> selectByCustomerByCustomerType(String customerType);

    /**
     *  根据前端的业主编号信息来修改业主状态
     * @param customerCodes:此参数为业主编码，如果出现多个业主编码，会通过“|”进行分割
     * @param status： 状态码： 1 表示启用   2 表示禁用
     * @return 修改业主状态信息的结果
     */
    Integer updateCustomerStatusByCustomerCode(String customerCodes, String status);

    /**
     * 查询入口（优化查询）
     * 通过用户传递的参数来进行对应的查询
     * @param customerMessage 用户传递的参数
     * @return 查询结果：业主信息
     */
    List<ZhCustomer> selectCustomer(@RequestBody CustomerMessage customerMessage);

    /**
     * 接收解析Excel表格中的所有数据，以实体类Zhcustomer集合类接收，并且根据公司来新增业主数据
     * @param customers 业主信息
     * @param company 公司信息
     * @return
     */
    Integer insertAll(List<ZhCustomer> customers,String company);

    /**
     * 新增业主入住信息
     * @param zhCustomerEstate 业主与房产关系数据
     * @return 是否添加成功
     */
    Integer insertCustomerOrEstate(ZhCustomerEstate zhCustomerEstate);

}
