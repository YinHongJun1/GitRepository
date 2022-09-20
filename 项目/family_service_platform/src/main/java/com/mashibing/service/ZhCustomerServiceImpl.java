package com.mashibing.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mashibing.bean.ZhCustomer;
import com.mashibing.bean.ZhCustomerEstate;
import com.mashibing.mapper.ZhCustomerEstateMapper;
import com.mashibing.mapper.ZhCustomerMapper;
import com.mashibing.vo.CustomerMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 业主信息表 服务实现类
 * </p>
 *
 * @author lian
 * @since 2020-04-18
 */
@Service
public class ZhCustomerServiceImpl extends ServiceImpl<ZhCustomerMapper, ZhCustomer> implements ZhCustomerService {
    @Resource
    private ZhCustomerMapper zhCustomerMapper;

    private ZhCustomerEstateMapper zhCustomerEstateMapper;

    @Override
    public Integer insertCustomer(ZhCustomer zhCustomer) {
        Integer result = 0;
        QueryWrapper<ZhCustomer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_code",zhCustomer.getCustomerCode());
        ZhCustomer zhCustomer1 = zhCustomerMapper.selectOne(queryWrapper);
        if(zhCustomer1 == null){
            result = zhCustomerMapper.insert(zhCustomer);
        }
        return result;
    }

    /**
     * 查询全部业主信息
     * @return 全部业主信息结果
     */
    @Override
    public List<ZhCustomer> selectAllCustomer() {
        List<ZhCustomer> zhCustomers = zhCustomerMapper.selectAll();
        return zhCustomers;
    }

    @Override
    public List<ZhCustomer> selectCustomerByColumnAndValue(String column,String value){
        QueryWrapper<ZhCustomer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(column,value);
        List<ZhCustomer> zhCustomers = zhCustomerMapper.selectList(queryWrapper);

        return zhCustomers;
    }

    @Override
    public List<ZhCustomer> selectByCustomerByCustomerType(String customerType) {
        List<ZhCustomer> zhCustomers;
        if (customerType.equals("")) {
            return selectAllCustomer();
        } else {
            QueryWrapper<ZhCustomer> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("customer_type", customerType);
            zhCustomers = zhCustomerMapper.selectList(queryWrapper);
        }
        return zhCustomers;
    }

    @Override
    public Integer updateCustomerStatusByCustomerCode(String customerCodes, String status) {
        Integer result = 0;
        UpdateWrapper<ZhCustomer> updateWrapper = new UpdateWrapper<>();
        if(customerCodes.contains("|")){
            // 需要去拆分具体的业主编码
            String[] codes = customerCodes.split("[|]");
            for (int i = 0; i < codes.length; i++) {
                // 需要重新new一个UpdateWrapper,否则查询条件会累加
                UpdateWrapper<ZhCustomer> updateWrapper1 = new UpdateWrapper<>();
                updateWrapper1.set("customer_status",status).eq("customer_code",codes[i]);
                result = zhCustomerMapper.update(null,updateWrapper1);
            }
            return result;
        }else{
            updateWrapper.set("customer_status",status).eq("customer_code",customerCodes);
            result = zhCustomerMapper.update(null,updateWrapper);
        }
        return result;
    }

    /**
     * 查询优化方法，统一查询入口
     * @param customerMessage 用户传递的参数
     * @return
     */
    @Override
    public List<ZhCustomer> selectCustomer(CustomerMessage customerMessage) {
        QueryWrapper<ZhCustomer> queryWrapper = new QueryWrapper<>();
        // (根据两个参数)保证column和value有值
        if(!StringUtils.isEmpty(customerMessage.getColumn()) && !StringUtils.isEmpty(customerMessage.getValue())){
            queryWrapper.eq(customerMessage.getColumn(),customerMessage.getValue());
        }
        // (根据类型)保证customer_type有值
        if(!StringUtils.isEmpty(customerMessage.getCustomerType())){
            queryWrapper.eq("customer_type",customerMessage.getCustomerType());
        }
        List<ZhCustomer> zhCustomers = zhCustomerMapper.selectList(queryWrapper);

        return zhCustomers;
    }

    @Override
    public Integer insertAll(List<ZhCustomer> customers, String company) {
        Integer result = 0;
        if (customers.size() > 0){
            for (ZhCustomer zhcustomer: customers) {
                zhcustomer.setCompany(company);
                result = zhCustomerMapper.insert(zhcustomer);
            }
        }
        return result;
    }

    @Override
    public Integer insertCustomerOrEstate(ZhCustomerEstate zhCustomerEstate) {
        Integer result = 0;
        if (zhCustomerEstate != null){
            result = zhCustomerEstateMapper.insert(zhCustomerEstate);
            return result;
        }
        return result;
    }
}
