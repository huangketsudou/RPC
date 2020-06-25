package com.jiedong.rpc.server;

import com.jiedong.rpc.Request;
import com.jiedong.rpc.ServiceDescriptor;
import com.jiedong.rpc.common.utils.ReflectionUtils;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * @author 19411
 * @date 2020/06/24 23:32
 **/
public class ServiceManagerTest {
    ServiceManager sm;
    @Before
    public void init(){
        sm = new ServiceManager();
        //下面这两个是给lookup的
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class,bean);
    }

    @Test
    public void register() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class,bean);
    }

    @Test
    public void lookup() {
        Method method = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class,method);
        Request request = new Request();
        request.setService(sdp);

        ServiceInstance sis = sm.lookup(request);
        assertNotNull(sis);

    }
}