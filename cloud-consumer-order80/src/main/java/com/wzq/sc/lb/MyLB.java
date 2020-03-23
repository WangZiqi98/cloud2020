package com.wzq.sc.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer{
    private AtomicInteger atomicInteger=new AtomicInteger(0);

    /**
     * cas自旋锁确定下标
     * @return
     */
    public  final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current+1;

        }while(!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*******第几次访问: "+next);
        return next;
    }

    /**
     *  给我一个服务实例数组 我根据下标给你返回一个服务
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index=getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
