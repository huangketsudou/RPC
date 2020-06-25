package com.jiedong.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * 基于json的序列化实现
 * @author 19411
 * @date 2020/06/24 21:34
 **/
public class JSONEncoder implements Encoder{

    @Override
    public byte[] encoder(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
