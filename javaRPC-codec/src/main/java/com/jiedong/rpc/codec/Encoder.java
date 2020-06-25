package com.jiedong.rpc.codec;

/**
 * 序列化
 * @author 19411
 * @date 2020/06/24 21:24
 **/
public interface Encoder {
    byte[] encoder(Object obj);
}
