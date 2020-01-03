package com.progetto.projectservicedb.models;

import java.util.List;

public class EmployeeIDList {                                                                                            //questa classe è stata inserita per evitare gli errori dovuti al json.
                                                                                                                         //passare delle liste e non degli oggetti tra un microservizio ed un altro
    private List<String> lista;                                                                                          //infatti genera spesso degli errori e manda in crash l'applicazione

    public Integer getSize()
    {return lista.size();}

    public String getElement(int i){
        return lista.get(i);
    }
    public EmployeeIDList() {}

    public EmployeeIDList(List<String> lista) {
        this.lista = lista;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }

}
