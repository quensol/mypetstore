package csu.web.mypetstore.web.servlets;

import com.alibaba.fastjson.JSON;
import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Cart;
import csu.web.mypetstore.domain.CartItem;
import csu.web.mypetstore.domain.Item;
import csu.web.mypetstore.service.AccountService;
import csu.web.mypetstore.service.CartService;
import csu.web.mypetstore.service.CatalogService;
import csu.web.mypetstore.service.LogService;
import csu.web.mypetstore.util.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class UpdateCartQuantitiesServlet extends HttpServlet {

    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";

    private String workingItemId;
    private Cart cart;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        workingItemId = request.getParameter("workingItemId");
//        CatalogService catalogService = new CatalogService();
//
//        //从对话中，获取购物车
//        HttpSession session = request.getSession();
//        cart = (Cart)session.getAttribute("cart");
//
//        Iterator<CartItem> cartItemIterator = cart.getAllCartItems();
//
//        while (cartItemIterator.hasNext()){
//            //产品数量增加
//            CartItem cartItem = (CartItem)cartItemIterator.next();
//            String itemId = cartItem.getItem().getItemId();
//
//            try {
//                int quantity = Integer.parseInt((String) request.getParameter(itemId));
//                cart.setQuantityByItemId(itemId, quantity);
//                if (quantity < 1) {
//                    cartItemIterator.remove();
//                }
//            } catch (Exception e) {
//                //ignore parse exceptions on purpose
//                e.printStackTrace();
//            }
//
//        }
//
//        session.setAttribute("cart", cart);
//
//        request.getRequestDispatcher(VIEW_CART).forward(request, response);
        String quantity = request.getParameter("quantity");
        String cartItem = request.getParameter("cartItem");

        System.out.println(quantity);
        System.out.println(cartItem);
//        CartService cartService = new CartService();
//        cartService.setQuantityByItemId(cartItem,Integer.parseInt(quantity));
//        cartService.setQuantityByItemId("EST-13",3);
//        CartItem result = cartService.g(username);
//        Cart cart = new Cart();
        CatalogService catalogService = new CatalogService();

//        resp.setContentType("text/plain");
        response.setContentType("text/json");

        PrintWriter out = response.getWriter();

        Result result1 = new Result();

//        if(result == null){
//            //用户名可用
//            result1.setCode(0);
//            result1.setMsg("Not Exist");
//        }else{
//            //用户名不可用
//            result1.setCode(1);
//            result1.setMsg("Exist");
//        }
//
//        String str = JSON.toJSONString(result1);
//        out.print(str);
//
//        out.flush();
//        out.close();
    }
}
