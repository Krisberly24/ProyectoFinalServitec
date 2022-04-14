package jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.entity.PersonalTbl;

public interface IPersonalRepository extends JpaRepository<PersonalTbl, Integer> {

}
