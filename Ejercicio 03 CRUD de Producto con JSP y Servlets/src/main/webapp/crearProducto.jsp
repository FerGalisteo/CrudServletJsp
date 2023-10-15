<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Producto</title>
</head>
<body>
    <h1>Crear Producto</h1>
    <form action="CrearProductoServlet" method="post">
        Nombre: <input type="text" name="nombre" required><br>
        Descripción: <input type="text" name="descripcion"><br>
        Peso: <input type="text" name="peso" required><br>
        Stock: <input type="text" name="stock" required><br>
        <input type="submit" value="Guardar">
    </form>
    <br>
    <a href="listarProducto.jsp">Volver a la lista de productos</a>
</body>
</html>
