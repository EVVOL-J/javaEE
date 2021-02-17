package ru.geekbrains.secondHomeWork.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/general")
public class GeneralServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String header=(String) req.getAttribute("header");
        resp.getWriter().println("<h1>"+header+"</h1>");
        resp.getWriter().println("<ul>");
        resp.getWriter().println("<li><a href="+getServletContext().getContextPath()+"/main>Главная</a></li>");
        resp.getWriter().println("<li><a href="+getServletContext().getContextPath()+"/cart>cart</a></li>");
        resp.getWriter().println("<li><a href="+getServletContext().getContextPath()+"/catalog>catalog</a></li>");
        resp.getWriter().println("<li><a href="+getServletContext().getContextPath()+"/order>order</a></li>");
        resp.getWriter().println("<li><a href="+getServletContext().getContextPath()+"/product>product</a></li>");
        resp.getWriter().println("</ul>");

    }
}
