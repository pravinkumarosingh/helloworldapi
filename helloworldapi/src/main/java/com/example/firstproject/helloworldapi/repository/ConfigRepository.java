package com.example.firstproject.helloworldapi.repository;

import com.example.firstproject.helloworldapi.model.PortConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConfigRepository extends JpaRepository<PortConfig, Long> {

    @Query(value = "select count(*) from port_config where status = 'Active' ", nativeQuery = true)
    Integer getCountByStatus();

    @Query(value = "select * from port_config where status = 'Active' ", nativeQuery = true)
    List<PortConfig> findByStatus();

}
