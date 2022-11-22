package com.zhou.springcloud.service.impl;

import com.zhou.springcloud.dao.PaymentDao;
import com.zhou.springcloud.entities.Payment;
import com.zhou.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zyh
 * @create 2022-11-20 19:54
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
