package com.dulcemordidaService.venta.repository;

import com.dulcemordidaService.venta.entity.Venta;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
    List<Venta> findAllByOrderByIdDesc();

    Venta findById(@Param("id") int id);

    List<Venta> findByFechaVentaBetween(@Param("fechaInicial") LocalDate fechaInicial, @Param("fechaFinal") LocalDate fechaFinal);

    @Query(value = "call getDailySales()", nativeQuery = true)
    Tuple getDailySales();

    @Query(value = "call getTotalWeeklySales()", nativeQuery = true)
    List<Tuple> getTotalWeeklySales();

    @Query(value = "call getWeeklySales()", nativeQuery = true)
    Tuple getWeeklySales();

    @Query(value = "call getTotalMonthlySales()", nativeQuery = true)
    Tuple getTotalMonthlySales();

    @Query(value = "call getTotalYearlySales()", nativeQuery = true)
    List<Tuple> getTotalYearlySales();

    @Query(value = "call getYearlySales()", nativeQuery = true)
    Tuple getYearlySales();
}