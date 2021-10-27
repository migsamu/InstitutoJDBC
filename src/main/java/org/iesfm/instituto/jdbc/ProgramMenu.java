package org.iesfm.instituto.jdbc;

import org.iesfm.instituto.jdbc.programs.InsertGroupProgram;
import org.iesfm.instituto.jdbc.programs.InsertStudentProgram;
import org.iesfm.instituto.jdbc.programs.InsertTitleProgram;
import org.iesfm.instituto.jdbc.readers.ScannerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ProgramMenu {

    private static final Logger log = LoggerFactory.getLogger(ProgramMenu.class);

    public static final String MENU = "Seleccione una opcion \n" +
            "1- Insertar alumno.\n" +
            "2- Mostrar lista de alumnos. \n" +
            "3- Insertar titulo. \n" +
            "4- Mostrar lista de titulos\n" +
            "5- Insertar grupo.\n" +
            "6- Mostrar lista de grupos. \n" +
            "7- Muestra las familias de los titulos. \n" +
            "8- Muestra los titulos de una familia. \n" +
            "0- SALIR";

    private Scanner scanner;
    private InsertGroupProgram insertGroupProgram;
    private InsertTitleProgram insertTitleProgram;
    private InsertStudentProgram insertStudentProgram;
    private ScannerUtils scannerUtils;

    public ProgramMenu(Scanner scanner, InsertGroupProgram insertGroupProgram, InsertTitleProgram insertTitleProgram, InsertStudentProgram insertStudentProgram, ScannerUtils scannerUtils) {
        this.scanner = scanner;
        this.insertGroupProgram = insertGroupProgram;
        this.insertTitleProgram = insertTitleProgram;
        this.insertStudentProgram = insertStudentProgram;
        this.scannerUtils = scannerUtils;
    }

    public void menu() {

        boolean salir = false;

        Integer selection = null;

        while (!salir) {
            log.info(MENU);
            selection = scannerUtils.readPositiveNumber();
            while (selection < 0 || selection > 8) {
                log.info("El numero debe ser entre 0 y 8");
                selection = scannerUtils.readPositiveNumber();
            }
            if (selection == 0) {
                salir = true;
                log.info("Gracias por usar nuestra aplicacion.");
            } else if (selection == 1) {
                insertStudentProgram.createStudent();
            } else if (selection == 2) {
                log.info(insertStudentProgram.list().toString());
            } else if (selection == 3) {
                insertTitleProgram.createTitle();
            } else if (selection == 4) {
                log.info(insertTitleProgram.list().toString());
            } else if (selection == 5) {
                insertGroupProgram.createGroup();
            } else if (selection == 6) {
                log.info(insertGroupProgram.list().toString());
            } else if (selection == 7) {
                log.info(insertTitleProgram.listFamilies().toString());
            }else if (selection == 8) {
                log.info(insertTitleProgram.listFamilyTitles().toString());
            }
        }
    }
}
