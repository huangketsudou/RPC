package com.jiedong.rpc.server;

import com.jiedong.rpc.codec.Decoder;
import com.jiedong.rpc.codec.Encoder;
import com.jiedong.rpc.codec.JSONDecoder;
import com.jiedong.rpc.codec.JSONEncoder;
import com.jiedong.rpc.transport.HttpTransportServer;
import com.jiedong.rpc.transport.TransportServer;
import lombok.Data;

/**
 * server配置类
 * @author 19411
 * @date 2020/06/24 22:58
 **/
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HttpTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;
}
