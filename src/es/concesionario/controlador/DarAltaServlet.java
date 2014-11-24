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
 * Servlet implementation class DarAltaServlet
 */
@WebServlet("/DarAlta")
public class DarAltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DarAltaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String matricula=request.getParameter("matricula");
		String marca=request.getParameter("marca");
		String modelo=request.getParameter("modelo");
		String color=request.getParameter("color");
		int numCaballos=Integer.parseInt(request.getParameter("numCaballos"));
		String marcha=request.getParameter("marchas");
		boolean marchas;
		if(marcha.equals("marchasSi")){
			marchas=true;
		}else{
			marchas=false;
		}
		Negocio negocio= new Negocio();
		int id=negocio.DarAlta(matricula,marca,modelo,color,numCaballos,marchas);
		Coche e=negocio.consultarUno(id);
		request.setAttribute("coche",e);
		//redirigir a la vistaIndividual
		RequestDispatcher rd;
		rd= request.getRequestDispatcher("vistaIndividual.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}
		
		
	     
		
	

