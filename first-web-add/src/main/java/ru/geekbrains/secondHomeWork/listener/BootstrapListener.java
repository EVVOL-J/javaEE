package ru.geekbrains.secondHomeWork.listener;



import ru.geekbrains.secondHomeWork.persist.Product;
import ru.geekbrains.secondHomeWork.persist.ProductRepository;
import ru.geekbrains.secondHomeWork.persist.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class BootstrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductRepository productRepository = new ProductRepository();

        User user=new User("Вася", "Пупкин","Pupok@mail.ru","+7(800)555-35-35");

        productRepository.saveOrUpdate(new Product(null, "Product  1",
                "Description of product 1", new BigDecimal(100)));
        productRepository.saveOrUpdate(new Product(null, "Product  2",
                "Description of product 2", new BigDecimal(200)));
        productRepository.saveOrUpdate(new Product(null, "Product  3",
                "Description of product 3", new BigDecimal(200)));
        sce.getServletContext().setAttribute("userData", user);
        sce.getServletContext().setAttribute("productRepository", productRepository);
    }
}

