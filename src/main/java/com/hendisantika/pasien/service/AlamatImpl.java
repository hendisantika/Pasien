/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendisantika.pasien.service;

import com.hendisantika.pasien.domain.Alamat;
import com.hendisantika.pasien.repositories.AlamatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author hendi.santika
 */
@Service @Transactional
public class AlamatImpl implements AlamatService{

    @Autowired
    private AlamatRepository alamatRepository;

    @Override
    public Alamat saveAlamat(Alamat alamat) {
        return alamatRepository.save(alamat);
    }

    @Override
    public Boolean deleteAlamat(Integer alamatId) {
        Optional<Alamat> temp = alamatRepository.findById(alamatId);
        if (!temp.isPresent()) {
            alamatRepository.delete(temp.get());
            return true;
        }
        return false;
    }

    @Override
    public Alamat editAlamat(Alamat alamat) {
        return alamatRepository.save(alamat);
    }

    @Override
    public Optional<Alamat> findAlamat(Integer alamatId) {
        return this.alamatRepository.findById(alamatId);
    }

    @Override
    public Collection<Alamat> getAllAlamats() {
        Iterable<Alamat> itr = alamatRepository.findAll();
        return (Collection<Alamat>) itr;
    }


}
