package org.susisystem;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Aspect
public class Logger {
    @Pointcut("execution( * org.susisystem.Student.insertSubjectAndGrade(String, int)) && args(subject, grade)")
    public void keepTrackOfUpdatesInTheStudentsBook(String subject, int grade) { }

    @Pointcut("execution( * org.susisystem.Student.getGrade(String)) && args(subject)")
    public void keepTrackOfLookedUpGrade(String subject) { }

    @Before("keepTrackOfLookedUpGrade(subject)")
    public void logLookedUpGrade(String subject) {
        System.out.println("The Student looked up his Grade in " + subject);
    }

    @Before("keepTrackOfUpdatesInTheStudentsBook(subject, grade)")
    public void logTheUpdateInTheStudentBook(String subject, int grade) {
        System.out.println("The Student just inserted/updated his grade in "+ subject + " to " + grade);
    }
}
