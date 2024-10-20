<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String contextPath = request.getContextPath(); %>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" type="text/css" href="<%= contextPath %>/static/css/style2.css">
</head>
<body>
<div class="product-container">
    <h2>Add Product</h2>
    <form action="addhandler" method="post">
        <label for="productName">Product Name:</label>
        <input type="text" id="productName" name="productName" required>

        <label for="productDescription">Product Description:</label>
        <textarea id="productDescription" name="productDescription" required></textarea>

        <label for="productAmount">Product Amount:</label>
        <input type="text" id="productAmount" name="productAmount" required>

        <input type="submit" value="Add">
    </form>
    <!-- Back Button -->
    <form action="home"  style="margin-top: 10px;">
        <input type="submit" value="Back" class="back-button">
    </form>
</div>
</body>
</html>