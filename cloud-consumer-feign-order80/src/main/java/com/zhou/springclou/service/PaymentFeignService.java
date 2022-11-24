package com.zhou.springclou.service;

import com.zhou.springclou.OrderFeignMain80;
import com.zhou.springclou.config.FeignConfig;
import com.zhou.springcloud.entities.CommonResult;
import com.zhou.springcloud.entities.Payment;
import feign.Logger;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zyh
 * @create 2022-11-24 18:03
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE", configuration = FeignConfig.class)
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
