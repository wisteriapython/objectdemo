package com.yujian.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 请求的对象 HttpServletRequest request
 * 回应的对象 HttpServletResponse response
 * 输出变量 PrintWriter out  /JspWriter out
 *
 * 作用域对象：
 *      ServletContext application 全局对象
 *      HttpSession session 会话范围对象
 *      HttpServletRequest request 单次请求里面有效的对象
 *
 * 获取配置参数 ServletConfig config
 * 只在当前Servlet内或者是当前JSP内有效，pageContext
 * 异常对象 ServletException exception
 * servlet或者jsp本身，this概念 page
 */

@WebServlet(name = "demo1",urlPatterns = {"/demo1"})
public class Demo1Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        //获得全局对象的方法
        ServletContext application=this.getServletContext();
        //ServletContext  application1=request.getSession().getServletContext();

        //获得session会话对象
        HttpSession session=request.getSession();

        //作为作用对象使用，setAttribute()放数据， getAttribute()取数据
        application.setAttribute("name","admin");
        application.setAttribute("list",new ArrayList());
        String applicationName=(String)application.getAttribute("name");
        List list=(List)application.getAttribute("list");

        session.setAttribute("name","zhangsan");
        String sessionName=(String)session.getAttribute("name");

        request.getParameter("key");//这个是获得提交过来的参数
        request.setAttribute("name","李四");
        String requestName=(String)request.getAttribute("name");

        //response.sendRedirect("show.jsp"); //重新请求

        //request.getRequestDispathchar()获得转发的对象,forward让二次请求共享同一个request对象
        request.getRequestDispatcher("show.jsp").forward(request,response);
    }
}
