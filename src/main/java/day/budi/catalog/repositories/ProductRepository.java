package day.budi.catalog.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import day.budi.catalog.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Query("""
            SELECT p FROM Product p JOIN p.store s
            WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :search, '%'))
               OR LOWER(s.name) LIKE LOWER(CONCAT('%', :search, '%'))
            """)
    Page<Product> search(@Param("search") String search, Pageable pageable);

    Optional<Product> findByUuid(UUID uuid);
}
