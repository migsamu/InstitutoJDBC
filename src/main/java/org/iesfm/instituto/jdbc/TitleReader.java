package org.iesfm.instituto.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TitleReader {

    private static final Logger log = LoggerFactory.getLogger(TitleReader.class);

    private Scanner scanner;

    public TitleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Title askTitle() {

        log.info("Introduce el nombre del título");
        String name = scanner.nextLine();
        log.info("Introduce el nivel del título");
        String level = scanner.nextLine();
        log.info("Introduce la familia del título");
        String family = scanner.nextLine();
        log.info("Introduce una breve descripción del título");
        String description = scanner.nextLine();

        return new Title(null, name, level, family, description);
    }
}
