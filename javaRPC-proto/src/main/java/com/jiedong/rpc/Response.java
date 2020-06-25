package com.jiedong.rpc;

import lombok.Data;

/**
 *表示RPC的返回
 * @author 19411
 * @date 2020/06/24 16:41
 **/
@Data
public class Response {
    /**
     * 服务返回编码，0-成功，非0失败
     */
    private int code = 0;
    /**
     * 具体错误信息
     */
    private String message ="ok";
    /**
     * 返回的数据
     */
    private Object data;
}
