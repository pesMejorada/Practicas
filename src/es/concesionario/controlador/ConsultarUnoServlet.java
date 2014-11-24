package es.concesionario.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.concesionario.modelo.Coche;
import es.concesionario.modelo.Negocio;



/**
 * Servlet implementation class ConsultarUnoServlet
 */
@WebServlet("/ConsultarUno")
public class ConsultarUnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarUnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		   
	    Negocio negocio = new Negocio();
	    Coche coche =negocio.consultarUno(id);
	    
	    // meter el pais en el request.. uso el metodo setAttribute
	    request.setAttribute("coche", coche);
	    // Redirigir hacia la pagina jsp que muestra los datos del pais.
	    RequestDispatcher rd;
	    rd=request.getRequestDispatcher("vistaIndividual.jsp");
	    rd.forward(request, response);
		}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
