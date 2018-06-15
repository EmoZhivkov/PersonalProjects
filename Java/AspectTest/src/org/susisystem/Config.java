package org.susisystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackageClasses = Main.class)
public class Config {
    @Bean
    public Map<String, Integer> getStudentsBook() {
        Map<String, Integer> book = new HashMap<>();
        book.put("DIS", 3);
        book.put("DSTR", 4);
        book.put("AE", 6);
        book.put("GEOM", 4);
        return book;
    }
}
