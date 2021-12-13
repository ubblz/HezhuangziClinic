package com.hezhuangzi.coder;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.entity.ClinicWorker;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class ClinicWorkerDecoder implements Decoder.Text<ClinicWorker> {
    @Override
    public ClinicWorker decode(String s) throws DecodeException {
        return JSON.parseObject(s,ClinicWorker.class);
    }

    @Override
    public boolean willDecode(String s) {
        return false;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
