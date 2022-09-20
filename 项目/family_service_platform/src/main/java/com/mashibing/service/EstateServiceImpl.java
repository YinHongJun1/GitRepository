package com.mashibing.service;

import com.mashibing.bean.FcEstate;
import com.mashibing.bean.TblCompany;
import com.mashibing.mapper.FcEstateMapper;
import com.mashibing.mapper.TblCompanyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:yhj
 * @Date:2022/8/11 - 08 - 11 - 23:15
 * @Description: com.mashibing.service.impl
 * @version: 1.0
 */
@Service
public class EstateServiceImpl implements EstateService {

    @Resource
    private TblCompanyMapper tblCompanyMapper ;

    @Resource
    private FcEstateMapper fcEstateMapper;

    @Override
    public List<TblCompany> selectCompany() {
        return tblCompanyMapper.selectCompany();
    }

    @Override
    public Integer insertEstate(FcEstate fcEstate) {
        System.out.println("fcEstate:"+fcEstate);
        Integer result = fcEstateMapper.insert(fcEstate);
        System.out.println(result);
        return result;
    }

    /**
     * 在做真正数据插入之前，应该对住宅编码做一个判断，判断当前住宅编码是否存在，
     * 如果存在则不允许插入
     * @param fcEstate
     * @return
     */
//    public Integer insertEstate(FcEstate fcEstate){
//        int result = 0;
//        QueryWrapper<FcEstate> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("estate_code",fcEstate.getEstateCode());
//        FcEstate fcEstate1 = fcEstateMapper.selectOne(queryWrapper);
//        if(fcEstate1 == null){
//            result = fcEstateMapper.insert(fcEstate);
//        }
//        return result;
//
//    }

}
