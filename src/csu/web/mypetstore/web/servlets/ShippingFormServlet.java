package csu.web.mypetstore.web.servlets;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShippingFormServlet extends HttpServlet {
    private static final String SHIPPINGFORM = "/WEB-INF/jsp/order/ShippingForm.jsp";
    private static final String SIGNONFORM = "/WEB-INF/jsp/account/SignonForm.jsp";

    private Account account;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        account = (Account)session.getAttribute("account");

        if (account == null){
            request.getRequestDispatcher(SIGNONFORM).forward(request, response);
        } else{
            //添加日志
            Account account = (Account)session.getAttribute("account");
            if(account != null){
                //获取时间
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                System.out.println(formatter.format(date));

                LogService logService = new LogService();
                String logInfo = formatter.format(date) +" 跳转到修改地址界面";
                logService.insertLogInfo(account.getUsername(), logInfo);
            }

            request.getRequestDispatcher(SHIPPINGFORM).forward(request, response);
        }
    }
}
