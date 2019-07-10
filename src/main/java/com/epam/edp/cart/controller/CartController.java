package com.epam.edp.cart.controller;

import com.epam.edp.cart.model.CartModel;
import com.epam.edp.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart-service")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/service-status")
    public String simpleMapping() {
        return "OK!";
    }

    @GetMapping("/send-message")
    public String postMessage(@RequestParam String msg) {
        cartService.postMessage(msg);
        return "Message " + msg + " sent";
    }

    @GetMapping("/call-order-service")
    public String callOrderService() {
        return "Order service returned " + cartService.callOrderService();
    }

    @PostMapping("/carts")
    public String createCart() {
        Integer newCartId = cartService.createCart();
        return "Cart " + newCartId + " created";
    }

    @GetMapping("/carts/{cartId}")
    public String getCart(@PathVariable("cartId") Integer cartId) {
        CartModel cart = cartService.getCart(cartId);
        return "Cart|" + cart.getId() + "|" + cart.getUserId() + "";
    }
}
