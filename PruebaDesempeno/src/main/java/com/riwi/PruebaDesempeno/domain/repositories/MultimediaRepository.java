package com.riwi.PruebaDesempeno.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.riwi.PruebaDesempeno.domain.entities.MultimediaEntity;

@Repository
public interface MultimediaRepository extends JpaRepository<MultimediaEntity, Long> {
    
}
