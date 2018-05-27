package rs.euprava.gov.notifikator.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.euprava.gov.notifikator.model.Obavestenje;
import rs.euprava.gov.notifikator.model.Vest;

import java.util.List;

@Repository
public interface VestRepo extends JpaRepository<Vest, Long> {
    List<Vest> findByType(String type);
}
