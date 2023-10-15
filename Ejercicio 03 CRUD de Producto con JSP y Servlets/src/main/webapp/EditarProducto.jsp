<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Producto</title>
</head>
<body>
    <h1>Editar Producto</h1>
    
    <form action="EditarProductoServlet" method="post">
        <input type="hidden" name="id" value="${producto.id}">
		<p>ID del producto: ${producto.id}</p> <!-- Para comprobar si recibo el dato, que no lo consigo recibir. -->
        
        
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" value="${producto.nombre}" required><br>
        
        <label for="descripcion">Descripción:</label>
        <input type="text" name="descripcion" value="${producto.descripcion}"><br>
        
        <label for="peso">Peso:</label>
        <input type="text" name="peso" value="${producto.peso}" required><br>
        
        <label for="stock">Stock:</label>
        <input type="text" name="stock" value="${producto.stock}" required><br>
        
        <input type="submit" value="Actualizar">
    </form>
    
    <br>
    <a href="index.jsp">Volver a la lista de productos</a>
    <!-- No consigo que el enlace a listarProducto.jsp funcione, la tabla me sale vacía, de ahí la redirección al index.-->
</body>
</html>
