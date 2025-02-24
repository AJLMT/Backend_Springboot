package com.ccsw.tutorial.client;

import com.ccsw.tutorial.client.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author ccsw
 *
 */
public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query("SELECT cli FROM Client cli WHERE cli.name = :name")
    Client findName(@Param("name") String name);
}