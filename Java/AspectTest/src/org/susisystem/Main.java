package org.susisystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Student s = context.getBean("student", Student.class);

        s.getGrade("DIS");
        s.getGrade("DSTR");
        s.getGrade("AE");
        s.getGrade("GEOM");

        s.insertSubjectAndGrade("OS", 2);
        s.insertSubjectAndGrade("Probabilities", 5);
        s.insertSubjectAndGrade("N?A", 3);
    }

}
