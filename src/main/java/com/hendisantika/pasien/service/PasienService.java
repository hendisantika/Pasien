/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendisantika.pasien.service;

import com.hendisantika.pasien.domain.Pasien;
import java.util.Collection;

/**
 *
 * @author hendi.santika
 */
public interface PasienService {

    public Pasien savePasien(Pasien pasien);

    public Boolean deletePasien(String pasienId);

    public Pasien editPasien(Pasien pasien);

    public Pasien findPasien(String pasienId);

    public Collection<Pasien> getAllPasiens();

}
