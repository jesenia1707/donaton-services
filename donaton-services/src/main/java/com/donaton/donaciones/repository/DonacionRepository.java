package com.donaton.donaciones.repository;

import com.donaton.donaciones.entity.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonacionRepository extends JpaRepository<Donacion, Long> {
}