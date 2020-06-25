package com.jiedong.rpc.server;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * 表示一个具体服务
 * @author 19411
 * @date 2020/06/24 23:04
 **/

@Data
@AllArgsConstructor
public class ServiceInstance {
    /**
     * 启动服务的对象
     */
    private Object target;
    /**
     * 对象的某些方法暴漏成为服务
     */
    private Method method;
}
