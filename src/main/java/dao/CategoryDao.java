package dao;

import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    static Connection connection = ConnectMySQL.getConnection();

    public static List<Category> getAllCategory() {
        String sqlGetAll = "SELECT * FROM category";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            ResultSet resultSet = preparedStatement.executeQuery(sqlGetAll);

            List<Category> categoryList = new ArrayList<>();

            while (resultSet.next()) {
                int idCategory = resultSet.getInt("idCategory");
                String nameCategory = resultSet.getString("nameCategory");

                categoryList.add(new Category(idCategory, nameCategory));
            }
            return categoryList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
