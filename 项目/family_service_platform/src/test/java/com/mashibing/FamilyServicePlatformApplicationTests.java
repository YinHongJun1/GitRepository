package com.mashibing;

import com.mashibing.bean.ZhCustomer;
import com.mashibing.mapper.TblCompanyMapper;
import com.mashibing.mapper.TblUserRecordMapper;
import com.mashibing.service.ZhCustomerService;
import com.mashibing.vo.CustomerMessage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
class FamilyServicePlatformApplicationTests {

	@Autowired
	TblUserRecordMapper tblUserRecordMapper;


	@Resource
	TblCompanyMapper tblCompanyMapper;

	@Resource
	ZhCustomerService zhCustomerService;

	@Test
	void testLog(){
		LogDemo logDemo = new LogDemo();
	}

	@Test
	void contextLoads() {
//		TblUserRecord record = tblUserRecordMapper.login("admin", "c4ca4238a0b923820dcc509a6f75849b");
//		System.out.println("数据输出为："+record);
//
//		List<TblCompany> companies = tblCompanyMapper.selectCompany();
//		System.out.println("公司信息："+companies);
		CustomerMessage customerMessage = new CustomerMessage();
		List<ZhCustomer> zhCustomers = zhCustomerService.selectCustomer(customerMessage);
		for (ZhCustomer customers: zhCustomers) {
			log.info("查询到的具体业主信息：{}",customers);
		}

	}

}
