package rs.euprava.gov.notifikator.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.euprava.gov.notifikator.model.Obavestenje;

import java.util.List;

@Repository
public interface ObavestenjeRepo extends JpaRepository<Obavestenje, Long> {
    List<Obavestenje> findByType(String type);
}
