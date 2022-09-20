package com.mashibing.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 楼盘信息
 * </p>
 *
 * @author lian
 * @since 2020-04-18
 */
@Data
@AllArgsConstructor
public class FcEstate implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 自动编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 房产编码
     */
    private String estateCode;

    /**
     * 房产名称
     */
    private String estateName;

    /**
     * 房产地址
     */
    private String estateAddr;

    /**
     * 占地面积
     */
    private Double coverArea;

    /**
     * 建筑面积
     */
    private Double buildArea;

    /**
     * 绿地面积
     */
    private Double greenArea;

    /**
     * 道路面积
     */
    private Double roadArea;

    /**
     * 楼宇数量
     */
    private Double buildingNumber;

    /**
     * 负责人
     */
    private String buildingLeader;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 法人代表
     */
    private String companyBehalf;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 联系地址
     */
    private String contactAddr;

    /**
     * 车位滞纳金比率
     */
    private Double carSpaceDelayRate;

    /**
     * 车位超期天数
     */
    private Integer carSpaceOverDay;

    /**
     * 房产类型
     */
    private String estateType;

    /**
     * 路灯数量
     */
    private Integer streetLampNumber;

    /**
     * 化粪池数量
     */
    @TableField("hfcNum")
    private Integer hfcNum;

    /**
     * 备注
     */
    private String remark;

    /**
     * 所属公司
     */
    private String company;



}
