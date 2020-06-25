package com.jiedong.rpc;

/**
 * @author 19411
 * @date 2020/06/25 11:18
 **/
public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);
        int r1 = service.add(1,2);
        int r2 = service.minus(10,8);
        System.out.println(r1);
        System.out.println(r2);
    }
}
