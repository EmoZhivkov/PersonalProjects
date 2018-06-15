package org.spittr.data;
import org.spittr.Spittle;
import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
