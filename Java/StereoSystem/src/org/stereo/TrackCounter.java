package org.stereo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class TrackCounter {
    private Map<Integer, Integer> trackCounts = new HashMap<>();

    @Pointcut("execution(* org.stereo.MediaPlayers.MediaPlayer.playSong(int)) && args(trackNumber)")
    public void keepTrackOfSongs(int trackNumber) {}

    @Before("keepTrackOfSongs(trackNumber)")
    public void countTrack(int trackNumber) {
        int currentTrackCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentTrackCount + 1);

    }

    public int getPlayCount(int trackNumber) {
        int trackCount = 0;
        if (trackCounts.containsKey(trackNumber)) {
            trackCount = trackCounts.get(trackNumber);
        }
        return trackCount;
    }
}
