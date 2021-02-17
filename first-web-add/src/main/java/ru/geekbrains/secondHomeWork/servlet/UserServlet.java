package ru.geekbrains.secondHomeWork.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.secondHomeWork.persist.Product;
import ru.geekbrains.secondHomeWork.persist.ProductRepository;
import ru.geekbrains.secondHomeWork.persist.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/*")
public class UserServlet extends HttpServlet {
    User user;
    private static final Logger logger = LoggerFactory.getLogger(UserServlet.class);

    @Override
    public void init() throws ServletException {
        this.user = (User)getServletContext().getAttribute("userData");
        if (user == null) {
            throw new ServletException("ProductRepository not initialized");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("User GET");

        if (req.getPathInfo() == null || req.getPathInfo().equals("/")) {
            req.setAttribute("userData", user);
            getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(req, resp);
        }
        else if (req.getPathInfo().equals("/edit")){
            req.setAttribute("user",user);
            getServletContext().getRequestDispatcher("/WEB-INF/user_form.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setEmail(req.getParameter("email"));
        user.setPhoneNumber(req.getParameter("phoneNumber"));
        resp.sendRedirect(getServletContext().getContextPath() + "/user");
    }
}
