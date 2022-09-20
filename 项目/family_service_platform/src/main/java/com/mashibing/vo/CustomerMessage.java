package com.mashibing.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 引入lombok，使用它的注解时会在idea编译期间自动给当前类型添加
 */
@Data
@AllArgsConstructor // 有参构造
@NoArgsConstructor // 无参构造
public class CustomerMessage {
    private String column;
    private String value;
    private String customerType;
}
