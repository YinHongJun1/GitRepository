package com.mashibing.mapper;

import com.mashibing.bean.TblCompany;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 企业档案 Mapper 接口
 * </p>
 *
 * @author lian
 * @since 2020-04-18
 */
public interface TblCompanyMapper extends BaseMapper<TblCompany> {
    /**
     * 查询公司信息的方法
     * @return 公司信息
     */
    @Select("SELECT id,company_full_name FROM tbl_company")
    List<TblCompany> selectCompany();
}
