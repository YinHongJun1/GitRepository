package com.mashibing.service;

import com.mashibing.bean.TblUserRecord;
import com.mashibing.mapper.TblUserRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther:yhj
 * @Date:2022/8/10 - 08 - 10 - 1:10
 * @Description: com.mashibing.service.impl
 * @version: 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TblUserRecordMapper tblUserRecordMapper;

    public TblUserRecord login(String username, String password){
        return tblUserRecordMapper.login(username,password);
    }
}
