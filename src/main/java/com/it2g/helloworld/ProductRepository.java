package com.it2g.helloworld;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.it2g.helloworld.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
}
