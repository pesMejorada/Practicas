package es.concesionario.integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.util.logging.Level;
import java.util.logging.Logger;


import es.concesionario.modelo.Coche;

public class CocheDAO {
    
	     private Connection cx;
	     private static CocheDAO cocheDao=null;
	     
	     private CocheDAO(){
	     }
	     public static CocheDAO getInstance(){
	    	 if(CocheDAO.cocheDao==null)
	    		 CocheDAO.cocheDao= new CocheDAO();
	    	 return CocheDAO.cocheDao;
	     }
	   
	     private void conectar() {
	     try {
	            Class.forName("com.mysql.jdbc.Driver");
	            cx= DriverManager.getConnection("jdbc:mysql://localhost:3306/CONCESIONARIO","root","root");
	            cx.setAutoCommit(false);
	     }
    catch(SQLException e) {
             
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error en SQL ", e);
         }
	     catch(ClassNotFoundException e) {
	         Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "No se encuentra lib mySQL ", e);
         }
     
	    
	    
	      
	     }
	     private void desconectar() {
	         try {
	             if(cx!=null)
	                cx.close();
	        } catch (SQLException e) {
	           
	            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error al cerrar conexión ", e);
	        }
	         
	         
	     }
	       public int darAlta(Coche coche) {
	              int id=0;
	            try {
	                
	                //1. conectar
	                conectar();
	              //2.Preparar la sql (query)
	                PreparedStatement ps =cx.prepareStatement("INSERT INTO COCHE VALUES(?,?,?,?,?,?,?)"); 
	                  // 2.1 setear los interrogantes...
	                ps.setInt(1, 0);
	                ps.setString(2, coche.getMatricula());
	                ps.setString(3, coche.getMarca());
	                ps.setString(4, coche.getModelo());
	                ps.setString(5, coche.getColor());
	                ps.setInt(6, coche.getNumCaballos());
	                ps.setBoolean(7, coche.isMarchas());
	                
	                //3. Ejecutar la consulta
	                 int filasAfectadas =ps.executeUpdate();
	               
	                   //4.  hacer el commit....
	                 cx.commit();
	                 if(filasAfectadas>=1) {
	                     id= ultimoId();    
	               }
	               
	            } catch (SQLException e) {
	                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error SQL ", e);
	            }
	            finally {
	                //.5.cerrar la conexión
                    desconectar();
	              }
	         return id;
	    }
	    public Coche consultarUno(int id) {
	        Coche p = new Coche();
	           try {
	          //1. conectar
	            conectar();
	          //2. preparar la consulta
	            PreparedStatement ps;
	            ps = cx.prepareStatement("SELECT * FROM COCHE WHERE ID=?");
	           // 2.1 setear los ?
	                ps.setInt(1, id);
	           // 3, ejecutar la consulta
	             ResultSet rs =ps.executeQuery();  
	           //4. llenar el objeto coche.. con los datos de respuesta de BBDD..
	                //Nota: La respuesta viene en un objeto ResultSet
	             if(rs.next()) {
	                 p.setId(rs.getInt("id"));
	                 p.setMatricula(rs.getString("matricula"));
	                 p.setMarca(rs.getString("marca"));
	                 p.setModelo(rs.getString("modelo"));
	                 p.setColor(rs.getString("color"));
	                 p.setNumCaballos(rs.getInt("numCaballos"));
	                 p.setMarchas(rs.getBoolean("marchas"));
	                 
	             }
	          
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error SQL ", e);
	        }
	           finally {
	               //5.desconectar
	                 desconectar();
	           }
	      return p;
	    }
	    public ArrayList<Coche> consultarTodos() {
	        ArrayList<Coche> coches= new ArrayList<Coche>();
	       
	        try {
	            //1. conectar
	            conectar();
	            //2. preparar la sentencia
	            PreparedStatement ps = cx.prepareStatement("SELECT * FROM COCHE");
	            //3. ejecutar la consulta
	            ResultSet consulta = ps.executeQuery();
	            //4. bajar el resultado de la consulta y ponerlo en el arrayList
	            while(consulta.next()) {
	                Coche p = new Coche();
	                p.setId(consulta.getInt("id"));
	                p.setMatricula(consulta.getString("matricula"));
	                p.setMarca(consulta.getString("marca"));
	                p.setModelo(consulta.getString("modelo"));
	                p.setColor(consulta.getString("color"));
	                p.setNumCaballos(consulta.getInt("numCaballos"));
	                p.setMarchas(consulta.getBoolean("marchas"));	                
	                coches.add(p);
	            }
	           
	        } catch (SQLException e) {
	            
	            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error SQL ", e);
	        }
	        finally {
                //5.desconectar
                  desconectar();
            }
	        
	        return coches;
	    }
	    
	    
	    public int  ultimoId() {
	    	int  idM=90;
	    	try {
	    		//1. conectar
	    		conectar();
	    		//2. preparar la sentencia
	    		PreparedStatement ps = cx.prepareStatement("SELECT MAX(ID) AS ULTIMO FROM COCHE");
	    		//3. ejecutar la consulta
	    		ResultSet consulta = ps.executeQuery();
	    		//4. bajar el resultado de la consulta y ponerlo en el arrayList
	    		if(consulta.next()) {
	    			idM=consulta.getInt("ULTIMO");
	    		}
	    		
	    	} catch (SQLException e) {
	    		    		
	    		 Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Calculo ultimo id", e);
	    		
	    		
	    	
	    	}
	    	finally {
                //5.desconectar
                  desconectar();
            }
	    	return idM;
	    }
	    public ArrayList<Coche> consultarMatricula(String matricula) {
	    	ArrayList<Coche> coches= new ArrayList<Coche>();
	    	try {
	    		//1. conectar
	    		conectar();
	    		//2. preparar la sentencia
	    		PreparedStatement ps = cx.prepareStatement("SELECT * FROM COCHE WHERE MATRICULA LIKE ?");
	    		// 2.1 setear el interrogante
	    		ps.setString(1, "%"+matricula+"%");
	    		//3. ejecutar la consulta
	    		ResultSet consulta = ps.executeQuery();
	    		//4. bajar el resultado de la consulta y ponerlo en el arrayList
	    		while(consulta.next()) {
	    			Coche p = new Coche();
	    			p.setId(consulta.getInt("id"));
	    			p.setMatricula(consulta.getString("matricula"));
	    			p.setMarca(consulta.getString("marca"));
	    			p.setModelo(consulta.getString("modelo"));
	    			p.setColor(consulta.getString("color"));
	    			p.setNumCaballos(consulta.getInt("numCaballos"));
	    			p.setMarchas(consulta.getBoolean("marchas"));
	    			coches.add(p);
	    		}
	    		
	    	} catch (SQLException e) {
	    		
	    	    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Calculo ultimo id", e);
	    	}
	    	finally {
                //5.desconectar
                  desconectar();
            }
	    	return coches;
	    }
	    public int borrar(int id) {
	    	int filasAfectada=0;
	    	try {
	    		conectar();
	    		PreparedStatement ps = cx.prepareStatement("DELETE FROM COCHE WHERE ID=?");
	    		ps.setInt(1,id);
	    		filasAfectada=ps.executeUpdate();
	    		cx.commit();
	    			} catch (SQLException e) {
	    		// TODO Auto-generated catch block
	    			    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error SQL ", e);
	    	}     finally {
                //5.desconectar
                desconectar();
          }  
	    	return filasAfectada;
	    }
	    public int actualizar(int id, String matricula, String marca,
	    		String modelo, String color, int numCaballos, boolean marchas) {
	    	int filasAfectada=0;
	    	try {
	    		conectar();
	    		PreparedStatement ps = cx.prepareStatement("UPDATE COCHE SET MATRICULA=?,MARCA=?,MODELO=?,COLOR=?	,NUMCABALLOS=?,MARCHAS=? WHERE ID=?");
	    		ps.setString(1, matricula);
	    		ps.setString(2, marca);
	    		ps.setString(3, modelo);
	    		ps.setString(4, color);
	    		ps.setInt(5, numCaballos);
	    		ps.setBoolean(6, marchas);
	    		ps.setInt(7, id);
	    		filasAfectada=ps.executeUpdate();
	    		cx.commit();
	    	
	    	} catch (SQLException e) {
	    		
	    	    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error SQL ", e);
	    	}   
	    	finally {
                //5.desconectar
                  desconectar();
            }
	    	return filasAfectada;
	    }
}
	    			
	    	
	    
	    
	                
	                
	                
