package com.jiedong.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * 基于json的反序列化
 * @author 19411
 * @date 2020/06/24 21:35
 **/
public class JSONDecoder implements Decoder{
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes,clazz);
    }
}
