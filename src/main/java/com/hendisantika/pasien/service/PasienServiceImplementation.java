package com.hendisantika.pasien.service;

import com.hendisantika.pasien.repositories.PasienRepository;
import com.hendisantika.pasien.domain.Pasien;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Pasien temp = pasienRepository.findOne(pasienId);
        if (temp != null) {
            pasienRepository.delete(temp);
            return true;
        }
        return false;
    }

    @Override
    public Pasien editPasien(Pasien pasien) {
        return pasienRepository.save(pasien);
    }

    @Override
    public Pasien findPasien(String pasienId) {
        return this.pasienRepository.findOne(pasienId);
    }

    @Override
    public Collection<Pasien> getAllPasiens() {
        Iterable<Pasien> itr = pasienRepository.findAll();
        return (Collection<Pasien>) itr;
    }


}
