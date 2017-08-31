package servlet;

import dao.AddUser;
import dao.DeleteUser;
import dao.QueryUser;
import dao.UpdateUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Users", urlPatterns = "/users/*")
public class Users extends HttpServlet {

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();

        int add = AddUser.getInstance().addUser(request.getParameter("name"), request.getParameter("password"), request.getParameter("avatar"), request.getParameter("is_merchant"));
        printWriter.println("add " + add + " user success");
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("test");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String users = QueryUser.getInstance().queryUsers();
        out.println(users);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        int put = UpdateUser.getInstance().updateUserById(req.getParameter("id"), req.getParameter("name"), req.getParameter("password"), req.getParameter("avatar"));
        printWriter.println("update " + put +" success");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        int delete = DeleteUser.getInstance().deleteUserById(req.getParameter("id"));
        printWriter.println(delete);

    }
}

