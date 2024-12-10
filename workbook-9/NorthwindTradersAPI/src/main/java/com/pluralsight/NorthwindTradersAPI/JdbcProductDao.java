package com.pluralsight.NorthwindTradersAPI;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDAO{
    private DataSource dataSource;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        String query = "SELECT * FROM Products";

        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                Product product = new Product();
                        product.setProductId(rs.getInt("ProductId"));
                        product.setProductName(rs.getString("ProductName"));
                        product.setCategoryId(rs.getInt("CategoryId"));
                        product.setUnitPrice(rs.getDouble("UnitPrice"));
                        products.add(product);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return products;
    }

    @Override
    public Product getProductsById(int id) {
        String query = "SELECT * FROM Products WHERE ProductId = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, id);
            try(ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setProductId(rs.getInt("ProductId"));
                    product.setProductName(rs.getString("ProductName"));
                    product.setCategoryId(rs.getInt("CategoryId"));
                    product.setUnitPrice(rs.getDouble("UnitPrice"));
                    return product;
                }

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Product getproductByName(String name) {
        String query = "Select * FROM Products WHERE ProductName = ?";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            try(ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setProductId(rs.getInt("ProductId"));
                    product.setProductName(rs.getString("ProductName"));
                    product.setCategoryId(rs.getInt("CategoryId"));
                    product.setUnitPrice(rs.getDouble("UnitPrice"));
                    return product;
                }
            }

            } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
