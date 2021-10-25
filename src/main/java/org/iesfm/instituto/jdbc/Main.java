package org.iesfm.instituto.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(InstitutoConfiguration.class);
        InsertTitleProgram program = context.getBean(InsertTitleProgram.class);
       // program.creaTitutlo();
        log.info(program.select().toString());

    }
}
