package grafo.aydacencia;

import java.util.ArrayList;
import java.util.List;

public class GrafoAdcia {
    
    int numVerts;
    static int maxVerts = 20;
    VerticeAdy[] tablAdc;
    
    public GrafoAdcia(int mx) {
        tablAdc = new VerticeAdy[mx];
        numVerts = 0;
        maxVerts = mx;
    }
    
    public int numVertice(String vs) {
        for (int i = 0; i < numVerts; i++) {
            if (tablAdc[i].nombreCiudad.equals(vs)) {
                return i;
            }
        }
        return -1;
    }

    public void nuevoVertice(String nom) {
        boolean esta = numVertice(nom) >= 0;
        if (!esta) {
            VerticeAdy v = new VerticeAdy(nom);
            v.asigVert(numVerts);
            tablAdc[numVerts++] = v;
        }
    }

    public void nuevoArco(String origen, String destino) {
        int vOrigen = numVertice(origen);
        int vDestino = numVertice(destino);
        
        if (vOrigen >= 0 && vDestino >= 0) {
            tablAdc[vOrigen].agregarArco(tablAdc[vDestino]);
        }
    }

    public boolean sonAdyacentes(String a, String b) {
        int vA = numVertice(a);
        int vB = numVertice(b);

        if (vA >= 0 && vB >= 0) {
            return tablAdc[vA].esAdyacente(tablAdc[vB]);
        }

        return false;
    }
    
    public void DFS(int v) {
        boolean[] visitado = new boolean[numVerts];
        DFSRec(v, visitado);
    }
    
    private void DFSRec(int v, boolean[] visitado) {
        visitado[v] = true;
        System.out.println(tablAdc[v].nombreCiudad);
        
        for (VerticeAdy ady : tablAdc[v].lad) {
            int adyIndex = numVertice(ady.nombreCiudad);
            if (!visitado[adyIndex]) {
                DFSRec(adyIndex, visitado);
            }
        }
    }
    }    

