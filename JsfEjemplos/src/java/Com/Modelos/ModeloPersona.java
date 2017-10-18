package Com.Modelos;

import Com.Clases.Persona;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

@Named(value = "modeloPersona")
@SessionScoped
public class ModeloPersona implements Serializable {

    private Persona PersonaNueva = new Persona();
    private static List<Persona> ListaPersonas = new ArrayList<Persona>();

    public void ValidatorSexo(FacesContext Cont, UIComponent comp, Object contrl) {
        Cont = FacesContext.getCurrentInstance();
        String txt = (String) contrl;

        // logica de validacion
        if (!txt.contains("M") && !txt.contains("F")) {
            ((UIInput) comp).setValid(false);
            Cont.addMessage(comp.getClientId(Cont), new FacesMessage("Valores invalidos"));
        }
    }


    public static List<Persona> getListaPersonas() {
        return ListaPersonas;
    }

    public static void setListaPersonas(List<Persona> ListaPersonas) {
        ModeloPersona.ListaPersonas = ListaPersonas;
    }
    
    

    public List<Persona> PersonasAgregadas() {
        return ModeloPersona.ListaPersonas;
    }

    public void RemocerPersona(Persona p) {
        ModeloPersona.ListaPersonas.remove(p);
    }

    public void agregarPersona() {
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
    
    public void StartSession (String User){
        
        // verificar si existe una sesion, si no iniciar una nueva
        Map<String,Object> HashSessiones = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        
        if(!HashSessiones.keySet().contains(User))
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(User,this.PersonaNueva);
 
    }

    public void cerrarSesion () throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    
    public String conseguirUsuario (String Usr){
        
 
        if( FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(Usr) != null )
            return Usr + "usuario activo";
        
        return Usr + "usuario inactivo";
    }
    
    
    public String verificarSession(String UsrLoged){
        
        if( FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(UsrLoged) != null )
            return "Pagina2.xhtml";
        
        return "Error.xhtml";
        
    }
   
      
   

}
