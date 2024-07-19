package com.yunxin.demo;

import com.winnerlook.model.PrivacyBindBodyAxb;
import com.winnerlook.model.VoiceResponseResult;
import com.winnerlook.service.VoiceSender;

import java.util.Arrays;

/**
 * @author wukaibin
 */
public class YxDemo {

    private String middleMobile = "1";
    private String accountId = "1";
    private String token = "1";


    public VoiceResponseResult bind(String callMobile, String calledMobile) {
        PrivacyBindBodyAxb message = new PrivacyBindBodyAxb();
        /*平台分配的小号号码*/
        message.setMiddleNumber(middleMobile);
        /*需要绑定的真实号码telA,必填*/
        message.setBindNumberA(callMobile);
        /*需要绑定的主叫号码telB，必填*/
        message.setBindNumberB(calledMobile);
        /*是否需要录音，1：录音；0：不录音*/
        message.setCallRec(1);
        /*绑定时间，单位秒*/
        message.setMaxBindingTime(600);

        try {
            VoiceResponseResult result = VoiceSender.httpPrivacyBindAxb(message, accountId, token);

            System.out.println(result);

            return result;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        return null;
    }

    public static void main(String[] args) {
        YxDemo yxDemo = new YxDemo();
        yxDemo.bind("a", "b");
    }

}
