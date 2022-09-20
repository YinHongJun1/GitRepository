package com.mashibing.controller;

import com.mashibing.bean.FcEstate;
import com.mashibing.bean.TblCompany;
import com.mashibing.json.Common;
import com.mashibing.service.EstateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:yhj
 * @Date:2022/8/11 - 08 - 11 - 23:05
 * @Description: com.mashibing.controller
 * @version: 1.0
 */
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {},allowCredentials = "true")
public class EstateController {
    @Resource
    private EstateService estateService;

    @RequestMapping("/estate/selectCompany")
    public Common selectCompany(){
        System.out.println("selectCompany");
        List<TblCompany> companies =estateService.selectCompany();
        return new Common(companies);
    }

    @RequestMapping(value = "/estate/insertEstate")
    @CrossOrigin
    public Common insertEstate(FcEstate fcEstate){
        System.out.println("insertEstate:"+fcEstate);
        Integer result = estateService.insertEstate(fcEstate);
        return new Common("插入成功",200,result.toString());
    }

//    @RequestMapping("/estate/insertEstate")
//    public Common insertEstate(FcEstate fcEstate){
//        System.out.println("insertEstate");
//        System.out.println(fcEstate);
//        Integer result = estateService.insertEstate(fcEstate);
//        if(result == 0){
//            return new Common("房产编码已经存在");
//        }
//        return new Common("插入成功",200,result.toString());
//    }


}
