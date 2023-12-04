import java.util.LinkedList;
import java.util.Queue;

public class ListadoAutos {
    //queue es una interfaz no puede ser instanciable
    private Queue<Auto> listadoAutos;

    public ListadoAutos() {
        listadoAutos= new LinkedList<Auto>();
    }

    public void encolar(Auto dato){
        listadoAutos.add(dato);

    }

    public Auto desencolar() throws Exception{
        if(listadoAutos.isEmpty())
            throw new Exception("No hay elementos en la fila");
        return listadoAutos.remove();
    }

    //Usamos for each para recorrer sin usar indices
    public String listarAutos(){
        String resultado=" ";
        for (Auto auto:listadoAutos) {
           resultado+=auto.toString();
        }
        //Si es verdadero retorna resultado
        //si no es verdadero retorna el texto "No hay..."
        return listadoAutos.size()>0?resultado:"No hay elementos";
    }
}
