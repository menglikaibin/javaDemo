package com.adapter.demo;

import com.adapter.demo.model.concret.AudioPlayer;

/**
 * @author wuyi
 * @date 2023/4/16
 */
public class AdapterPatternDemo {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "aa.mp3");
        audioPlayer.play("mp4", "aa.mp4");
        audioPlayer.play("vlc", "aa.vlc");
        audioPlayer.play("txt", "aa.txt");
    }

}
