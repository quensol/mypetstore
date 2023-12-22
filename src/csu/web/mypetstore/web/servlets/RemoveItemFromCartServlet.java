package csu.web.mypetstore.web.servlets;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Cart;
import csu.web.mypetstore.domain.Item;
import csu.web.mypetstore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RemoveItemFromCartServlet extends HttpServlet {

    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private String workingItemId;
    private Cart cart;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        workingItemId = request.getParameter("workingItemId");

        HttpSession session = request.getSession();
        cart = (Cart)session.getAttribute("cart");

        Item item = cart.removeItemById(workingItemId);

        if(item == null) {
            session.setAttribute("message", "Attempted to remove null CartItem from Cart.");

            //添加日志
            Account account = (Account)session.getAttribute("account");
            if(account != null){
                //获取时间
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.println(formatter.format(date));

                LogService logService = new LogService();
                String logInfo = formatter.format(date) +" 从购物车移除商品失败";
                logService.insertLogInfo(account.getUsername(), logInfo);
            }

            request.getRequestDispatcher(ERROR).forward(request, response);
        }else{

            //添加日志
            Account account = (Account)session.getAttribute("account");
            if(account != null){
                //获取时间
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.println(formatter.format(date));

                LogService logService = new LogService();
                String logInfo = formatter.format(date) +" 从购物车移除商品";
                logService.insertLogInfo(account.getUsername(), logInfo);
            }

            request.getRequestDispatcher(VIEW_CART).forward(request, response);
        }
    }
}
