package org.iesfm.instituto.jdbc.programs;

import org.iesfm.instituto.jdbc.pojos.Student;
import org.iesfm.instituto.jdbc.dao.StudentDAO;
import org.iesfm.instituto.jdbc.readers.StudentReader;

import java.util.List;

public class InsertStudentProgram {

    private StudentDAO studentDAO;
    private StudentReader studentReader;

    public InsertStudentProgram(StudentDAO studentDAO, StudentReader studentReader) {
        this.studentDAO = studentDAO;
        this.studentReader = studentReader;
    }

    public void createStudent() {
        studentDAO.insert(studentReader.askStudent());
    }

    public List<Student> list() {
        return studentDAO.list();
    }
}
