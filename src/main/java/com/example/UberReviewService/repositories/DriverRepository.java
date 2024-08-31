package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    //JPA creates query based on the method name.
    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);

    //In case of complex tables and queries where a lot of joins are required, we use either raw query or hibernate query
    //raw query, any error is thrown at runtime if query has issue
    @Query(nativeQuery = true, value = "SELECT * FROM Driver WHERE id = :id AND license_number = :license")
    Optional<Driver> rawFindByIdAndLicenseNumber(Long id, String license);

    //hibernate query, error is thrown at compile time
    @Query("SELECT d FROM Driver as d WHERE d.id = :id AND d.licenseNumber = :ln")
    Optional<Driver> hqlFindByIdAndLicense(Long id, String ln);

    List<Driver> findAllByIdIn(List<Long> driverIds);
}
