package org.iesfm.instituto.jdbc.dao;


import org.iesfm.instituto.jdbc.InstitutoConfiguration;
import org.iesfm.instituto.jdbc.pojos.Title;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {InstitutoConfiguration.class})
public class TitleDAOTest {

    @Autowired
    private TitleDAO titleDAO;

    @Test
    @Ignore
    public void insert() {
        Title title = new Title(
                null,
                "Administracion",
                "GS",
                "Admin",
                "Cosas administrativas"
        );
        titleDAO.insert(title);

        Assert.assertNotNull(titleDAO.getNameTitle("Administracion"));
    }

    @Test
    public void getNameTitles() {

        Assert.assertNotNull(titleDAO.getNameTitle("Administracion"));
        Assert.assertNull(titleDAO.getNameTitle("a"));
    }

    @Test
    public void getFamilyTitles() {

        List<Title> titles = titleDAO.showFamilyTitles("IT");
        Assert.assertEquals(1, titles.size());
    }


}
