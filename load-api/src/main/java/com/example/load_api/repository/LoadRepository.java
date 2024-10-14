package com.example.load_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.load_api.model.Load;
import java.util.List;

public interface LoadRepository extends JpaRepository<Load, Long> {
    List<Load> findByShipperId(Long shipperId);
}
