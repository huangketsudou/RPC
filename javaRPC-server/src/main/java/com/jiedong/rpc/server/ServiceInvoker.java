package com.jiedong.rpc.server;

import com.jiedong.rpc.Request;
import com.jiedong.rpc.common.utils.ReflectionUtils;

/**
 * 调用servic实例的类
 *
 * @author 19411
 * @date 2020/06/25 10:04
 **/
public class ServiceInvoker {
    public Object invoke(ServiceInstance service,
                         Request request){
        return ReflectionUtils.invoke(service.getTarget(),
                service.getMethod(),
                request.getParameters());
    }
}
