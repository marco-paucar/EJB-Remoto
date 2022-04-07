
package com.empresa.sga.cliente;

import com.empresa.sga.domain.Persona;
import com.empresa.sga.servicio.PersonaServiceRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientePersonaService {
    public static void main(String[] args) {
        System.err.println("desde el cliente");
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService  = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!com.empresa.sga.servicio.PersonaServiceRemote");
            List<Persona> personas = personaService.listarPersonas();
            
             for(Persona persona: personas){
                System.out.println(persona);
            }
            
            System.out.println("\nFin llamada al EJB desde el cliente");
            
        } catch (NamingException ex) {
            Logger.getLogger(ClientePersonaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
