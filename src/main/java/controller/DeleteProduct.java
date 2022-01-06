package controller;

import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteProduct extends HttpServlet {
    ProductService productService = new ProductService();
    RequestDispatcher dispatcher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/view/DeleteProduct.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idDelete = Integer.parseInt(req.getParameter("id"));
        productService.deleteProduct(idDelete);

        req.setAttribute("products", productService.fillAllProduct());
        dispatcher = req.getRequestDispatcher("/view/home.jsp");
        dispatcher.forward(req, resp);
    }
}
