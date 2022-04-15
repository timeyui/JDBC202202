package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String verifyCode = (String) request.getSession().getAttribute("verifyCode");
        String code = request.getParameter("code");

        if(code!=null && verifyCode!=null && code.equalsIgnoreCase(verifyCode)){
            //客户端先验证，再服务器验证
            //code!=null&&code!="" 前者不存在，后者存在但是为空
            request.getRequestDispatcher("a.jsp").forward(request,response);
        }
        else{
            System.out.println("你输入的验证码有问题");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
