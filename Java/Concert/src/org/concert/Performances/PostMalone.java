package org.concert.Performances;

import org.springframework.stereotype.Component;

@Component("postMalone")
public class PostMalone implements Performance {
    @Override
    public void perform() {
        System.out.println("//////////////");
        System.out.println("Ball for me");
        System.out.println("Baby couldn't you");
        System.out.println("I've got someone on my mind right nooow");
        System.out.println("//////////////");
    }
}
