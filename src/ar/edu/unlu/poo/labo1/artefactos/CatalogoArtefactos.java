package ar.edu.unlu.poo.labo1.artefactos;

import ar.edu.unlu.poo.labo1.libreria.Libro;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.*;

public class CatalogoArtefactos {
    private Map<String, Artefacto> catalogo_a = new HashMap<>();

    public CatalogoArtefactos(Artefacto a) {
        String tipo = a.getTipo();
        catalogo_a.put(tipo, a);
    }

    public void agregarArtefacto(Artefacto a) {
        String tipo = a.getTipo();
        catalogo_a.put(tipo, a);
    }

    public Set<Artefacto> obtenerArtefactosUnicos() {
        return new HashSet<>(this.catalogo_a.values());
    }

    public List<Artefacto> buscarArtefactosPorTipo(String tipo) {
        List<Artefacto> lista = new ArrayList<>();
        lista.add(catalogo_a.get(tipo));
        lista.sort((Artefacto a1, Artefacto a2) ->  a1.getPoder() - a2.getPoder());
        return lista;
    }

    public Map<String, Integer> contarArtefactosPorTipo() {
        Map<String, Integer> mapa = new HashMap<>();
        for(Map.Entry<String, Artefacto> entry : catalogo_a.entrySet()) {
            Artefacto a = entry.getValue();
            mapa.put(a.getTipo(), catalogo_a.get()); //Falta terminar
        }
        return mapa;

    }

    public Artefacto obtenerArtefactoMasPoderoso() {
        //Falta terminar
    }
}
