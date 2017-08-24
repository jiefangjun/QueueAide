package servlet;

import dao.AddUser;
import dao.DeleteUser;
import dao.QueryUser;
import dao.UpdateUser;
import model.Group;
import model.User;
import utils.JDBCUtils;
import utils.MyHandler;
import com.alibaba.fastjson.JSON;
import org.apache.commons.dbutils.QueryRunner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class Users extends javax.servlet.http.HttpServlet{

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{

        // 设置响应内容类型
        response.setContentType("application/json;charset=UTF-8");
        // 实际的逻辑是在这里
        PrintWriter out = response.getWriter();
        //out.println(getJson());

        String method = request.getParameter("method");
        switch (method){
            case "post":
                int add = AddUser.getInstance().addUser(request.getParameter("windowName"), request.getParameter("userName"), request.getParameter("foodName"));
                out.println("add " + add + " user success");
                break;
            case "get":
                String users = QueryUser.getInstance().queryUsers();
                out.println(users);
                break;
            case "put":
                int put = UpdateUser.getInstance().updateUserById(request.getParameter("id"));
                out.println("update " + put +" success");
                break;
            case "delete":
                int delete = DeleteUser.getInstance().deleteUserById(request.getParameter("id"));
                out.println(delete);
                break;
        }
    }

}

