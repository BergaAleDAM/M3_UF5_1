package infoelement;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        
        Element e = new Element(20,"hola");
      
        InfoElement ie = new InfoElement(e);
//        
        System.out.println(ie.nomNomesClasse());
        System.out.println(ie.nomSuperClasse());
        System.out.println(ie.nomSencerClasse());
//      

         ie.crearInstancia(22, "holo");
    }

}
