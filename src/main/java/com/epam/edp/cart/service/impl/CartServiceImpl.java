package com.epam.edp.cart.service.impl;

import com.epam.edp.cart.model.CartModel;
import com.epam.edp.cart.repository.CartRepository;
import com.epam.edp.cart.service.CartService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void postMessage(String msg) {
        rabbitTemplate.convertAndSend(routingkey, msg);
    }

    @Override
    @Retryable(
            value = {Exception.class},
            maxAttempts = 4,
            backoff = @Backoff(delay = 1000)
    )
    public String callOrderService() {
        return restTemplate
                .getForEntity("http://order-service:8080/order-service/time", String.class)
                .getBody();
    }

    @Override
    public Integer createCart() {
        CartModel cart = new CartModel();
        cart = cartRepository.save(cart);
        return cart.getId();
    }

    @Override
    public CartModel getCart(Integer id) {
        Optional<CartModel> cart = cartRepository.findById(id);
        if (cart.isPresent()) {
            return cart.get();
        } else {
            throw new RuntimeException("Cart with id " + id + " not found");
        }
    }

    @Override
    public void removeCart(Integer id) {
        cartRepository.deleteById(id);
    }
}
