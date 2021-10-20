package org.iesfm.instituto.jdbc;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

public class InsertTitleProgram {
    private final static String INSERT_TITLE = "INSERT INTO" +
            " title(" +
            "title_name, " +
            "title_level, " +
            "family, " +
            "title_description) " +
            "VALUES(" +
            ":name," +
            ":level," +
            ":family," +
            ":description)";

    private NamedParameterJdbcTemplate jdbc;


    public InsertTitleProgram(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void insert() {
        Title title = new Title(null,
                "Desarrollo de aplicaciones web",
                "GS",
                "Informatica",
                "Hacer aplicaciones web"
        );

        Map<String, Object> params = new HashMap<>();
        params.put("name",title.getName());
        params.put("level",title.getLevel());
        params.put("family",title.getFamily());
        params.put("description",title.getDescription());

        jdbc.update(INSERT_TITLE, params);
    }
}
