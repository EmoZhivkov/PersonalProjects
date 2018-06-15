package org.stereo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.stereo.CDs.CompactDisk;
import org.stereo.MediaPlayers.CDPlayer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CDPlayer cdPlayer = context.getBean("CDPlayerPlayingMyWay", CDPlayer.class);
        CompactDisk cd = cdPlayer.getCd();
        List<String> songs = cd.getSongs();
        for (String s :
                songs) {
            System.out.println(s);
        }
    }
}
