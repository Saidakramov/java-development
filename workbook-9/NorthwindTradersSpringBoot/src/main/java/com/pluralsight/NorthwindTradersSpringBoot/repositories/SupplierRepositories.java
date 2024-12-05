package com.pluralsight.NorthwindTradersSpringBoot.repositories;

import com.pluralsight.NorthwindTradersSpringBoot.models.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepositories extends JpaRepository<Suppliers, Long> {
    Optional<Suppliers> findByCompanyName(String name);
    Optional<Suppliers> findByCountry(String country);
}
