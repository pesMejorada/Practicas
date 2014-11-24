package es.concesionario.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.concesionario.modelo.Negocio;

/**
 * Servlet implementation class ProcesarServlet
 */
@WebServlet("/Procesar")
public class ProcesarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recupero los datos de http://localhost:8090/Ej00_ConcesionarioWeb/ConsultarUno?idCoche=1&enviar=ENVIAR 
		   int id= Integer.parseInt(request.getParameter("id"));
		   String matricula=request.getParameter("matricula");
		   String marca=request.getParameter("marca");
		   String modelo=request.getParameter("modelo");
		   String color=request.getParameter("color");
		   int numcaballos=Integer.parseInt(request.getParameter("numcaballos"));
		   
 		   String  marchasSoN=request.getParameter("marchas");
		   boolean marchas=true;
		   // true-> si;   false-> no
		   
		   //cadena=nombre.substring(0, (nombre.length()-1));
		   
		   if(marchasSoN.substring(0, 1).equals("S"))
		     {marchas=true;}
		   else
		     {marchas=false;}
		   
		   String borrar=request.getParameter("borrar");
		   String actualizar=request.getParameter("actualizar");
		   
		   Negocio negocio = new Negocio();
		   String mensajeDoGet = "";
		   
		   // Proceso borrar. "mensaje" = filasBorradas
		   if(borrar!=null)
		   {
			mensajeDoGet = negocio.borrar(id);
		   }
		   if(actualizar!=null)
		   {
			mensajeDoGet = negocio.actualizar(id, matricula, marca, modelo, color, numcaballos, marchas);
		   }
		   // llamamos al método "borrar" dentro de negocio.java
		   // negocio.borrar es un metodo String que recibe un "id" entero
		   // y devuelve un String "msg" que no tiene por qué 
		   // llamarse igual que nuestra variable mensajeDoGet
		   
		   // meter el mensaje en el request
		   request.setAttribute("mensajeVistaMensajeJsp", mensajeDoGet);
		   
		   //redirigir a la vista el mensaje
		   RequestDispatcher rd=request.getRequestDispatcher("vistaMensaje.jsp");
		   rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
