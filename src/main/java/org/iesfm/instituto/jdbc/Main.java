package org.iesfm.instituto.jdbc;

import org.iesfm.instituto.jdbc.programs.InsertGroupProgram;
import org.iesfm.instituto.jdbc.programs.InsertStudentProgram;
import org.iesfm.instituto.jdbc.programs.InsertTitleProgram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(InstitutoConfiguration.class);

        ProgramMenu programMenu = context.getBean(ProgramMenu.class);
        programMenu.menu();
        //titleProgram.createTitle();
        //log.info(titleProgram.select().toString());

        //InsertStudentProgram studentProgram = context.getBean(InsertStudentProgram.class);
        // studentProgram.createStudent();
        // InsertGroupProgram groupProgram = context.getBean(InsertGroupProgram.class);
        //groupProgram.createGroup();


    }
}
