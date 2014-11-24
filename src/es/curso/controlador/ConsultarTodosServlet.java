package es;

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
 * Servlet implementation class consultarTodosServlet
 */
@WebServlet("/ConsultarTodos")
public class ConsultarTodosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarTodosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// invocar al Negocio
		Negocio negocio=new Negocio();
		// 1er escribo...
		// ArrayList<Coche> coches=negocio.consultarTodos();
		// me pide importar "Coche" de "es.concesionario.modelo"
		ArrayList<Coche> coches=negocio.consultarTodos();
		
		// meter el arrayList en el request
		request.setAttribute("listado", coches);
		// redirigir al código jsp "mostrarTodos"
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
