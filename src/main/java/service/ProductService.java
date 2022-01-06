package service;

import dao.ProductDao;
import model.Product;

import java.util.List;

public class ProductService {
    public static List<Product> productList = ProductDao.getAllProduct();

    public List<Product> fillAllProduct(){
        productList = ProductDao.getAllProduct();
        return productList;
    }

    public List<Product> findByName(String name){
        productList = ProductDao.findByName(name);
        return productList;
    }

    public void createProduct(Product product) {
        ProductDao.addProduct(product);
        productList = ProductDao.getAllProduct();
    }

    public void editProduct(Product product) {
        ProductDao.updateProduct(product);
        productList = ProductDao.getAllProduct();
    }

    public void deleteProduct(int id) {
        ProductDao.deleteProduct(id);
        productList = ProductDao.getAllProduct();
    }

    public int findIndexById(int id){
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getIdProduct() == id){
                return i;
            }
        }
        return -1;
    }
}
