/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendisantika.pasien.service;

import com.hendisantika.pasien.domain.Pasien;

import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author hendi.santika
 */
public interface PasienService {

    Pasien savePasien(Pasien pasien);

    Boolean deletePasien(String pasienId);

    Pasien editPasien(Pasien pasien);

    Optional<Pasien> findPasien(String pasienId);

    Collection<Pasien> getAllPasiens();

}
