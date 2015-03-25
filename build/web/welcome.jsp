<%-- 
    Document   : welcome
    Created on : Mar 25, 2015, 2:24:54 PM
    Author     : Phuc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
    </head>
    <body>
        <form action="ProductManageServlet" method="post">
            Product List:<br/><br/>
            <table border="1">
                <tr>
                    <td>Product Name</td>
                    <td>Manufacturer</td>
                    <td>Product Price</td>
                    <td></td>
                    <td></td>
                </tr>
                <c:forEach items="${listProduct}" var="product">
                    <tr>
                        <td>${product.productName}</td>
                        <td>${product.manufacture}</td>
                        <td>${product.price}</td>
                        <td><input type="submit" name="button" value="Edit"/></td>
                        <td><input type="submit" name="button" value="Delete"/></td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" name="button" value="Add new product"/>
        </form>
    </body>
</html>
