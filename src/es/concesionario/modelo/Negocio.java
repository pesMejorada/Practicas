package es.concesionario.modelo;

import java.util.ArrayList;

import javax.jws.WebService;

import es.concesionario.integracion.CocheDAO;
import es.concesionario.modelo.Coche;


public class Negocio {
	private CocheDAO cochedao = CocheDAO.getInstance();
	
	public int DarAlta(String matricula,String marca,String modelo,String color,int numCaballos,boolean marchas){
		 Coche coche= new Coche(matricula,marca,modelo,color,numCaballos,marchas);
	        int id =cochedao.darAlta(coche);
	      return  id;
	}
	public Coche consultarUno(int id) {
	       // validar si el q solicita la consulta tiene autorizacion
	        Coche coche =cochedao.consultarUno(id);
	      
	        return coche;
	    }

	    public ArrayList<Coche> consultarTodos() {
	       //reglas...
	        //-....
	       ArrayList<Coche> coches=cochedao.consultarTodos();
	      return coches;
	    }

	    public ArrayList<Coche> consultarMatricula(String matricula) {
	        ArrayList<Coche> coches=cochedao.consultarMatricula(matricula);
	        return coches;
	    }

		public String borrar(int id) {
			String msg;
			int cochesBorrados=cochedao.borrar(id);
			if(cochesBorrados>=1){
				msg="SE HAN BORRADO"+cochesBorrados +"coches";
			}else{
				msg="No se ha podido borrar";
			}
			return msg;
		}
		public String actualizar(int id, String matricula, String marca, String modelo,
				String color, int numCaballos, boolean marchas) {
			String msg;
			
			int cochesactualizados=cochedao.actualizar(id,matricula,marca,modelo,color,numCaballos,marchas);
		
				msg="Coches actualizados :"+cochesactualizados;
	
			
		
			return msg;
		}
		

}
