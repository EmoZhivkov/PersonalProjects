package org.stereo.CDs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("outLoudCD")//the default naming is the same
public class OutLoudCD implements CompactDisk{
    private String title;
    private String artist;
    private List<String> songs;

    @Autowired
    public OutLoudCD(@Value("Out Loud") String title,
                   @Value("Gabbie Hanna") String artist,
                   @Qualifier("songsInOutLoud") List<String> songs) {
        this.title = title;
        this.artist = artist;
        this.songs = songs;
    }

    public String play() {
        return "PLaying " + title + " performed by " + artist;
    }

    public List<String> getSongs() {
        return songs;
    }


}
