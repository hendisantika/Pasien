/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendisantika.pasien.dao;

import com.hendisantika.pasien.domain.Alamat;
import com.hendisantika.pasien.repositories.AlamatRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hendi.santika
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = "/data/alamat.sql"
)
public class AlamatDaoTest {
    @Autowired
    private AlamatRepository ar;
    
    @Autowired
    private DataSource ds;
    
    @Before
    public void insertSampleData(){
        
    }
    
    @Test
    public void testInsert() throws SQLException{
        Alamat a = new Alamat();
        a.setId("BB1");
        a.setKelurahan("Tanjungsari");
        a.setKecamatan("Cangkuang");
        a.setKota("Bandung");
        
        ar.save(a);
        
        String sql = "select count(*) as jumlah "
                + "from alamat "
                + "where kecamatan = 'Cangkuang'";
        
        try (Connection c = ds.getConnection()) {
            ResultSet rs = c.createStatement().executeQuery(sql);
            
            Assert.assertTrue(rs.next());
            
            Integer jumlahRow = rs.getInt("jumlah");
            Assert.assertEquals(new Integer(1), jumlahRow);
        }
    }
    
    @Test
    public void testHitung(){
        Long jumlah = ar.count();
        Assert.assertEquals(8L, jumlah.longValue());
    }
    
//    @Test
//    public void testCariById(){
//        Alamat al = ar.findOne(1);
//        Assert.assertNotNull(al);
//        Assert.assertEquals("Cirengit", al.getKelurahan());
//        Assert.assertEquals("Cibabat", al.getKelurahan());
        
//        Alamat a2 = ar.findOne(100);
//        Assert.assertNull(a2);
//    }
    
    @After
    public void hapusData() throws SQLException{
        String sql = "delete from alamat where kecamatan = 'Cangkuang'";
        try(Connection c = ds.getConnection()){
            c.createStatement().executeUpdate(sql);
        }
    }
}
