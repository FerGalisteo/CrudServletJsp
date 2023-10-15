package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class EliminarProductoServlet
 */
public class EliminarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el ID del producto a eliminar de la URL
        int id = Integer.parseInt(request.getParameter("id"));
        
        // Lógica para eliminar el producto de la base de datos usando JDBC
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            // Cargar el controlador de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establecer la conexión con la base de datos
            String jdbcUrl = "jdbc:mysql://localhost:3306/DWSU2CrudProducto";
            String usuario = "root";
            String contraseña = "aaa";
            conn = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            
            // Creamos la sentencia SQL para eliminar el producto
            String sql = "DELETE FROM Producto WHERE ID=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            
            // Ejecutar la sentencia SQL de eliminación
            pstmt.executeUpdate();
            
            // Redireccionar a al index tras eliminar
            response.sendRedirect("index.jsp");
            
          //  response.sendRedirect("listarProducto.jsp");
          // Al igual que en otros casos, no he logrado redireccionar correctamente a la lista, me aparece unicamente el th del html, con todo lo demás vacío.

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Manejo de errores
           
        } finally {
            // Cerrar la conexión y la sentencia
            try {
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
