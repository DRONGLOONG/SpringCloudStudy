package com.zisu.springcloud.controller;

import com.zisu.springcloud.entities.CommonResult;
import com.zisu.springcloud.entities.Payment;
import com.zisu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author lx
 * @create 2022/8/4 10:55
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("***********插入结果" + payment);
        return payment != null ? new CommonResult(200, "查询成功,serverPort：" + serverPort, payment)
                : new CommonResult(444, "没有对应记录，查询id：" + id, null);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int t = paymentService.create(payment);
        log.info("*************插入结果：" + t);
        return t > 0 ? new CommonResult(200, "插入数据成功,serverPort：" + serverPort, t)
                : new CommonResult(444, "插入数据失败", null);
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }

}
