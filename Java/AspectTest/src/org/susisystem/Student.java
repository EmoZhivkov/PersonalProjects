package org.susisystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Student {
    private String name;
    private int fn;
    private Map<String, Integer> studentsBook;

    @Autowired
    public Student(@Value("Gosho") String name, @Value("62215") int fn, Map<String, Integer> studentsBook) {
        this.name = name;
        this.fn = fn;
        this.studentsBook = studentsBook;
    }

    public void insertSubjectAndGrade(String subject, int grade) {
        this.studentsBook.put(subject, grade);
    }

    public int getGrade(String subject) {
        return this.studentsBook.get(subject);
    }

}
