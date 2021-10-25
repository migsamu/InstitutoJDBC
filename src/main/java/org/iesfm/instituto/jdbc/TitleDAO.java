package org.iesfm.instituto.jdbc;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TitleDAO {

    private final static String SELECT_TITLES = "SELECT * FROM title";

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

    public TitleDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void insertar(Title title) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", title.getName());
        params.put("level", title.getLevel());
        params.put("family", title.getFamily());
        params.put("description", title.getDescription());

        jdbc.update(INSERT_TITLE, params);
    }

    public List<Title> list() {
        Map<String, Object> params = new HashMap<>();

        return jdbc.query(SELECT_TITLES, params, (rs, n) ->
                new Title(
                        rs.getInt("title_id"),
                        rs.getString("title_name"),
                        rs.getString("title_level"),
                        rs.getString("family"),
                        rs.getString("title_description")

                ));
    }
}
