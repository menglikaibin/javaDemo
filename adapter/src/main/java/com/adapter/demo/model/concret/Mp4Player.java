package com.adapter.demo.model.concret;

import com.adapter.demo.model.AdvancedMediaPlayer;

/**
 * @author wuyi
 * @date 2023/4/16
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("playing mp4 file. name:" + fileName);
    }
}
