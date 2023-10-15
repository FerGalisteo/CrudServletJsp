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
import java.sql.SQLException;

/**
 * Servlet implementation class CrearProductoServlet
 */
public class CrearProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  //System.out.println("Hola mundo");
	           // Obtener los datos del formulario
	           String nombre = request.getParameter("nombre");
	           String descripcion = request.getParameter("descripcion");
	           Integer peso = Integer.parseInt(request.getParameter("peso"));
	           Integer stock = Integer.parseInt(request.getParameter("stock"));
	           
	           // Lógica para guardar el producto en la base de datos (usando JDBC)
	           Connection conn = null;
	           PreparedStatement pstmt = null;
	           
	           try {
	               // Carga el controlador de MySQL
	               Class.forName("com.mysql.cj.jdbc.Driver");
	               
	               // Establecemos la conexión con la base de datos
	               String jdbcUrl = "jdbc:mysql://localhost:3306/DWSU2CrudProducto";
	               String usuario = "root";
	               String contraseña = "aaa";
	               conn = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
	               
	               // Creamos la sentencia SQL para insertar el nuevo producto
	               String sql = "INSERT INTO Producto (Nombre, Descripcion, Peso, Stock) VALUES (?, ?, ?, ?)";
	               pstmt = conn.prepareStatement(sql);
	               pstmt.setString(1, nombre);
	               pstmt.setString(2, descripcion);
	               pstmt.setInt(3, peso);
	               pstmt.setInt(4, stock);
	               
	               // Ejecutamos la sentencia SQL
	               pstmt.executeUpdate();
	               
	               // Redireccionar a la lista de productos
	               //¡¡¡IMPORTANTÍSIMO!!!!
	              response.sendRedirect("index.jsp");
	               
		            // Guardar la lista de productos en el objeto request
		            //request.setAttribute("productos", productos);
		          //  System.out.println(productos);
		            // Redireccionar a la página JSP para mostrar la lista de productos
		          //  request.getRequestDispatcher("listarProducto.jsp").forward(request, response);
	               
	               
	               
	           } catch (ClassNotFoundException | SQLException e) {
	               ((Throwable) e).printStackTrace();
	               // Manejo de errores
	               // Falta añadir como manejar las excepciones pero weno
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

		  /* protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // Obtener los datos del formulario
       String nombre = request.getParameter("nombre");
       String descripcion = request.getParameter("descripcion");
       Integer peso = Integer.parseInt(request.getParameter("peso"));
       int stock = Integer.parseInt(request.getParameter("stock"));
       
       // Crear un objeto Producto
       Producto producto = new Producto();
       producto.setNombre(nombre);
       producto.setDescripcion(descripcion);
       producto.setPeso(peso);
       producto.setStock(stock);
       
       // Lógica para guardar el producto en la base de datos usando JDBC
       // No necesitas establecer el ID aquí
       
       // Redireccionar a la lista de productos
       response.sendRedirect("listar.jsp");
   }*/
