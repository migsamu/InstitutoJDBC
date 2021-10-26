package org.iesfm.instituto.jdbc;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupDAO {

    private final static String SELECT_GROUP = "SELECT * FROM titleGroup";

    private final static String INSERT_GROUP = "INSERT INTO titleGroup(" +
            "course," +
            "letter," +
            "title," +
            "group_year) " +
            "VALUES(" +
            ":course," +
            ":letter," +
            ":title," +
            ":year)";

    private NamedParameterJdbcTemplate jdbc;

    public GroupDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void insert(Group group) {
        Map<String, Object> params = new HashMap();

        params.put("group_id", group.getId());
        params.put("course", group.getCourse());
        params.put("letter", group.getLetter());
        params.put("title", group.getTitle());
        // FIXME No value supplied for the SQL parameter 'year': No value registered for key 'year'
        params.put("year", group.getYear());

        jdbc.update(INSERT_GROUP, params);
    }

    public List<Group> list() {
        Map<String, Object> params = new HashMap<>();

        return jdbc.query(SELECT_GROUP, params, (rs, rowNum) ->
                new Group(
                        rs.getInt("group_id"),
                        rs.getString("course"),
                        rs.getString("letter"),
                        rs.getString("title"),
                        rs.getInt("group_year")
                ));
    }
}
