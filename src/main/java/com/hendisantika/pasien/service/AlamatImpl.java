/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendisantika.pasien.service;

import com.hendisantika.pasien.domain.Alamat;
import com.hendisantika.pasien.repositories.AlamatRepository;
import java.util.Collection;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Alamat temp = alamatRepository.findOne(alamatId);
        if(temp != null){
            alamatRepository.delete(temp);
            return true;
        }
        return false;
    }

    @Override
    public Alamat editAlamat(Alamat alamat) {
        return alamatRepository.save(alamat);
    }

    @Override
    public Alamat findAlamat(Integer alamatId) {
        return this.alamatRepository.findOne(alamatId);
    }

    @Override
    public Collection<Alamat> getAllAlamats() {
        Iterable<Alamat> itr = alamatRepository.findAll();
        return (Collection<Alamat>) itr;
    }
    
    
}
