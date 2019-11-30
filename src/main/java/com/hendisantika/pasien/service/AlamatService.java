/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendisantika.pasien.service;

import com.hendisantika.pasien.domain.Alamat;

import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author hendi.santika
 */
public interface AlamatService {

    Alamat saveAlamat(Alamat alamat);

    Boolean deleteAlamat(Integer alamatId);

    Alamat editAlamat(Alamat alamat);

    Optional<Alamat> findAlamat(Integer alamatId);

    Collection<Alamat> getAllAlamats();
    
    
}
