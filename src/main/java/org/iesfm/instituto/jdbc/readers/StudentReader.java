package org.iesfm.instituto.jdbc.readers;

import org.iesfm.instituto.jdbc.pojos.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class StudentReader {

    private static Logger log = LoggerFactory.getLogger(StudentReader.class);

    private Scanner scanner;

    public StudentReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Student askStudent() {
        log.info("Introduce el nif:");
        String nif = scanner.nextLine();
        log.info("Introduce el nombre:");
        String name = scanner.nextLine();
        log.info("Introduce el apellido:");
        String surname = scanner.nextLine();
        log.info("Introduce el código postal:");
        int zipCode = scanner.nextInt();
        scanner.nextLine();
        log.info("Introduce la dirección:");
        String address = scanner.nextLine();
        log.info("Introduce el email:");
        String email = scanner.nextLine();

        return new Student(nif, name, surname, zipCode, address, email);
    }
}
