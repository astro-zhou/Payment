package com.zhou.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zyh
 * @create 2022-11-25 17:30
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "------PaymentFallbackService fall back-paymentInfo_Ok, ┭┮﹏┭┮";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------PaymentFallbackService fall back-paymentInfo_TimeOut, ┭┮﹏┭┮";
    }
}
