package rs.euprava.gov.notifikator.service;

import rs.euprava.gov.notifikator.model.Vest;

import java.util.List;

public interface VestService {

    void save(Vest vest);

    void delete(Long id);

    List<Vest> findAll();

    List<Vest> findAll(String type);

    Vest findOne(Long id);
}
