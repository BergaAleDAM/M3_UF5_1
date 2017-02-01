package infoelement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InfoElement  {

    private Element e;

    public InfoElement(Element e) {
        this.e = e;
    }

    public String nomSuperClasse() {
        return e.getClass().getSuperclass().getSimpleName();
    }

    public String nomSencerClasse() {
        return e.getClass().getCanonicalName();
    }

    public String nomNomesClasse() {
        return e.getClass().getSimpleName();
    }

    public Field[] arrayAtributsClasse() {

        return e.getClass().getDeclaredFields();
    }

    public Method[] arrayMetodesClasse() {

        return e.getClass().getMethods();
    }

    public String[] arrayNomAtributsClasse() {

        Field[] atributosField = arrayAtributsClasse();
        String[] atributosNombre = new String[atributosField.length];
        for (int i = 0; i < atributosField.length; i++) {
            atributosNombre[i] = atributosField[i].getName();
        }

        return atributosNombre;

    }

    public String[] arrayNomMetodesClasse() {

        Method[] metodos = arrayMetodesClasse();
        String[] nomMetodos = new String[metodos.length];

        for (int i = 0; i < metodos.length; i++) {
            nomMetodos[i] = metodos[i].getName();
        }

        return nomMetodos;
    }

    public int modificadorField(String atribut) {

        String[] atributos = arrayNomAtributsClasse();

        for (String atributo : atributos) {
            if (atributo.equals(atribut)) {
                return atributo.getClass().getModifiers();
            }
        }
        return 0;

    }

    public int modificadorMetodes(String metodo) {
        
        String[] metodos = arrayNomAtributsClasse();

        for (String metodo1 : metodos) {
            if(metodo1.equals(metodo)){
                return metodo1.getClass().getModifiers();
            }
        }
        return 0;

    }
    
    
    public void ejecutaMetodo(Method metodo){
        
        try {
            metodo.invoke(e, null);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(InfoElement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearInstancia(int numero, String cosa){
        
        Element element = new Element(numero, cosa);
        
    }
    
    public Element clon() throws CloneNotSupportedException{
    
        Element element =null;
        try{
        return element.clone();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return element;
    }   

}
