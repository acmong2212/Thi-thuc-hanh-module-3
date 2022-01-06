package dao;

import model.Product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static dao.ConnectMySQL.getConnection;

public class ProductDao {
    static Connection connection = ConnectMySQL.getConnection();

    public static List<Product> getAllProduct() {
        String sqlGetAll = "select product.*, category.nameCategory from product\n" +
                "join category on product.idCategory = category.idCategory;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            ResultSet resultSet = preparedStatement.executeQuery(sqlGetAll);

            List<Product> productList = new ArrayList<>();

            while (resultSet.next()) {
                int idProduct = resultSet.getInt("idProduct");
                String nameProduct = resultSet.getString("nameProduct");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String nameCategory = resultSet.getString("nameCategory");
                int idCategory = resultSet.getInt("idCategory");

                productList.add(new Product(idProduct, nameProduct, price, quantity, color, description, nameCategory, idCategory));
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addProduct(Product product) {
        String addSQL = "INSERT INTO product (`nameProduct`, `price`, `quantity`, `color`, `description`, `idCategory`) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addSQL);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getIdCategory());

            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateProduct(Product product) {
        String UPDATE_PRODUCT_SQL = "update product set nameProduct = ?,price= ?, quantity =?, color=?, description=?, idCategory=? where (idProduct = ?);";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getIdCategory());
            preparedStatement.setInt(7, product.getIdProduct());

            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteProduct(int id) {
        String deleteSQL = "DELETE FROM product where idProduct = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Product> findByName(String findName) {
        String find = "select product.*, category.nameCategory from product\n" +
                "join category on product.idCategory = category.idCategory\n" +
                "where product.nameProduct like '%"+findName+"%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(find);
            ResultSet resultSet = preparedStatement.executeQuery(find);

            List<Product> productList = new ArrayList<>();

            while (resultSet.next()) {
                int idProduct = resultSet.getInt("idProduct");
                String nameProduct = resultSet.getString("nameProduct");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String nameCategory = resultSet.getString("nameCategory");
                int idCategory = resultSet.getInt("idCategory");

                productList.add(new Product(idProduct, nameProduct, price, quantity, color, description, nameCategory, idCategory));
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
