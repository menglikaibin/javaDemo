package com.yunxin.demo;

import com.winnerlook.model.PrivacyBindBodyAx;
import com.winnerlook.model.PrivacyBindBodyAxb;
import com.winnerlook.model.PrivacyUnbindBody;
import com.winnerlook.model.VoiceResponseResult;
import com.winnerlook.service.VoiceSender;

import java.util.HashMap;
import java.util.Map;


public class PrivacyBindAXSample {

    private static void testAx() {
        /*请修改为平台分配的accountId*/
        String accountId="";
        /*请修改为平台分配的token*/
        String token="";
        PrivacyBindBodyAx message = new PrivacyBindBodyAx();
        /*请修改为平台分配的小号号码,必填*/
        message.setMiddleNumber("");
        /*需要绑定的真实号码telA,必填*/
        message.setBindNumberA("");
        /*需要绑定的真实号码telA对应的姓名,必填*/
        message.setCalleeName("");
        /*需要绑定的真实号码telA对应的身份证号码,必填*/
        message.setCalleeId("");
        /*是否需要录音，1：录音；0：不录音*/
        message.setCallRec(1);
        /*绑定时间，单位秒,默认为永久绑定*/
        message.setMaxBindingTime(60);
        /*测试AX模式时，务必填2*/
        message.setMode(2);
        /*需要自动解绑的号码A,非必须*/
        message.setAutoUnbindNumberA("");
        /*第三方呼叫号码A时，是否将主叫号码透传给A,1:透传；0:不透传*/
        message.setPassthroughCallerToA(0);

        try {
            long start = System.currentTimeMillis();
            VoiceResponseResult result = VoiceSender.httpPrivacyBindAx(message, accountId, token);
            long end = System.currentTimeMillis();
            System.out.println("duration = " + (end-start));
            System.out.println("result = " + result);
        }catch (Exception e) {
            //Log.e(this.getClass(), " e = " + e);
            e.printStackTrace();
        }
    }





    private static void testAxb() {

        Map<String,String> pairs = new HashMap<String, String>();
//        pairs.put("17717876557","02151035307");
        pairs.put("19946113944","13764975756");

        for(String caller : pairs.keySet()) {
            /*请修改为平台分配的accountId*/
            String accountId="936fdf9f5572456fa4b7a795cb037879";
            /*请修改为平台分配的token*/
            String token="4c9a2e181bf84f40b15ac6343c39ce21";
            PrivacyBindBodyAxb message = new PrivacyBindBodyAxb();
            /*平台分配的小号号码*/
            message.setMiddleNumber("13044141143");
            /*需要绑定的真实号码telA,必填*/
            message.setBindNumberA(caller);
            /*需要绑定的主叫号码telB，必填*/
            message.setBindNumberB(pairs.get(caller));
            /*是否需要录音，1：录音；0：不录音*/
            message.setCallRec(1);
            /*绑定时间，单位秒*/
            message.setMaxBindingTime(600);

            try {
                VoiceResponseResult result = VoiceSender.httpPrivacyBindAxb(message, accountId, token);
                System.out.println("result = " + result);
            }catch (Exception e) {
                //Log.e(this.getClass(), " e = " + e);
                e.printStackTrace();
            }
        }


    }

    private static void testUnbind() {
        /*请修改为平台分配的accountId*/
        String accountId="936fdf9f5572456fa4b7a795cb037879";
        /*请修改为平台分配的token*/
        String token="4c9a2e181bf84f40b15ac6343c39ce21";
        PrivacyUnbindBody message = new PrivacyUnbindBody();
        /*已绑定的小号号码，必填*/
//        message.setMiddleNumber("13044141204");
        message.setMiddleNumber("13262714450");
        /*已经绑定的真实号码telA,必填*/
        message.setBindNumberA("18701424736");
//        message.setBindNumberA("17717876557");
//        message.setBindNumberA("13918702637");

        /*已经绑定的主叫号码telB，解绑ax模式时可以不填*/
//        message.setBindNumberB("17091925866");

        try {
            VoiceResponseResult result = VoiceSender.httpPrivacyUnbind(message, accountId, token);
            System.out.println("result = " + result);
        }catch (Exception e) {
            //Log.e(this.getClass(), " e = " + e);
            e.printStackTrace();
        }
    }

    public static  void main (String[] args ) {
        long start = System.currentTimeMillis();
        testAx();
//        testAxb();
//        testUnbind();
        long end = System.currentTimeMillis();
        System.out.println("api cost = " + (end-start) + "ms");
//        testUnbind();
    }

}
