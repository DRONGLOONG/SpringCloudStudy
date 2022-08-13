package com.zisu.springcloud.service;

import com.zisu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author lx
 * @create 2022/8/4 10:48
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
