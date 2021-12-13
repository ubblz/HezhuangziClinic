package com.hezhuangzi.websocket;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.entity.Sectors;
import com.hezhuangzi.listener.ApplictionListener;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket/infodisplay")
public class InfoDisplay {

    private static final Set<InfoDisplay> clientDiplays = new CopyOnWriteArraySet<>();
    public static final String INFO = "info";
    public static final String CALL = "call";
    private Session session;

    public static void getTypeData(String type,Object data){
        InfoDisplay infoDisplay = new InfoDisplay();
        Map<String,Object> info = new HashMap<>();
        info.put("type",type);
        info.put("data",data);
        infoDisplay.onMessage(JSON.toJSONString(info));
    }

//    public static void getTypePatientData(String type, Object doctorClinId, Object patientName, List<Sectors> allSectorPatient){
//        InfoDisplay infoDisplay = new InfoDisplay();
//        Map<String,Object> info = new HashMap<>();
//        info.put("type",type);
//        info.put("clinicId",doctorClinId);
//        info.put("patienting",patientName);
//        info.put("data",allSectorPatient);
//        infoDisplay.onMessage(JSON.toJSONString(info));
//    }

    @OnOpen
    public void onOpen(Session session) throws IOException {
        System.out.println("连接成功");
        this.session = session;
        clientDiplays.add(this);
        List<Sectors> allSectorPatient = ApplictionListener.getAllSectorPatient();
        getTypeData(InfoDisplay.INFO,allSectorPatient);
    }

    @OnMessage
    public void onMessage(String msg){
        System.out.println("显示屏接收到消息");
        try{
            for (InfoDisplay clientDiplay : clientDiplays) {
                synchronized (clientDiplay){
                    clientDiplay.session.getBasicRemote().sendText(msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(){
        System.out.println("关闭");
        clientDiplays.remove(this);
    }

    @OnError
    public void onError(Throwable throwable)throws Throwable{
        System.out.println(throwable.getMessage());
    }
}
