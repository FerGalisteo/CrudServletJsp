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
 * Servlet implementation class EditarProductoServlet
 */
public class EditarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos del formulario
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        double peso = Double.parseDouble(request.getParameter("peso"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        
        // Lógica para actualizar el producto en la base de datos (usando JDBC)
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
            
            // Crear la sentencia SQL para actualizar el producto
            String sql = "UPDATE Producto SET Nombre=?, Descripcion=?, Peso=?, Stock=? WHERE ID=?";//NO logro hacer correctamente la actualización por el uso del ID.
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, descripcion);
            pstmt.setDouble(3, peso);
            pstmt.setInt(4, stock);
            pstmt.setInt(5, id);
          
            // Ejecutamos la sentencia sql del update
            pstmt.executeUpdate();
            
            // Redireccionar a la lista de productos
            response.sendRedirect("index.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Manejo de errores
        } finally {
            // Cerrar la conexión y la sentencia del sql
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
