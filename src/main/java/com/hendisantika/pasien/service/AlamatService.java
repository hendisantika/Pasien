/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendisantika.pasien.service;

import com.hendisantika.pasien.domain.Alamat;
import java.util.Collection;

/**
 *
 * @author hendi.santika
 */
public interface AlamatService {
    
    public Alamat saveAlamat(Alamat alamat);
    
    public Boolean deleteAlamat(Integer alamatId);
    
    public Alamat editAlamat(Alamat alamat);
    
    public Alamat findAlamat(Integer alamatId);
    
    public Collection<Alamat> getAllAlamats();
    
    
}
