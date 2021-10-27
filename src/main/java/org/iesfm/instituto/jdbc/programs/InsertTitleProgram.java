package org.iesfm.instituto.jdbc.programs;

import org.iesfm.instituto.jdbc.pojos.Title;
import org.iesfm.instituto.jdbc.dao.TitleDAO;
import org.iesfm.instituto.jdbc.readers.TitleReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class InsertTitleProgram {

    private static final Logger log = LoggerFactory.getLogger(InsertTitleProgram.class);

    private TitleDAO titleDAO;
    private TitleReader titleReader;
    private Scanner scanner;

    public InsertTitleProgram(TitleDAO titleDAO, TitleReader titleReader, Scanner scanner) {
        this.titleDAO = titleDAO;
        this.titleReader = titleReader;
        this.scanner = scanner;
    }

    public void createTitle() {

        titleDAO.insert(titleReader.askTitle());
    }

    public List<Title> list() {
        return titleDAO.list();
    }

    public List<String> listFamilies() {
        return titleDAO.showFamilies();
    }

    public List<Title> listFamilyTitles() {
        return titleDAO.showFamilyTitles(askFamily());
    }

    public String askFamily() {
        log.info("Introduzca la familia que quiere consultar");
        return scanner.nextLine();
    }
}
