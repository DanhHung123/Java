<%@ page import="com.example.demo2.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>

<form method="GET" action="/productList">
    <input type="text" name="searchName" placeholder="Enter product name">
    <button type="submit">Search</button>
</form>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <% for (Product product : (List<Product>) request.getAttribute("products")) { %>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %></td>
    </tr>
    <% } %>
    </tbody>
</table>

<div>
    <% int totalPages = (int) request.getAttribute("totalPages");
        for (int i = 1; i <= totalPages; i++) { %>
    <a href="?page=<%= i %>"><%= i %></a>
    <% } %>
</div>
</body>
</html>
