package com.pluralsight.NorthwindTradersSpringBoot.controllers;

import com.pluralsight.NorthwindTradersSpringBoot.models.Suppliers;
import com.pluralsight.NorthwindTradersSpringBoot.services.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("suppliers")
public class SupplierController {
    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    // get all suppliers
    @GetMapping
    public ResponseEntity<List<Suppliers>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    // add a suppliers
    @PostMapping
    public ResponseEntity<Suppliers> addSupplier(@RequestBody Suppliers supplier) {
        if (supplier.getSupplierId() != 0) {
            return ResponseEntity.badRequest().build();
        }

        Suppliers newSupplier = supplierService.addSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSupplier);
    }

    // delete new supplier
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable long id) {
        supplierService.deleteSupplierById(id);
        return ResponseEntity.ok().build();
    }

    // get supplier by id
    @GetMapping("{id}")
    public ResponseEntity<Suppliers> getSupplierById(@PathVariable long id) {
        Suppliers supplierFound = supplierService.getSuppliersById(id);

        if (supplierFound == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(supplierFound);
    }

    // update supplier
    @PutMapping("{id}")
    public ResponseEntity<Void> updateSupplier(@RequestBody Suppliers supplier, @PathVariable long id) {
        boolean success = supplierService.updateSupplier(supplier, id);

        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Optional<Suppliers>> getSupplierByName(@PathVariable String name) {
        return ResponseEntity.ok(supplierService.getSuppliersByName(name));
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<Optional<Suppliers>> getSupplierByCountry(@PathVariable String country) {
        return ResponseEntity.ok(supplierService.getSupplierByCountry(country));
    }
}
