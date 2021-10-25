package org.iesfm.instituto.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class GroupReader {

    private static final Logger log = LoggerFactory.getLogger(GroupReader.class);

    private Scanner scanner;

    public GroupReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Group askGroup() {

        log.info("Introduce el curso");
        String course = scanner.nextLine();
        log.info("Introduce la letra");
        String letter = scanner.nextLine();
        log.info("Introduce el título");
        String title = scanner.nextLine();
        log.info("Introduce el año");
        Integer year = scanner.nextInt();
        scanner.nextLine();

        return new Group(null, course, letter, title, year);
    }
}
