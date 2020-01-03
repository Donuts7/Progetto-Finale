package com.progetto.projectservicedb.models;

import java.util.List;

public class ProjectIDList {

    private List<String> lista;

    public Integer getSize()
    {return lista.size();}

    public String getElement(int i){
        return lista.get(i);
    }
    public ProjectIDList() {}

    public ProjectIDList(List<String> lista) {
        this.lista = lista;
    }

    public void aggiungi(String projectID){
        lista.add(projectID);
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }
}
