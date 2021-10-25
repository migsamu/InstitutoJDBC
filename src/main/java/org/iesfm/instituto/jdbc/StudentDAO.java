package org.iesfm.instituto.jdbc;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDAO {

    private static final String INSERT_STUDENT = "INSERT INTO student(" +
            "nif," +
            "student_name," +
            "student_surname," +
            "zipcode," +
            "address," +
            "email) " +
            "VALUES(" +
            ":nif," +
            ":name," +
            ":surname," +
            ":zipCode," +
            ":address," +
            ":email)";

    private static final String SELECT_STUDENT = "SELECT * FROM student";

    private NamedParameterJdbcTemplate jdbc;

    public StudentDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void insert(Student student) {
        Map<String, Object> params = new HashMap<>();

        params.put("nif", student.getNif());
        params.put("name", student.getName());
        params.put("surname", student.getSurname());
        params.put("zipCode", student.getZipCode());
        params.put("address", student.getAddress());
        params.put("email", student.getEmail());

        jdbc.update(INSERT_STUDENT, params);
    }

    public List<Student> list() {
        Map<String, Object> params = new HashMap<>();

        return jdbc.query(SELECT_STUDENT, params, (rs, rowNum) ->
                new Student(
                        rs.getString("nif"),
                        rs.getString("student_name"),
                        rs.getString("student_surname"),
                        rs.getInt("zipcode"),
                        rs.getString("address"),
                        rs.getString("email")
                ));
    }
}
