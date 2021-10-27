package org.iesfm.instituto.jdbc.programs;

import org.iesfm.instituto.jdbc.pojos.Group;
import org.iesfm.instituto.jdbc.dao.GroupDAO;
import org.iesfm.instituto.jdbc.readers.GroupReader;

import java.util.List;

public class InsertGroupProgram {

    private GroupDAO groupDAO;
    private GroupReader groupReader;

    public InsertGroupProgram(GroupDAO groupDAO, GroupReader groupReader) {
        this.groupDAO = groupDAO;
        this.groupReader = groupReader;
    }

    public void createGroup() {
        groupDAO.insert(groupReader.askGroup());
    }

    public List<Group> list() {
        return groupDAO.list();
    }
}
