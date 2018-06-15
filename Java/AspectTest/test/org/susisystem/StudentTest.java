package org.susisystem;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class StudentTest {
    @Autowired
    Student student;

    @Test
    public void testGetGrade() {
        Assert.assertEquals(3, student.getGrade("DIS"));
        Assert.assertEquals(4, student.getGrade("DSTR"));
        Assert.assertEquals(6, student.getGrade("AE"));
        Assert.assertEquals(4, student.getGrade("GEOM"));

    }

}
