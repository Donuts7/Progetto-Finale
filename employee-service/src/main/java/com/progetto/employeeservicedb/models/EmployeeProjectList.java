package com.progetto.employeeservicedb.models;

import java.util.ArrayList;
import java.util.List;

public class EmployeeProjectList {                                                                                       //questa classe è necessaria in quanto in questa architettura è necessario che per ogni lista composta da EmployeeProject
    private List<EmployeeProject> lista;                                                                                 //venga estratta una lista contente solamente gli employeeID presenti nella lista iniziale. Ciò viene fatto dal metodo getEmployeeIDList

    public EmployeeProjectList(){}



    public List<String> getEmployeeIDList(){                                                                            //metodo che restituisce una lista di employeeID (String)
        List<String> nuova = new ArrayList<>();                                                                         //viene creata una nuova lista vuota, che viene popolata
        for(int i =0;i<lista.size();i++){                                                                               //all'interno del ciclo for
            nuova.add(lista.get(i).getEmployeeID());                                                                    //per ogni elemento della lista (composta da istanze EmployeeProject) il
        }                                                                                                               //metodo getEmployeeID estrapola solo l'employeeID e lo inserisce nella lista di stringhe, denominata ''nuova''
        return nuova;
    }                                                                                                                   //questo metodo viene chiamato dall'omonimo metodo "getEmployeeIDList" presente in EmployeeResource


    public List<EmployeeProject> getLista() {
        return lista;
    }

    public void setLista(List<EmployeeProject> lista) {
        this.lista = lista;
    }
}
