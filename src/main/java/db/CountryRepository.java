package db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(value = "SELECT * FROM countries ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Country> findRandomCountry();

    @Query(value = "SELECT capital FROM countries WHERE id = :id", nativeQuery = true)
    Optional<String> findCapitalById(Integer id);
}
