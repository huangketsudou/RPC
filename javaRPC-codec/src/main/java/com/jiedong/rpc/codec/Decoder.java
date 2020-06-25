package com.jiedong.rpc.codec;

/**
 * @author 19411
 * @date 2020/06/24 21:25
 **/
public interface Decoder {
    <T> T decode(byte[] bytes,Class<T> clazz);
}
