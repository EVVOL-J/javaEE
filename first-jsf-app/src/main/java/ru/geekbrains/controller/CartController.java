package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Named
@SessionScoped
public class CartController implements Serializable {
    private static Logger logger= LoggerFactory.getLogger(CartController.class);
    private Map<Long, Product> productMap = new HashMap<>();

    public List<Product> getProductChart() {
        return new ArrayList<>(productMap.values());
    }




    public void addToCart(Product product) {

        if(product!=null&&productMap.get(product.getId())==null){
            productMap.put(product.getId(), product);
           logger.info(product.toString());
        }
    }

    public void removeFromCart(Product product) {
        if(product!=null){
            productMap.remove(product.getId());
        }
    }

    public String goToCart() {
        return "/cart.xhtml?faces-redirect-true";
    }
}
