/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendisantika.pasien.domain;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author hendi.santika
 */
public abstract class PasienIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object)
            throws HibernateException {

        String prefix = "PAS-";
//        String prefix = "1500";
        try (Connection connection = session.getJdbcConnectionAccess().obtainConnection()) {

            PreparedStatement ps = connection
                    .prepareStatement("SELECT MAX(pasien_id) AS VALUE FROM db_pasien.pasien");

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("value") + 1;
//                String id = rs.getString("value") + 1;
                String code = prefix + Integer.valueOf(id);
//                String code = prefix + id;

//                String code = prefix + StringUtils.leftPad("" + id, 3, '0');
                System.out.println("Generated pasienId: " + code);
                return code;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
