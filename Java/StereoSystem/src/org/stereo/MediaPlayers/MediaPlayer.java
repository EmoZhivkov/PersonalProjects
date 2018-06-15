package org.stereo.MediaPlayers;

import org.stereo.CDs.CompactDisk;

public interface MediaPlayer {
    String play();
    CompactDisk getCd();
    String playSong(int trackNumber);
}
