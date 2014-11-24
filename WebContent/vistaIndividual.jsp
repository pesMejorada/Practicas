package es.concesionario.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.concesionario.modelo.Coche;
import es.concesionario.modelo.Negocio;



/**
 * Servlet implementation class ConsularServlet
 */
@WebServlet("/ConsultarMatricula")
public class ConsultarMatriculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarMatriculaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matricula= request.getParameter("matricula");
		   
	    Negocio negocio = new Negocio();
	    ArrayList<Coche> coche = negocio.consultarMatricula(matricula);
	    
	    // meter el coche en el request.. uso el metodo setAttribute
	    request.setAttribute("listado", coche);
	    // Redirigir hacia la pagina jsp que muestra los datos del coche.
	    RequestDispatcher rd;
	    rd=request.getRequestDispatcher("mostrarTodos.jsp");
	    rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
