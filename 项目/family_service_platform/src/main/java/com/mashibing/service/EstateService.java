package com.mashibing.service;

import com.mashibing.bean.FcEstate;
import com.mashibing.bean.TblCompany;

import java.util.List;

/**
 * @Auther:yhj
 * @Date:2022/8/11 - 08 - 11 - 23:13
 * @Description: com.mashibing.service
 * @version: 1.0
 */
public interface EstateService {
    List<TblCompany> selectCompany();

    Integer insertEstate(FcEstate fcEstate);

}
