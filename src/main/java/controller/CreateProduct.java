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

@WebServlet(urlPatterns = "/create")
public class CreateProduct extends HttpServlet {
    ProductService productService = new ProductService();
    RequestDispatcher dispatcher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("addName");
        double price = Double.parseDouble(req.getParameter("addPrice"));
        int quantity = Integer.parseInt(req.getParameter("addQuantity"));
        String color = req.getParameter("addColor");
        String description = req.getParameter("addDescription");
        int idCategory = Integer.parseInt(req.getParameter("addCategory"));

        try {
            productService.createProduct(new Product(name, price, quantity, color, description, idCategory));
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("products", productService.fillAllProduct());
        dispatcher = req.getRequestDispatcher("/view/home.jsp");
        dispatcher.forward(req, resp);
    }
}
