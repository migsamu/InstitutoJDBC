package org.iesfm.instituto.jdbc.dao;

import org.iesfm.instituto.jdbc.InstitutoConfiguration;
import org.iesfm.instituto.jdbc.pojos.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {InstitutoConfiguration.class})
public class StudentDAOTest {

    @Autowired
    private StudentDAO studentDAO;


    @Test
    public void insert() {
        Student student = new Student(
                "1234567h",
                "Alvaro",
                "Perez Lopez",
                123451,
                "calle inventada",
                "miguel@miguel.com"
        );

        Assert.assertEquals(false, studentDAO.insert(student));
    }

    @Test
    public void get() {
        List<Student> students = studentDAO.list();

        Assert.assertEquals(4, students.size());
    }
}
