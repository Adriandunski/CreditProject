package pl.dunski.springbootcredit.reposytories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dunski.springbootcredit.models.modelsDB.CreditDB;

import java.util.List;
import java.util.Optional;

// Repozytory do szukania kredytow. Mamy możliwsoc zapisania oraz znalezienia odpowiedniego kredytu.
@Repository
public class CreditReposytory {

    private JdbcTemplate jdbcTemplate;

    public CreditReposytory(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(CreditDB creditDB) {
        return jdbcTemplate.update(
                "insert into creditdb (id, credit_name) values(?,?)",
                creditDB.getId(), creditDB.getCreditName());
    }

    public List<CreditDB> findAll() {
        return jdbcTemplate.query("select * from creditdb",
                ((resultSet, i) -> new CreditDB(
                        resultSet.getInt("id"),
                        resultSet.getString("credit_name"))));
    }

    public Optional<CreditDB> findbyId(int id) {
        String statment = "select * from creditdb where id = " + id;

        try {
            return jdbcTemplate.queryForObject("select * from creditdb where id = ?",
                    new Object[]{id},
                    (rs, rowNum) ->
                            Optional.of(new CreditDB(
                                    rs.getInt("id"),
                                    rs.getString("credit_name")
                            ))
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.ofNullable(null);
        }
    }

    public List<Integer> getCreditNumbersID() {
        return jdbcTemplate.query("select id from creditdb",
                (resultSet, i) -> new Integer(resultSet.getInt("id")));
    }
}
