package ar.edu.unlu.poo.labo1.artefactos;

import ar.edu.unlu.poo.labo1.libreria.Libro;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.*;

public class CatalogoArtefactos {
    private Map<String, Artefacto> catalogo_a;

    public CatalogoArtefactos() {
        catalogo_a = new HashMap<>();
    }

    public void agregarArtefacto(Artefacto a) {
        String nombre = a.getNombre();
        if (!catalogo_a.containsKey(nombre)) catalogo_a.put(nombre, a);
    }

    public Set<Artefacto> obtenerArtefactosUnicos() {
        return new HashSet<>(catalogo_a.values());
    }

    public List<Artefacto> buscarArtefactosPorTipo(String tipo) {
        List<Artefacto> lista = new ArrayList<>();
        for (Artefacto a : catalogo_a.values()) {
            if(a.getTipo().equals(tipo)) lista.add(a);
        }
        lista.sort((Artefacto a1, Artefacto a2) ->  a2.getPoder() - a1.getPoder());
        return lista;
    }

    public Map<String, Integer> contarArtefactosPorTipo() {
        Map<String, Integer> mapa = new HashMap<>();
        for(Artefacto a : catalogo_a.values()) {
            String tipo = a.getTipo();
            if(mapa.containsKey(tipo)) {
                int cantidad = mapa.get(tipo);
                mapa.put(tipo, cantidad + 1); //Put reemplaza el valor si la clave es la misma.
            }
            else mapa.put(tipo, 1);
        }
        return mapa;

    }

    public Artefacto obtenerArtefactoMasPoderoso() {
        Artefacto masPoderoso = null;

        for(Artefacto a : catalogo_a.values()) {
            if(masPoderoso == null || a.getPoder() > masPoderoso.getPoder()) masPoderoso = a;
        }
        return masPoderoso;
    }
}
