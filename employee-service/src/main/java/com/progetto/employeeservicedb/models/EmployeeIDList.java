package com.progetto.employeeservicedb.models;

import java.util.List;                                                                                                   //questa classe è presente anche nel servizio project-service

public class EmployeeIDList {
                                                                                                                         //questa classe è stata inserita per evitare gli errori dovuti al json.
                                                                                                                         //passare delle liste e non degli oggetti tra un microservizio ed un altro
    private List<String> lista;                                                                                          //infatti genera spesso degli errori e manda in crash l'applicazione


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
