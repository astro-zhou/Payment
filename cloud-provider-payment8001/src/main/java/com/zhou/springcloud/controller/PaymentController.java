package com.zhou.springcloud.controller;

import com.zhou.springcloud.entities.CommonResult;
import com.zhou.springcloud.entities.Payment;
import com.zhou.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zyh
 * @create 2022-11-21 10:05
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {

        int result = paymentService.create(payment);
        log.info("*****插入结果: " + result);

        if (result > 0) {
            return new CommonResult(200, "数据库插入成功", result);
        } else {
            return new CommonResult(444, "数据库插入失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果: " + payment + "\t" + "O(∩_∩)O哈哈~");

        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID: " + id, null);
        }
    }
}
