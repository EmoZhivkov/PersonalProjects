package org.stereo;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stereo.CDs.CompactDisk;
import org.stereo.MediaPlayers.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class CDPlayerTest {

    @Autowired
    @Qualifier("outLoudCD")
    CompactDisk outLoudCD;

    @Autowired
    @Qualifier("myWayCD")
    CompactDisk myWayCD;

    @Autowired
    @Qualifier("CDPlayerPlayingOutLoud")
    MediaPlayer CDPlayerPlayingOutLoud;

    @Autowired
    @Qualifier("CDPlayerPlayingMyWay")
    MediaPlayer CDPlayerPlayingMyWay;

    @Test
    public void myWayCDShouldNotBeNull() {
        Assert.assertNotNull(myWayCD);
    }
    @Test
    public void outLoudCD2ShouldNotBeNull() {
        Assert.assertNotNull(outLoudCD);
    }

    @Test
    public void playCDPlayerPlayingMyWayTest() {
        Assert.assertEquals("PLaying " + "My Way" + " performed by " + "Calvin Harris", CDPlayerPlayingMyWay.play());
    }

    @Test
    public void playCDPlayerPlayingOutLoudTest() {
        Assert.assertEquals("PLaying " + "Out Loud" + " performed by " + "Gabbie Hanna", CDPlayerPlayingOutLoud.play());
    }
}
