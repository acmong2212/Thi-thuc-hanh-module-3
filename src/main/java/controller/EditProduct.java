package controller;

import model.Product;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = "/edit")
public class EditProduct extends HttpServlet {
    ProductService productService = new ProductService();
    RequestDispatcher dispatcher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idProduct = Integer.parseInt(req.getParameter("id"));
        String nameProduct = req.getParameter("editName");
        double price = Double.parseDouble(req.getParameter("editPrice"));
        int quantity = Integer.parseInt(req.getParameter("editQuantity"));
        String color = req.getParameter("editColor");
        String description = req.getParameter("editDescription");
        int idCategory = Integer.parseInt(req.getParameter("editIdCategory"));
        Product product = new Product(idProduct, nameProduct, price, quantity, color, description, idCategory);

        productService.editProduct(product);

        req.setAttribute("products", productService.fillAllProduct());
        dispatcher = req.getRequestDispatcher("/view/home.jsp");
        dispatcher.forward(req, resp);
    }
}
