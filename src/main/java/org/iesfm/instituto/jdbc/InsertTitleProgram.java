package org.iesfm.instituto.jdbc;

import java.util.List;

public class InsertTitleProgram {

    private TitleDAO titleDAO;
    private TitleReader titleReader;

    public InsertTitleProgram(TitleDAO titleDAO, TitleReader titleReader) {
        this.titleDAO = titleDAO;
        this.titleReader = titleReader;
    }

    public void creaTitutlo() {

        titleDAO.insertar(titleReader.pideTitutlo());
    }

    public List<Title> select() {
        return titleDAO.list();
    }
}
