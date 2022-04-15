package com.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@WebServlet("/s01")
public class ServletRequest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("s01...........");
        /*RequestDispatcher requestDispatcher = request.getRequestDispatcher("/s02");
        requestDispatcher.forward(request,response);*/

        request.setAttribute("name","zhangsan");
        //转发
        //request.getRequestDispatcher("c.jsp").forward(request,response);//可以成功运行
        request.getRequestDispatcher("/s02").forward(request,response);//可以成功运行
        //request.getRequestDispatcher("https://www.baidu.com").forward(request,response);//不可以成功运行

        //重定向
         //response.sendRedirect("https://www.baidu.com");//可以成功运行
        //response.sendRedirect("s02");//可以成功运行，地址栏显示的不再是s01,而是s02

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}