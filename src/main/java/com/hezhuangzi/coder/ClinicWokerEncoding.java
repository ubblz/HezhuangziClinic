package com.hezhuangzi.coder;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.entity.ClinicWorker;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class ClinicWokerEncoding implements Encoder.Text<ClinicWorker> {


    @Override
    public String encode(ClinicWorker worker) throws EncodeException {
        assert worker != null;
        return JSON.toJSONString(worker);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
