package com.mashibing.controller;


import com.mashibing.bean.ZhCustomer;
import com.mashibing.bean.ZhCustomerEstate;
import com.mashibing.json.Common;
import com.mashibing.service.ZhCustomerService;
import com.mashibing.util.ExcelUtil;
import com.mashibing.vo.CustomerMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业主信息表 前端控制器
 * </p>
 *
 * @author lian
 * @since 2020-04-18
 */
@RestController
@RequestMapping("/zhCustomer")
public class ZhCustomerController {
    @Resource
    private ZhCustomerService zhCustomerService;

    /**
     *  新增业主信息
     * @param zhCustomer 前端传递新业主信息
     * @return 业主信息是否新增成功
     */
    @PostMapping("/insertCustomer")
    public Common insertCustomer(ZhCustomer zhCustomer){
        Integer result = zhCustomerService.insertCustomer(zhCustomer);
        if(result == 0){
           return new Common("业主编码已存在，请重新输入！");
        }
        return new Common("添加成功！");
    }

    /**
     *  查询全部业主信息
     * @return 查询到的业主信息结果
     */
    @GetMapping("/selectCustomer")
    public Common selectAllCustomer(){
        List<ZhCustomer> zhCustomers = zhCustomerService.selectAllCustomer();
        System.out.println("selectAllCustomer");
        return new Common(zhCustomers);
    }

    /**
     * 根据用户选择的列和值查询业主信息
     * @param column 查询列
     * @param value 查询值
     * @return 查询到的业主信息
     */
    @PostMapping("/selectCustomerByColumnAndValue")
    public Common selectCustomerByColumnAndValue(@RequestParam("column") String column,@RequestParam("value") String value){
        System.out.println("selectCustomerByColumnAndValue");
        List<ZhCustomer> zhCustomers = zhCustomerService.selectCustomerByColumnAndValue(column, value);
        return new Common(zhCustomers);
    }

    /**
     * 根据业主类型来进行查询的业主信息
     * @param customerType 业主类型
     * @return 业主信息
     */
    @PostMapping("/selectByCustomerByCustomerType")
    public Common selectByCustomerByCustomerType(String customerType){
        System.out.println("selectByCustomerByCustomerType");
        List<ZhCustomer> zhCustomers = zhCustomerService.selectByCustomerByCustomerType(customerType);
        return new Common(zhCustomers);
    }

    /**
     *  根据前端的业主编号信息来修改业主状态
     * @param map 前端传过来的参数
     *            customerCode:此参数为业主编码，如果出现多个业主编码，会通过“|”进行分割
     *            status： 状态码： 1 表示启用   2 表示禁用
     * @return 修改业主状态信息的结果
     */
    @PostMapping("/updateCustomerStatusByCustomerCode")
    public Common updateCustomerStatusByCustomerCode(@RequestBody Map map){
        System.out.println("updateCustomerStatusByCustomerCode");
        String customerCodes = (String)map.get("customerCodes");
        String status = (String) map.get("status");
        System.out.println(customerCodes+" "+status);
        Integer result = zhCustomerService.updateCustomerStatusByCustomerCode(customerCodes, status);
        if(result == 1){
            return new Common("修改成功！");
        }else{
            return new Common("修改失败！");
        }
    }

    /**
     * 统一查询入口（优化查询）
     * 通过用户传递的参数来进行对应的查询
     * @param customerMessage 用户传递的参数
     * @return 查询结果：业主信息
     */
    @PostMapping("/selectCustomer")
    public Common selectCustomer(@RequestBody CustomerMessage customerMessage){
        System.out.println("selectCustomer");
        List<ZhCustomer> zhCustomers = zhCustomerService.selectCustomer(customerMessage);
        return new Common(zhCustomers);

    }

    /**
     * 根据前端传递的Excel表格中对应的公司信息解析出业主信息，存入到数据库
     * @param file Excle表格文件（限定格式，要和实体类一样）
     * @param company 对应公司的编号
     * @return 是否新增成功
     */
    @PostMapping("/uploadExcel")
    public Common uploadExcel(MultipartFile file, String company){
        System.out.println("uploadExcel");
        // 调用readExcel方法解析Excel表格
        try {
            List<ZhCustomer> zhCustomers = ExcelUtil.readExcel((FileInputStream) file.getInputStream(), ZhCustomer.class);
            for (ZhCustomer customrs: zhCustomers) {
                System.out.println(customrs);
            }
            // 调用业务层接口传递实体类
            zhCustomerService.insertAll(zhCustomers,company);
            return new Common("批量增加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Common("批量增加失败!");
        }
    }

    /**
     * 新增业主入住信息
     * @param zhCustomerEstate 业主与房产关系数据
     * @return 是否添加成功
     */
    @PostMapping("/insertCustomerOrEstate")
    public Common insertCustomerOrEstate(@RequestBody ZhCustomerEstate zhCustomerEstate){
        System.out.println("insertCustomerOrEstate");
        Integer result = zhCustomerService.insertCustomerOrEstate(zhCustomerEstate);
        if (result == 1){
            return new Common("1");
        }else{
            return new Common("2");
        }
    }
}
