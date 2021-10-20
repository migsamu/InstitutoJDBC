package org.iesfm.instituto.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(InstitutoConfiguration.class);
        InsertTitleProgram program = context.getBean(InsertTitleProgram.class);
        program.insert();
    }
}
