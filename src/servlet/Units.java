package servlet;

import dao.UnitDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/units/*")
public class Units extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        String units = UnitDao.getInstance().queryUnits();
        printWriter.println(units);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        int a = UnitDao.getInstance().addUnit(req.getParameter("restaurant_name"), req.getParameter("user_name"),
                req.getParameter("product_name"));
        printWriter.println(a);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        int put = UnitDao.getInstance().updateUnit(req.getParameter("id"), req.getParameter("restaurant_name"),
                req.getParameter("user_name"), req.getParameter("product_name"), req.getParameter("time"));
        printWriter.println(put);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        int delete = UnitDao.getInstance().deleteUnit(req.getParameter("id"));
        printWriter.println(delete);
    }
}
