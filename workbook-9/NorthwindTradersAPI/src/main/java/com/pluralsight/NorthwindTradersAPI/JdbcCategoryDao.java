package com.pluralsight.NorthwindTradersAPI;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCategoryDao implements CategoryDAO{
    private DataSource dataSource;

    @Autowired
    public JdbcCategoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();

        String query = "SELECT * FROM Categories";

        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryId(rs.getInt("CategoryId"));
                category.setCategoryName(rs.getString("CategoryName"));
                categories.add(category);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return categories;
    }

    @Override
    public Category getById(int id) {
        String query = "SELECT * FROM Categories WHERE CategoryId = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, id);
            try(ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Category category = new Category();
                    category.setCategoryId(rs.getInt("CategoryId"));
                    category.setCategoryName(rs.getString("CategoryName"));
                    return category;
                }

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Category getByName(String productName) {
        String query = "Select * FROM Categories WHERE CategoryName = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, productName);
            try(ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Category category = new Category();
                    category.setCategoryId(rs.getInt("CategoryId"));
                    category.setCategoryName(rs.getString("CategoryName"));
                    return category;
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Category addCategory(Category category) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Categories (CategoryID, CategoryName) values(?, ?)");
            preparedStatement.setInt(1, category.getCategoryId());
            preparedStatement.setString(2, category.getCategoryName());
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " were added.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }
}
