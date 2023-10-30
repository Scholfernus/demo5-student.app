package com.example.demo5.repository;

import com.example.demo5.model.StudentModel;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmParentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Long> {

//    List<StudentModel> findSortedNamesOrderByLastNameAsc();
}
