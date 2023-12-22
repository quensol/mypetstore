package csu.web.mypetstore.web.servlets;

//import com.sun.org.apache.xpath.internal.operations.Or;
import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Order;
import csu.web.mypetstore.service.LogService;
import csu.web.mypetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfirmOrderFormServlet extends HttpServlet {
    private static final String CONFIRM_ORDER_FORM = "/WEB-INF/jsp/order/ConfirmOrder.jsp";
    private static final String SHIPPINGFORM = "/WEB-INF/jsp/order/ShippingForm.jsp";

    private String shippingAddressRequired;
    private Order order;
    private OrderService orderService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        shippingAddressRequired = request.getParameter("shippingAddressRequired");
        order = new Order();

        HttpSession session = request.getSession();
        order = (Order)session.getAttribute("order");
        Account account = (Account)session.getAttribute("account");

        if (shippingAddressRequired == null){
            //添加日志
            if((Account)session.getAttribute("account") != null){
                //获取时间
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.println(formatter.format(date));

                LogService logService = new LogService();
                String logInfo = formatter.format(date) +" 确认生成订单";
                logService.insertLogInfo(account.getUsername(), logInfo);
            }

            request.getRequestDispatcher(CONFIRM_ORDER_FORM).forward(request, response);
        }
        else{
            shippingAddressRequired = null;



            if(account != null){
                //获取时间
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.println(formatter.format(date));

                LogService logService = new LogService();
                String logInfo = formatter.format(date) +" 更改收货地址";
                logService.insertLogInfo(account.getUsername(), logInfo);
            }

            request.getRequestDispatcher(SHIPPINGFORM).forward(request, response);
        }

    }
}
