package com.yhj.strategy.service;

import com.yhj.strategy.Strategys;
import com.yhj.strategy.dao.User1;

/**
 * @Auther:yhj
 * @Date:2022/4/24 - 04 - 24 - 22:22
 * @Description: com.yhj.strategy.service
 * @version: 1.0
 */
public class StrategysService {
    private Strategys strategys;

    public StrategysService(Strategys strategys){
        this.strategys = strategys;
    }


    public void excute(){this.strategys.excute();}

}
