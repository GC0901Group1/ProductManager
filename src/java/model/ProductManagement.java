/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phuc
 */
public class ProductManagement {

    private List<Product> productList = new ArrayList<>();
    private ResultSet rs;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProduct() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://PHUC-PC:1433;databaseName=ShoppingMVC";
            String id = "sa";
            String pass = "123456";
            Connection conn = DriverManager.getConnection(url, id, pass);
            PreparedStatement ps = conn.prepareStatement("select * from Product");
            rs = ps.executeQuery();
            while (rs.next()) {
                Product productInfo = new Product();
                productInfo.setProductName(rs.getString("ProductName"));
                productInfo.setManufacture(rs.getString("Manufacture"));
                productInfo.setPrice(rs.getInt("Price"));
                productList.add(productInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
}
