package com.riwi.PruebaDesempeno.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.riwi.PruebaDesempeno.domain.entities.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Page<StudentEntity> findByNameContainingAndIsActive(Pageable pageable, String name, Boolean isActive); 
}
