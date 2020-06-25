package com.jiedong.rpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 19411
 * @date 2020/06/24 21:43
 **/
public class JSONDecoderTest {

    @Test
    public void decode() {
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setAge(18);
        bean.setName("jiedong");
        byte[] bytes = encoder.encoder(bean);
        Decoder decoder = new JSONDecoder();
        TestBean bean1 = decoder.decode(bytes,TestBean.class);
        assertEquals(bean, bean1);
    }
}