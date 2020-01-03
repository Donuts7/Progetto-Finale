package com.progetto.managerservicedb.repository;

import com.progetto.managerservicedb.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends JpaRepository<Manager, String>, CrudRepository<Manager, String> {
}