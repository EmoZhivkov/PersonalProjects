package org.stereo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stereo.MediaPlayers.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class TrackCounterTest {
    @Autowired
    @Qualifier("CDPlayerPlayingMyWay")
    MediaPlayer cdPlayerPlayingMyWay;

    @Autowired
    TrackCounter trackCounter;

    @Test
    public void testCountTracksInMyWay() {
        cdPlayerPlayingMyWay.playSong(0);
        cdPlayerPlayingMyWay.playSong(0);
        cdPlayerPlayingMyWay.playSong(0);
        cdPlayerPlayingMyWay.playSong(1);
        cdPlayerPlayingMyWay.playSong(2);
        cdPlayerPlayingMyWay.playSong(2);
        cdPlayerPlayingMyWay.playSong(2);

        Assert.assertEquals(3, trackCounter.getPlayCount(0));
        Assert.assertEquals(1, trackCounter.getPlayCount(1));
        Assert.assertEquals(3, trackCounter.getPlayCount(2));
    }
}
