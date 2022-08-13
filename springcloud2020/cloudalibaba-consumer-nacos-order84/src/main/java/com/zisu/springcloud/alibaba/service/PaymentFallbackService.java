package com.zisu.springcloud.alibaba.service;

import com.zisu.springcloud.entities.CommonResult;
import com.zisu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author lx
 * @create 2022/8/11 13:04
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回,没有该流水信息",new Payment(id, "errorSerial......"));
    }
}
