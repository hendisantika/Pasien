/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendisantika.pasien.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author hendi.santika
 */
@Entity
@Table(name = "pasien2")
public class Pasien {
    @Id
    @GenericGenerator(name = "sequence_pasienId", strategy = "com.hendisantika.pasien.domain.PasienIdGenerator")
    @GeneratedValue(generator = "sequence_pasienId")
    @Column(name = "pasienId")
    private String pasienId;

    @Column(name = "nama")
    private String name;

    @Column(name = "kelurahan")
    private String kelurahan;

    @Column(name = "kecamatan")
    private String kecamatan;

    @Column(name = "kota")
    private String kota;

    @Column(name = "telpon")
    private String telpon;

    @Column(name = "rtrw")
    private String rtrw;

    @Column(name = "tanggalLahir")
    private String tanggalLahir;

    @Column(name = "kelamin")
    private String kelamin;

    public String getPasienId() {
        return pasienId;
    }

    public void setPasienId(String pasienId) {
        this.pasienId = pasienId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getRtrw() {
        return rtrw;
    }

    public void setRtrw(String rtrw) {
        this.rtrw = rtrw;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getKelamin() {
        return kelamin;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }
}
