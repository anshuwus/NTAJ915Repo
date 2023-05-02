package com.nt.repository.prod;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.prod.Product;

public interface IProductRepsitory extends CrudRepository<Product, Integer> {

}
