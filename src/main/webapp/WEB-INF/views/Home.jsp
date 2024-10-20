<%@ page import="java.util.List" %>
<%@ page import="com.ProductApp.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Product List</title>
  <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/css/style1.css">
</head>
<body>
<div class="product-container">
  <h2>Product List</h2>
  <%
    List<Product> products = (List<Product>)request.getAttribute("productList");
  %>
  <div class="table-container">
    <table>
      <thead>
      <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Product Description</th>
        <th>Product Amount</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <%
        if (products != null && !products.isEmpty()) {
          for (Product product : products) {
      %>
      <tr>
        <td>Product <%= product.getId() %></td>
        <td><%= product.getProductName() %></td>
        <td><%= product.getProductDescription() %></td>
        <td><%= product.getProductAmount() %></td>
        <td>
          <div class="actions">
            <!-- Update button -->
            <form action="updatehandler" method="post" style="margin: 0;">
              <input type="hidden" name="id" value="<%= product.getId() %>">
              <input type="submit" value="Update" class="button">
            </form>
            <!-- Delete button -->
            <form action="deletehandler" method="post" style="margin: 0;">
              <input type="hidden" name="id" value="<%= product.getId() %>">
              <input type="submit" value="Delete" class="button"
                     onclick="return confirm('Are you sure you want to delete this product?');">
            </form>
          </div>
        </td>

      </tr>
      <%
        }
      } else {
      %>
      <tr>
        <td colspan="5" style="text-align: center;">No products found.</td>
      </tr>
      <%
        }
      %>
      </tbody>
    </table>
  </div>
  <!-- Button to redirect to the Add Product page, centered -->
  <div class="add-product-button">
    <form action="addProduct" method="post">
      <input type="submit" value="Add Product" class="button">
    </form>
  </div>
</div>
</body>
</html>

