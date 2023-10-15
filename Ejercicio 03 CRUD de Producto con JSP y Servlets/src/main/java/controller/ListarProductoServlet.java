package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ListarProductoServlet
 */
public class ListarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       //System.out.println("Hola mundo");
	    	
	    	Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        
	        try {
	            // Cargar el controlador de MySQL
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // Establecer la conexión con la base de datos
	            String jdbcUrl = "jdbc:mysql://localhost:3306/DWSU2CrudProducto";
	               String usuario = "root";
	               String contraseña = "aaa";
	            conn = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
	            
	            // Crear la sentencia SQL para obtener la lista de productos
	            String sql = "SELECT * FROM Producto";
	            pstmt = conn.prepareStatement(sql);
	            
	            // Ejecutar la consulta
	            rs = pstmt.executeQuery();
	            
	            // Crear una lista de productos para almacenar los resultados
	            List<Producto> productos = new ArrayList<>();
	            
	            // Recorrer los resultados y crear objetos Producto
	            while (rs.next()) {
	                Producto producto = new Producto();
	                producto.setId(rs.getInt("ID"));
	                producto.setNombre(rs.getString("Nombre"));
	                producto.setDescripcion(rs.getString("Descripcion"));
	                producto.setPeso(rs.getInt("Peso"));
	                producto.setStock(rs.getInt("Stock"));
	                productos.add(producto);
	            }
	            
	            // Guardar la lista de productos en el objeto request
	            request.setAttribute("productos", productos);
	          //  System.out.println(productos);
	            // Redireccionar a la página JSP para mostrar la lista de productos
	            request.getRequestDispatcher("listarProducto.jsp").forward(request, response);
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            // Manejo de errores
	        } finally {
	            // Cerrar la conexión y la sentencia
	            try {
	                if (rs != null) {
	                    rs.close();
	                }
	                if (pstmt != null) {
	                    pstmt.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

