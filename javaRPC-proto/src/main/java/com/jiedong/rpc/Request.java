package com.jiedong.rpc;

import lombok.Data;

/**
 * 表示RPC的一个请求
 * @author 19411
 * @date 2020/06/24 16:39
 **/
@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] parameters;
}
