package rs.euprava.gov.notifikator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rs.euprava.gov.notifikator.model.Obavestenje;
import rs.euprava.gov.notifikator.repo.ObavestenjeRepo;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ObavestenjeServiceImpl implements ObavestenjeService {

    private ObavestenjeRepo obavestenjeRepo;

    @Autowired
    public ObavestenjeServiceImpl(ObavestenjeRepo obavestenjeRepo) {
        this.obavestenjeRepo = obavestenjeRepo;
    }

    @Transactional
    @Override
    public void save(Obavestenje obavestenje) {
        Date date = new Date();
        obavestenje.setCreatedDate(date);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Obavestenje> entity = new HttpEntity<>(obavestenje);
        restTemplate.exchange("http://6c75920a.ngrok.io/api/create-noty", HttpMethod.POST, entity, Obavestenje.class);

        obavestenjeRepo.save(obavestenje);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        obavestenjeRepo.deleteById(id);
    }

    @Override
    public List<Obavestenje> findAll() {
        return obavestenjeRepo.findAll();
    }

    @Override
    public List<Obavestenje> findAll(String type) {
        return obavestenjeRepo.findByType(type);
    }

    @Override
    public Obavestenje findOne(Long id) {
        return obavestenjeRepo.getOne(id);
    }
}
