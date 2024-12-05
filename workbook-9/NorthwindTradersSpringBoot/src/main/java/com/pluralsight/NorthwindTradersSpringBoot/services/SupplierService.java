package com.pluralsight.NorthwindTradersSpringBoot.services;

import com.pluralsight.NorthwindTradersSpringBoot.models.Suppliers;
import com.pluralsight.NorthwindTradersSpringBoot.repositories.SupplierRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private SupplierRepositories supplierRepositories;

    public SupplierService(SupplierRepositories supplierRepositories) {
        this.supplierRepositories = supplierRepositories;
    }

    // get all suppliers
    public List<Suppliers> getAllSuppliers() {
        return supplierRepositories.findAll();
    }

    // add a supplier
    public Suppliers addSupplier(Suppliers supplier) {
        return supplierRepositories.save(supplier);
    }

    // delete newly added supplier
    public void deleteSupplierById(long id) {
        supplierRepositories.deleteById(id);
    }

    // get by supplier id
    public Suppliers getSuppliersById(long id) {
        Optional<Suppliers> optionalSuppliers = supplierRepositories.findById(id);

        return optionalSuppliers.orElse(null);
    }

    // modify existing supplier
    public boolean updateSupplier(Suppliers supplier, long id) {
        Suppliers supplierToBeUpdated = getSuppliersById(id);

        if (supplierToBeUpdated != null) {
            supplierToBeUpdated.setCompanyName(supplier.getCompanyName());
            supplierToBeUpdated.setContactName(supplier.getContactName());
            supplierToBeUpdated.setContactTitle(supplier.getContactTitle());
            supplierToBeUpdated.setAddress(supplier.getAddress());
            supplierToBeUpdated.setCity(supplier.getCity());
            supplierToBeUpdated.setRegion(supplier.getRegion());
            supplierToBeUpdated.setPostalCode(supplier.getPostalCode());
            supplierToBeUpdated.setCountry(supplier.getCountry());
            supplierToBeUpdated.setPhone(supplier.getPhone());
            supplierToBeUpdated.setFax(supplier.getFax());
            supplierToBeUpdated.setHomepage(supplier.getHomepage());
            supplierRepositories.save(supplierToBeUpdated);
            return true;
        } else {
            return false;
        }
    }

    // get supplier by name
    public Optional<Suppliers> getSuppliersByName(String name){
        return supplierRepositories.findByCompanyName(name);
    }

    // get all suppliers by country
    public Optional<Suppliers> getSupplierByCountry(String country) {
        return supplierRepositories.findByCountry(country);
    }
}
