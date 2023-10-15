<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Productos</title>
</head>
<body>
    <h1>Lista de Productos</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Peso</th>
            <th>Stock</th>
            <th>Acciones</th>
        </tr>
     
        <c:forEach var="producto" items="${productos}">
            <tr>
                <td><c:out value="${producto.id}" /></td>
                <td>${producto.nombre}</td>
                <td>${producto.descripcion}</td>
                <td>${producto.peso}</td>
                <td>${producto.stock}</td>
                <td>
                    <a href="EditarProducto.jsp?id=${producto.id}">Editar</a>
                    <a href="EliminarProductoServlet?id=${producto.id}">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="crearProducto.jsp">Crear nuevo producto</a>
</body>
</html>

</html>