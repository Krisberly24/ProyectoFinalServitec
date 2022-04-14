package jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.entity.EquipoTbl;

public interface IEquipo extends JpaRepository<EquipoTbl, Integer> {

}
