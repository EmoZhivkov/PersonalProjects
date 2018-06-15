package org.stereo.CDs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("myWayCD")
public class MyWayCD implements CompactDisk {
    private String title;
    private String artist;
    private List<String> songs;

    @Autowired
    public MyWayCD(@Value("My Way") String title,
                   @Value("Calvin Harris") String artist,
                   @Qualifier("songsInMyWay") List<String> songs) {
        this.title = title;
        this.artist = artist;
        this.songs = songs;
    }

    @Override
    public String play() {
        return "PLaying " + title + " performed by " + artist;
    }

    @Override
    public List<String> getSongs() {
        return songs;
    }


}
