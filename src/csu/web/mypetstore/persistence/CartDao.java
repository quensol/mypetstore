package csu.web.mypetstore.persistence;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Cart;
import csu.web.mypetstore.domain.CartItem;
import csu.web.mypetstore.domain.Item;

import java.math.BigDecimal;
import java.util.*;

public interface CartDao {
    Cart getCartByUsername(String username);

    //插入一项购物车
    int insertCart(Cart cart);

    int updateCart(Cart cart,String username);

    void removeCart(Cart cart);



}
