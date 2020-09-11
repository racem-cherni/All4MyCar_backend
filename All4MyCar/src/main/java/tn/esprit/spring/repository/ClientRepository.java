package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.User;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}
