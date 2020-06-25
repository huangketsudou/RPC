package com.jiedong.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


/**
 * 表示网络传输的一个端点
 * @author 19411
 * @date 2020/06/24 16:34
 **/
@ToString()
@Data //lombok注解
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
    public static void main(String[] args) {
        System.out.println(new Peer("d",1));
    }
}
