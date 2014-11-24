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
 * Servlet implementation class DarAltaServlet
 */
@WebServlet("/DarAlta")
public class DarAltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	/* Constructor por defecto */
    public DarAltaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    /* Método doGet */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /* 1 Recuperar los datos de la URL */
   	/* 2 Adaptarlos si es necesario al tipo de datos del modelo*/
    
    // recibe un String, devuelve un String
    String matricula = request.getParameter("matricula"); 
    
    // recibe un String, devuelve un String
    String marca = request.getParameter("marca"); 
    
    // recibe un String, devuelve un String
    String modelo = request.getParameter("modelo"); 
    
   // recibe un String, devuelve un String
    String color = request.getParameter("color"); 
    
    // recibe un String, le damos la vuelta para convertirlo en un entero con "Integer.parseInt("	
    int numcaballos = Integer.parseInt(request.getParameter("numcaballos")); 
 		
    
    // si en el html la "caja de chequeo" no está checheado por defecto
 	// nos puede fallar al ejecutar. Tenemos que preguntar si el campo
 	// "trabaja" está viajando en la URL (si la chequearon)
 	
    String tienemarchas= request.getParameter("marchas");
	boolean marchas=true;
	// true-> si;   false-> no
	if(tienemarchas.equals("true")){
			marchas=true;
	}
	else{
	        marchas=false;
	}
 	
 	/* 3 Pasarle los datos recuperados a la capa Negocio */
    
    //kk
    
    String darAlta=request.getParameter("darAlta");
		   
	Negocio negocio = new Negocio();
	String mensajeDoGet=negocio.darAlta(matricula, marca, modelo, color, numcaballos, marchas);
	   
	// llamamos al método "darAlta" dentro de negocio.java
	// negocio.darAlta es un metodo String que recibe "matricula, marca, modelo, color, numcaballos, marchas"
	// y devuelve un String "msg" que no tiene por qué 
	// llamarse igual que nuestra variable mensajeDoGet
    
	if(darAlta==null)// si ha fallado el alta
	{
	  // meter el mensaje en el request
	  request.setAttribute("mensajeVistaMensajeJsp", mensajeDoGet);
	   
  	  //redirigir a la vista el mensaje
	
	  RequestDispatcher rd=request.getRequestDispatcher("vistaMensaje.jsp");
	  rd.forward(request, response);
	  
	}else{// si el alta ha ido bien
      
		// además de darlo de alta en la BBDD 
		// muestro todos los coches...
      
		//... o redirigir a la vista o consulta "mostrarTodos"
		ArrayList<Coche> coches=negocio.consultarTodos();
	
		// meter el arrayList en el request
		request.setAttribute("listado", coches);
		// redirigir al código jsp "mostrarTodos"
		RequestDispatcher rd;
		rd=request.getRequestDispatcher("mostrarTodos.jsp");
		rd.forward(request, response);
        }
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
