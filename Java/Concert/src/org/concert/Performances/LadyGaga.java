package org.concert.Performances;

import org.springframework.stereotype.Component;

@Component("ladyGaga")
public class LadyGaga implements Performance{
    @Override
    public void perform() {
        System.out.println("P-P-P-P-Poker Face");
        System.out.println("P-P-P-P-Poker Face");
        System.out.println("P-P-P-P-Poker Face");
    }
}
