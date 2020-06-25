package com.jiedong.rpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 19411
 * @date 2020/06/24 21:38
 **/
public class JSONEncoderTest {

    @Test
    public void encoder() {
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setAge(18);
        bean.setName("jiedong");
        byte[] bytes = encoder.encoder(bean);
        assertNotNull(bytes);
    }
}