<%@ page import="com.ProductApp.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String contextPath = request.getContextPath(); %>
<html>
<head>
  <title>Update Product</title>
  <link rel="stylesheet" type="text/css" href="<%= contextPath %>/static/css/style2.css">
</head>
<body>
<div class="product-container">
  <h2>Update Product</h2>
  <%
    Product product = (Product)request.getAttribute("product");
  %>
  <form action="afterupdate" method="post">
    <!-- Use value attribute to pre-fill the input field with existing product data -->
    <label for="productName">Product Name:</label>
    <input type="text" id="productName" name="productName" value="<%= product.getProductName()%>">

    <label for="productDescription">Product Description:</label>
    <textarea id="productDescription" name="productDescription"><%= product.getProductDescription()%></textarea>

    <label for="productAmount">Product Amount:</label>
    <input type="text" id="productAmount" name="productAmount" value="<%= product.getProductAmount()%>">


    <input type="submit" value="Update" class="update-button">
  </form>

  <!-- Back Button -->
  <form action="home" style="margin-top: 10px;">
    <input type="submit" value="Back" class="back-button">
  </form>
</div>
</body>
</html>
