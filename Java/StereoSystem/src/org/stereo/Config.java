package org.stereo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.stereo.CDs.CompactDisk;
import org.stereo.MediaPlayers.CDPlayer;
import org.stereo.MediaPlayers.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackageClasses = MarkerInterface.class)//Scans the package where the class is
public class Config {


    @Autowired
    @Bean("CDPlayerPlayingMyWay")
    public MediaPlayer getCDPlayerPlayingMyWay(@Qualifier("myWayCD") CompactDisk compactDisk) {
        return new CDPlayer(compactDisk);
    }

    @Autowired
    @Bean("CDPlayerPlayingOutLoud")
    public MediaPlayer getCDPlayerPlayingOutLoud(@Qualifier("outLoudCD") CompactDisk compactDisk) {
        return new CDPlayer(compactDisk);
    }

    @Bean("songsInOutLoud")
    public List<String> getSongsInOutLoud() {
        List<String> songs = new ArrayList<>();
        songs.add("OOpa");
        songs.add("Gledai kak se pravi");
        songs.add("Dai Mu");
        return songs;
    }

    @Bean("songsInMyWay")
    public List<String> getSongsInMyWay() {
        List<String> songs = new ArrayList<>();
        songs.add("EEEEEE");
        songs.add("Nqma kakwo");
        songs.add("Da stane");
        return songs;
    }
}
