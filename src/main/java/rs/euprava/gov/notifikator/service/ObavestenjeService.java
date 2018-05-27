package rs.euprava.gov.notifikator.service;

import rs.euprava.gov.notifikator.model.Obavestenje;

import java.util.List;

public interface ObavestenjeService {

    void save(Obavestenje obavestenje);

    void delete(Long id);

    List<Obavestenje> findAll();

    List<Obavestenje> findAll(String type);

    Obavestenje findOne(Long id);
}
