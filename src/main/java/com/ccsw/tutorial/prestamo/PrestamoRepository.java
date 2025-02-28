package com.ccsw.tutorial.prestamo;

import com.ccsw.tutorial.prestamo.model.Prestamo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PrestamoRepository extends CrudRepository<Prestamo, Long> {

    /**
     * Método para recuperar un listado paginado de {@link Prestamo}
     *
     * @param pageable pageable
     * @return {@link Page} de {@link Prestamo}
     */
    Page<Prestamo> findAll(Specification<Prestamo> specification, Pageable pageable);

    @Query("SELECT p FROM Prestamo p WHERE p.game_name = :game_name AND :ini_Date <= p.end_Date AND :end_Date >= p.ini_Date AND p.client_name <> :client_name")
    List<Prestamo> findAPrestam(@Param("client_name") String client_name, @Param("game_name") String game_name, @Param("ini_Date") LocalDate startDate, @Param("end_Date") LocalDate endDate);

    @Query("SELECT COUNT(p) FROM Prestamo p WHERE p.client_name = :client_name AND :ini_Date <= p.end_Date AND :end_Date >= p.ini_Date")
    int countClientPrestam(@Param("client_name") String client_name, @Param("ini_Date") LocalDate startDate, @Param("end_Date") LocalDate endDate);
}