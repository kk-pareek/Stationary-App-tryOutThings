package com.project.stationary.Dto;

import com.project.stationary.Model.Cart;
import com.project.stationary.Model.Product;
import com.project.stationary.Service.CartService;
import com.project.stationary.UIandUO.UserOutputCart;
import com.project.stationary.UIandUO.UserOutputProduct;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartDto {

    private CartService cartService;
    private ModelMapper modelMapper;

    @Autowired
    public CartDto(CartService cartService) {
        this.cartService = cartService;
    }

    public UserOutputCart getCartById(Integer customerId){
        Cart cart = cartService.getCartById(customerId);
        List<Product> products = cart.getProducts();

        UserOutputCart uoCart;
        List<UserOutputProduct> uoProducts = new ArrayList<>();

        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        for (Product product : products){
            UserOutputProduct uoProduct = modelMapper.map(product, UserOutputProduct.class);
            uoProducts.add(uoProduct);
        }

        uoCart = new UserOutputCart(cart.getCustomerId(), uoProducts);

        return uoCart;
    }
}
