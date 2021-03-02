package com.gang.mars.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author gang.chen
 * @description 订单DTO
 * @time 2021/3/2 8:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO implements Serializable {
    private Integer id;
    private String name;
}
