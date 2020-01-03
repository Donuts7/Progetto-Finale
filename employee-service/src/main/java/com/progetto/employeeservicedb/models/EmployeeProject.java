package com.progetto.employeeservicedb.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@IdClass(EmployeeProjectID.class)                                        //con questa annotazione si fa riferimento alla classe EmployeeProjectID
@Entity
@Table(name = "employeeproject")
public class EmployeeProject {

    @Id
    @Column(name ="employeeID")
    private String employeeID;
    @Id
    @Column(name ="projectID")
    private String projectID;

    public EmployeeProject() {}

    public EmployeeProject(String employeeID, String projectID) {
        this.employeeID = employeeID;
        this.projectID = projectID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }
    /*
insert into employeeproject(employeeId,projectID)
values("003","003");
insert into employeeproject(employeeId,projectID)
values("003","004");
insert into employeeproject(employeeId,projectID)
values("003","002");
insert into employeeproject(employeeId,projectID)
values("005","003");
insert into employeeproject(employeeId,projectID)
values("005","004");
insert into employeeproject(employeeId,projectID)
values("006","006");
insert into employeeproject(employeeId,projectID)
values("006","003");
insert into employeeproject(employeeId,projectID)
values("007","001");
insert into employeeproject(employeeId,projectID)
values("007","002");
insert into employeeproject(employeeId,projectID)
values("007","004");
insert into employeeproject(employeeId,projectID)
values("008","006");
insert into employeeproject(employeeId,projectID)
values("009","003");
insert into employeeproject(employeeId,projectID)
values("010","004");*/
}
