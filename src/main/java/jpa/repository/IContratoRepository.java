package jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jpa.entity.ContratoTbl;

@Repository
public interface IContratoRepository extends JpaRepository<ContratoTbl, Integer>{

}
