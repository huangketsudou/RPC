package com.jiedong.rpc;

import com.jiedong.rpc.codec.Decoder;
import com.jiedong.rpc.codec.Encoder;
import com.jiedong.rpc.codec.JSONDecoder;
import com.jiedong.rpc.codec.JSONEncoder;
import com.jiedong.rpc.transport.HttpTransportClient;
import com.jiedong.rpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author 19411
 * @date 2020/06/25 10:47
 **/
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass =
            HttpTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(
            new Peer("127.0.0.1",3000)
    );
}
