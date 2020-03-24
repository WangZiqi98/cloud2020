package com.wzq.sc.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    /**
     * 正常访问   一切ok的方法
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id){
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_OK,id: "+id+"\t"+"哈哈";

    }

    /**
     * 超时方法
     * @param id
     * @return
     */
    //Hystrix服务降级  降级条件 超时
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")  //3秒钟以内就是正常的业务逻辑

    })
    public String paymentInfo_TimeOut(Integer id){
        //int age = 10/0;
        int timeNumber = 3000;
        try { TimeUnit.MILLISECONDS.sleep(timeNumber);} catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_TIMEOUT,id: "+id+"\t"+"哈哈"+"  耗时"+(timeNumber/1000)+"秒";
    }
    public String  paymentInfo_TimeOutHandler(Integer id){
        return "线程池"+Thread.currentThread().getName()+"8001系统繁忙或者运行报错,请稍候再试,id: "+id+"\t"+"哭啦";
    }
}
