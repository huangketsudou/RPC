package com.jiedong.rpc.server;

import com.jiedong.rpc.Request;
import com.jiedong.rpc.ServiceDescriptor;
import com.jiedong.rpc.common.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;



/**
 * 管理rpc暴露的服务，提供注册服务以及查找服务的功能
 * @author 19411
 * @date 2020/06/24 23:07
 **/
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor, ServiceInstance> services;

    public ServiceManager() {
        this.services = new ConcurrentHashMap<>();
    }

    /**
     * 注册服务
     * @param interfaceClass
     * @param bean
     * @param <T>
     */
    public <T> void register(Class<T> interfaceClass, T bean) {
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        for (Method method : methods) {
            ServiceInstance sis = new ServiceInstance(bean, method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass, method);

            //将提供的具体服务设到map中
            services.put(sdp, sis);
            log.info("register service； {} {}", sdp.getClazz(), sdp.getMethod());
        }
    }

    /**
     * 查找服务
     * @param request
     * @return
     */
    public ServiceInstance lookup(Request request) {
        //根据服务的描述从map中查具体服务
        ServiceDescriptor sdp = request.getService();
        return services.get(sdp);
    }
}