package org.iesfm.instituto.jdbc;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Scanner;

@Configuration
public class InstitutoConfiguration {

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:13306/Instituto");
        dataSource.setUsername("root");
        dataSource.setPassword("federica");

        return dataSource;
    }

    @Bean
    public InsertTitleProgram insertTitleProgram(TitleDAO titleDAO, TitleReader titleReader) {
        return new InsertTitleProgram(titleDAO, titleReader);
    }

    @Bean
    public TitleReader titleReader(Scanner scanner) {
        return new TitleReader(scanner);
    }

    @Bean
    public TitleDAO titleDAO(NamedParameterJdbcTemplate jdbc) {
        return new TitleDAO(jdbc);
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public StudentDAO studentDAO(NamedParameterJdbcTemplate jdbc) {
        return new StudentDAO(jdbc);
    }

    @Bean
    public StudentReader studentReader(Scanner scanner) {
        return new StudentReader(scanner);
    }

    @Bean
    public InsertStudentProgram insertStudentProgram(StudentDAO studentDAO, StudentReader studentReader) {
        return new InsertStudentProgram(studentDAO, studentReader);
    }

    @Bean
    public GroupDAO groupDAO(NamedParameterJdbcTemplate jdbc) {
        return new GroupDAO(jdbc);
    }

    @Bean
    public GroupReader groupReader(Scanner scanner) {
        return new GroupReader(scanner);
    }

    @Bean
    public InsertGroupProgram insertGroupProgram(GroupDAO groupDAO, GroupReader groupReader) {
        return new InsertGroupProgram(groupDAO, groupReader);
    }
}
