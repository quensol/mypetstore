package csu.web.mypetstore.web.servlets;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import csu.web.mypetstore.domain.Product;
import csu.web.mypetstore.service.CatalogService;
import csu.web.mypetstore.util.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AutoFillServlet extends HttpServlet {

    private String keyword;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        keyword = req.getParameter("keyword");
        CatalogService service = new CatalogService();
        List<Product> productList = service.searchProductList(keyword);

        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();

        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < productList.size(); i++) {
            Result result = new Result();
            result.setCode(i);
            result.setMsg(productList.get(i).getName());
            jsonArray.add(result);
        }

        String str = jsonArray.toJSONString();
        out.print(str);

        out.flush();
        out.close();
    }
}
