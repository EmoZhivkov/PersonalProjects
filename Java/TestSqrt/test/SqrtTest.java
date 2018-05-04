import org.junit.Assert;
import org.junit.Test;
import org.sqrt.Sqrt;

public class SqrtTest {
    @Test
    public void testSqrtNotExact() {
        int output = Sqrt.sqrt();
        int expected = 0;

        Assert.assertEquals(expected, output);
    }
    @Test
    public void testSqrtExact() {
        int output = Sqrt.sqrt();
        int expected = 0;

        Assert.assertEquals(expected, output);
    }
    @Test
    public void testSqrtNegative() {
        int output = Sqrt.sqrt();
        int expected = 0;

        Assert.assertEquals(expected, output);
    }
    @Test
    public void testSqrtZero() {
        int output = Sqrt.sqrt();
        int expected = 0;

        Assert.assertEquals(expected, output);
    }
    @Test
    public void testSqrtInfinity() {
        int output = Sqrt.sqrt();
        int expected = 0;

        Assert.assertEquals(expected, output);
    }
    @Test
    public void testSqrtLargeNumber() {
        int output = Sqrt.sqrt();
        int expected = 0;

        Assert.assertEquals(expected, output);
    }
    @Test
    public void testSqrtBetweenZeroAndOne() {
        int output = Sqrt.sqrt();
        int expected = 0;

        Assert.assertEquals(expected, output);
    }
}
