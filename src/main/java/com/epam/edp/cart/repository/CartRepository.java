package com.epam.edp.cart.repository;

import com.epam.edp.cart.model.CartModel;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<CartModel, Integer> {
}
