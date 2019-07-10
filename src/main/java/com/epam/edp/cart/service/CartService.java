package com.epam.edp.cart.service;

import com.epam.edp.cart.model.CartModel;

public interface CartService {

    void postMessage(String msg);

    String callOrderService();

    Integer createCart();

    CartModel getCart(Integer id);

    void removeCart(Integer id);
}
