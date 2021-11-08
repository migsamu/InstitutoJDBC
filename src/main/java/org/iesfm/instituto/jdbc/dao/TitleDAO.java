package org.iesfm.instituto.jdbc.dao;

import org.iesfm.instituto.jdbc.pojos.Title;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TitleDAO {

    private static final String SELECT_FAMILY_TITLES = "SELECT * FROM title WHERE family = :family ";
    private static final String SELECT_NAME_TITLES = "SELECT * FROM title WHERE title_name = :name ";
    private static final String SELECT_FAMILY = "SELECT DISTINCT family FROM title";
    private static final String SELECT_TITLES = "SELECT * FROM title";
    private static final String INSERT_TITLE = "INSERT INTO" +
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

    private static final RowMapper<Title> TITLE_ROW_MAPPER =
            (rs, n) ->
                    new Title(
                            rs.getInt("title_id"),
                            rs.getString("title_name"),
                            rs.getString("title_level"),
                            rs.getString("family"),
                            rs.getString("title_description")

                    );
    private NamedParameterJdbcTemplate jdbc;

    public TitleDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void insert(Title title) {
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

    public List<String> showFamilies() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(SELECT_FAMILY, params, (rs, n) ->
                new String(rs.getString("family")
                )
        );
    }

    public List<Title> showFamilyTitles(String family) {

        Map<String, Object> params = new HashMap<>();
        params.put("family", family);
        return jdbc.query(SELECT_FAMILY_TITLES, params, (rs, n) ->
                new Title(
                        rs.getInt("title_id"),
                        rs.getString("title_name"),
                        rs.getString("title_level"),
                        rs.getString("family"),
                        rs.getString("title_description")

                ));
    }

    public Title getNameTitle(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);

        try {
            return jdbc.queryForObject(SELECT_NAME_TITLES, params, TITLE_ROW_MAPPER);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
