/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendisantika.pasien.repositories;

import com.hendisantika.pasien.domain.Pasien;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author hendi.santika
 */
public interface PasienRepository extends CrudRepository<Pasien, String>{}
