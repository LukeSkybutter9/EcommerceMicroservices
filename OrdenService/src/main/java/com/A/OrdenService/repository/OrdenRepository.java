package com.A.OrdenService.repository;

import com.A.OrdenService.entity.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository  extends JpaRepository<Orden, Long> {

}
