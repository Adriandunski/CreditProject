package pl.dunski.springbootproduct.reposytories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dunski.springbootproduct.models.ProductDB;

import java.util.List;
import java.util.Optional;

// Reposytory metody tutaj zapisuja oraz wyciagaja produkty z bazy danych. Znaduje takze po numerze kredytu
@Repository
public class ProductReposytory {

    private JdbcTemplate jdbcTemplate;

    public ProductReposytory(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(ProductDB product) {
        return jdbcTemplate.update("insert into productdb (credit_id, product_name, value) values(?,?,?)",
                                                                    product.getCreditID(),
                                                                    product.getProductName(),
                                                                    product.getValue()
        );
    }

    public List<ProductDB> findAll() {
        return jdbcTemplate.query("select * from productdb",
                                                        ((resultSet, i) -> new ProductDB(
                                                                    resultSet.getInt("credit_id"),
                                                                    resultSet.getString("product_name"),
                                                                    resultSet.getInt("value")
                                                        ))
        );
    }

    public Optional<ProductDB> findbyId(int id_credit) {

        try {
            return jdbcTemplate.queryForObject("select * from productdb where credit_id = ?",
                    new Object[]{id_credit},
                    (rs, rowNum) ->
                            Optional.of(new ProductDB(
                                    rs.getInt("credit_id"),
                                    rs.getString("product_name"),
                                    rs.getInt("value")
                            ))
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.ofNullable(null);
        }
    }
}
