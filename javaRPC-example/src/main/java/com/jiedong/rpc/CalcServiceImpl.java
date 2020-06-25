package com.jiedong.rpc;

/**
 * @author 19411
 * @date 2020/06/25 11:19
 **/
public class CalcServiceImpl implements CalcService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}
