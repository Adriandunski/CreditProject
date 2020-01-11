package pl.dunski.springbootcustomer.reposytories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dunski.springbootcustomer.models.CustomerDB;

import java.util.List;
import java.util.Optional;

// Repozytorium laczace sie z baza danych. Zapisuje, znajduje. Takze extra znajdywanie za pomoca id i peselu
@Repository
public class CustomerReposytory {

    private JdbcTemplate jdbcTemplate;

    public CustomerReposytory(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(CustomerDB customer) {
        return jdbcTemplate.update("insert into customerdb (credit_id, first_name, surname, pesel) values(?,?,?,?)",
                    customer.getCreditID(),
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getPesel()
        );
    }

    public List<CustomerDB> findAll() {
        return jdbcTemplate.query("select * from customerdb",
                ((resultSet, i) -> new CustomerDB(
                        resultSet.getInt("credit_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("surname"),
                        resultSet.getString("pesel")
                ))
        );
    }

    public Optional<CustomerDB> findbyId(int id_credit) {

        try {
            return jdbcTemplate.queryForObject("select * from customerdb where credit_id = ?",
                    new Object[]{id_credit},
                    (rs, rowNum) ->
                            Optional.of(new CustomerDB(
                                    rs.getInt("credit_id"),
                                    rs.getString("first_name"),
                                    rs.getString("surname"),
                                    rs.getString("pesel")
                            ))
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.ofNullable(null);
        }
    }

    public Optional<CustomerDB> findbyPesel(String pesel) {

        try {
            return jdbcTemplate.queryForObject("select * from customerdb where pesel = ?",
                    new Object[]{pesel},
                    (rs, rowNum) ->
                            Optional.of(new CustomerDB(
                                    rs.getInt("credit_id"),
                                    rs.getString("first_name"),
                                    rs.getString("surname"),
                                    rs.getString("pesel")
                            ))
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.ofNullable(null);
        }
    }
}
