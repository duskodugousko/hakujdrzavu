package rs.euprava.gov.notifikator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rs.euprava.gov.notifikator.model.Vest;
import rs.euprava.gov.notifikator.repo.VestRepo;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class VestServiceImpl implements VestService {

    private VestRepo vestRepo;

    @Autowired
    public VestServiceImpl(VestRepo vestRepo) {
        this.vestRepo = vestRepo;
    }

    @Transactional
    @Override
    public void save(Vest vest) {
        Date date = new Date();
        vest.setCreatedDate(date);

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<Vest> entity = new HttpEntity<>(vest);
            restTemplate.exchange("http://6c75920a.ngrok.io/api/create-news", HttpMethod.POST, entity, Vest.class);
        } catch (Exception e) {

        }

        vestRepo.save(vest);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        vestRepo.deleteById(id);
    }


    @Override
    public List<Vest> findAll() {
        return vestRepo.findAll();
    }

    @Override
    public List<Vest> findAll(String type) {
        return vestRepo.findByType(type);
    }

    @Override
    public Vest findOne(Long id) {

        return vestRepo.getOne(id);
    }
}
