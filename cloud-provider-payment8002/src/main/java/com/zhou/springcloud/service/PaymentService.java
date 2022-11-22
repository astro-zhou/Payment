package com.zhou.springcloud.service;

import com.zhou.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author zyh
 * @create 2022-11-20 19:54
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
