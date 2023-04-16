package com.adapter.demo.model.concret;

import com.adapter.demo.model.AdvancedMediaPlayer;

/**
 * @author wuyi
 * @date 2023/4/16
 */
public class VlcPlay implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("playing vlc file. name:" + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
