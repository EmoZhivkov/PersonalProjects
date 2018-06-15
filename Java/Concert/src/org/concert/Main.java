package org.concert;

import org.concert.Performances.LadyGaga;
import org.concert.Performances.Performance;
import org.concert.Performances.PostMalone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Performance performance = context.getBean("postMalone", PostMalone.class);
        Performance performance2 = context.getBean("ladyGaga", LadyGaga.class);
        performance.perform();
        System.out.println();

        performance2.perform();

    }
}
