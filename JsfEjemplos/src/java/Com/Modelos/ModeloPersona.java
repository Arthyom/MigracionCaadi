
package Com.Modelos;

import Com.Clases.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "modeloPersona")
@RequestScoped
public class ModeloPersona {
    
    private Persona PersonaNueva = new Persona ();
    private static  List<Persona> ListaPersonas = new ArrayList<Persona>();


    public List<Persona> PersonasAgregadas (){
        return  ModeloPersona.ListaPersonas;
    }
    
    public void RemocerPersona (Persona p){
        ModeloPersona.ListaPersonas.remove(p);
    }
    
    public void agregarPersona (){
         ModeloPersona.ListaPersonas.add(this.PersonaNueva);
    }
    
    
    public ModeloPersona() {
    }

    public Persona getPersonaNueva() {
        return PersonaNueva;
    }

    public void setPersonaNueva(Persona PersonaNueva) {
        this.PersonaNueva = PersonaNueva;
    }

    public List<Persona> getListaPersona() {
        return ListaPersonas;
    }

    public void setListaPersona(List<Persona> ListaPersona) {
        ModeloPersona.ListaPersonas = ListaPersona;
    }
    
    
    
}
