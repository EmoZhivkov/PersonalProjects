package com.vmware.talentboost.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Game game = context.getBean("game", Game.class);
		game.run();
	}
}
