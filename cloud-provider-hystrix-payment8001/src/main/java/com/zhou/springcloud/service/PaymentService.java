package com.zhou.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * @author zyh
 * @create 2022-11-25 09:52
 */
@Service
public class PaymentService {
    /**
     * 正常访问,肯定ok
     *
     * @param id
     * @return
     */
    public String paymentInfo_Ok(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_ok,id: " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {

//        int age = 10/0;
        try { TimeUnit.SECONDS.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池: " + Thread.currentThread().getName() + " id: " + id + "\t" + "O(∩_∩)O哈哈~" + "  耗时(秒): " ;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池 : " + Thread.currentThread().getName() + " 系统繁忙或运行出错,请稍后再试,id: " + id + "\t" + "┭┮﹏┭┮";
    }


}
