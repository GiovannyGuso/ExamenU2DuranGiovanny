package grafo.aydacencia;

import java.util.ArrayList;
import java.util.List;

public class VerticeAdy {
      String nombreCiudad;
    int numVertice;
    List<VerticeAdy> lad; // lista de adyacencia
        // constructor 
    public VerticeAdy(String x) {
        nombreCiudad = x;
        numVertice = -1;
        lad = new ArrayList<>();
    }
 
    public String nomVertice() { 
        return nombreCiudad;
    }

     public boolean equals(VerticeAdy n) {
        return nombreCiudad.equals(n.nombreCiudad);
    }
     public void asigVert(int n) {
        numVertice = n;
    }
     public String toString() {
        return nombreCiudad + " (" + numVertice + ")";
    }
     public void agregarArco(VerticeAdy destino) {
        lad.add(destino);
    }
     public boolean esAdyacente(VerticeAdy otroVertice) {
        return lad.contains(otroVertice);
    }
}
