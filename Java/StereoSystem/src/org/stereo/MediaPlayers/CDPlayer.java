package org.stereo.MediaPlayers;

import org.springframework.beans.factory.annotation.Autowired;
import org.stereo.CDs.CompactDisk;

public class CDPlayer implements MediaPlayer{
    private CompactDisk cd;

    @Autowired
    public CDPlayer(CompactDisk cd) {
        this.cd = cd;
    }

    public String play() {
        return this.cd.play();
    }

    public CompactDisk getCd() {
        return cd;
    }

    @Override
    public String playSong(int trackNumber) {
        return "Playing song number: " + trackNumber;
    }
}
