package controller;

import model.Product;
import service.CategoryService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "")
public class HomeServlet extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();
    RequestDispatcher dispatcher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.setAttribute("listCategory", categoryService.fillAllCategory());
                dispatcher = req.getRequestDispatcher("/view/CreateProduct.jsp");
                dispatcher.forward(req, resp);
                break;
            case "edit":
                int idEdit = Integer.parseInt(req.getParameter("id"));
                Product product = productService.fillAllProduct().get(productService.findIndexById(idEdit));

                req.setAttribute("idEdit", idEdit);
                req.setAttribute("editProduct", product);
                dispatcher = req.getRequestDispatcher("/view/EditProduct.jsp");
                dispatcher.forward(req, resp);
            case "delete":
                int idDelete = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("idDelete", idDelete);
                dispatcher = req.getRequestDispatcher("/view/DeleteProduct.jsp");
                dispatcher.forward(req, resp);
                break;
            case "search":
                String name = req.getParameter("search");
                req.setAttribute("products", productService.findByName(name));
                dispatcher = req.getRequestDispatcher("/view/home.jsp");
                dispatcher.forward(req, resp);
                break;
            default:
                req.setAttribute("products", productService.fillAllProduct());
                dispatcher = req.getRequestDispatcher("/view/home.jsp");
                dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
