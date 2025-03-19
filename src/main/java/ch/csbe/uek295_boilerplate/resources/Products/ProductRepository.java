package ch.csbe.uek295_boilerplate.resources.Products;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("""
            select p from Product p 
            where p.id = :id
            """)
    Product getById(@Param("id") Long productId);
}