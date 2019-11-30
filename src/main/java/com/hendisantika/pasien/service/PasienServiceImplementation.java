package com.hendisantika.pasien.service;

import com.hendisantika.pasien.domain.Pasien;
import com.hendisantika.pasien.repositories.PasienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class PasienServiceImplementation implements PasienService {

    @Autowired
    protected PasienRepository pasienRepository;

    @Override
    public Pasien savePasien(Pasien pasien) {
        return pasienRepository.save(pasien);
    }

    @Override
    public Boolean deletePasien(String pasienId) {
        // TODO Auto-generated method stub
        Optional<Pasien> temp = pasienRepository.findById(pasienId);
        if (!temp.isPresent()) {
            pasienRepository.delete(temp.get());
            return true;
        }
        return false;
    }

    @Override
    public Pasien editPasien(Pasien pasien) {
        return pasienRepository.save(pasien);
    }

    @Override
    public Optional<Pasien> findPasien(String pasienId) {
        return this.pasienRepository.findById(pasienId);
    }

    @Override
    public Collection<Pasien> getAllPasiens() {
        Iterable<Pasien> itr = pasienRepository.findAll();
        return (Collection<Pasien>) itr;
    }


}
