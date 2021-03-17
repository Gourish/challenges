package com.work.inventoryManagement.repos;

import com.work.inventoryManagement.model.Product;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends CassandraRepository<Product,UUID>
{
    @AllowFiltering
    Optional<Product> findByName(String name);
    @AllowFiltering
    List<Product> findByCategory(String category);
}
