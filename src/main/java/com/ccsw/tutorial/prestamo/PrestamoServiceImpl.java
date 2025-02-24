package com.ccsw.tutorial.prestamo;

import com.ccsw.tutorial.common.criteria.SearchCriteria;
import com.ccsw.tutorial.prestamo.model.Prestamo;
import com.ccsw.tutorial.prestamo.model.PrestamoDto;
import com.ccsw.tutorial.prestamo.model.PrestamoSearchDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    PrestamoRepository prestamoRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Prestamo get(Long id) {

        return this.prestamoRepository.findById(id).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Prestamo> findPage(PrestamoSearchDto dto, String clientName, String gameTitle, Date date) {
        Specification<Prestamo> especificacion = Specification.where(null);
        if (gameTitle != null)
            especificacion = especificacion.and(new PrestamoSpecification(new SearchCriteria("game_name", ":", gameTitle)));

        if (clientName != null)
            especificacion = especificacion.and(new PrestamoSpecification(new SearchCriteria("client_name", ":", clientName)));

        if (date != null) {
            especificacion = especificacion.and(new PrestamoSpecification(new SearchCriteria("ini_Date", ":<", date)));
            especificacion = especificacion.and(new PrestamoSpecification(new SearchCriteria("end_Date", ":>", date)));
        }

        return this.prestamoRepository.findAll(especificacion, dto.getPageable().getPageable());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Long id, PrestamoDto dto) throws Exception {
        Prestamo prestamo;
        Date ini_Date = dto.getIni();
        Date end_Date = dto.getEnd();
        Long days = end_Date.getTime() - ini_Date.getTime();
        days = days / (1000 * 60 * 60 * 24); //Pasamos de milisegundos a días

        if (end_Date.before(ini_Date)) {
            throw new Exception("Fecha de fin de prestamo es inferior a la de inicio. ERROR!!!");
        }

        if (days > 14) {
            throw new Exception("El prestamo tiene una duración de más de 14 días. ERROR!!!!");
        }

        List<Prestamo> Prestams = prestamoRepository.findAPrestam(dto.getClient_Name(), dto.getClient_Name(), ini_Date, end_Date);

        if (Prestams.stream().anyMatch(existingPrestamo -> !existingPrestamo.getClient_Name().equals(dto.getClient_Name()))) {
            throw new Exception("Este juego ya está prestado. ERROR!!!!");
        }

        int clientPrestamos = prestamoRepository.countClientPrestam(dto.getClient_Name(), dto.getIni(), dto.getEnd());
        
        if (clientPrestamos >= 1)
            throw new Exception("El cliente ya tiene un prestamo en esas fechas");

        if (id == null) {
            prestamo = new Prestamo();
        } else {
            prestamo = this.prestamoRepository.findById(id).orElse(null);
        }

        BeanUtils.copyProperties(dto, prestamo, "id", "client", "game");
        prestamo.setClient_Name(dto.getClient_Name());
        prestamo.setGame_Name((dto.getGame_Name()));

        this.prestamoRepository.save(prestamo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) throws Exception {

        if (this.get(id) == null) {
            throw new Exception("Not exists");
        }

        this.prestamoRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Prestamo> findAll() {
        return (Page<Prestamo>) this.prestamoRepository.findAll();
    }
}