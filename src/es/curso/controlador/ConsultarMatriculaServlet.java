package es.concesionario.controladores;

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
 * Servlet implementation class ConsultarMatriculaServlet
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
		String matricula=request.getParameter("matriculaCoche");
		// invocar al Negocio
		Negocio negocio=new Negocio();
		// ArrayList<Coche> coches=negocio.consultarMatricula();
		ArrayList<Coche> coches=negocio.consultarMatricula(matricula);
				
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
