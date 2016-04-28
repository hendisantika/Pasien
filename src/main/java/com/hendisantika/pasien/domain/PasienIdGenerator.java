/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendisantika.pasien.domain;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 *
 * @author hendi.santika
 */
public class PasienIdGenerator implements IdentifierGenerator {

    public Serializable generate(SessionImplementor session, Object object)
            throws HibernateException {

        String prefix = "PAS-";
//        String prefix = "1500";
        Connection connection = session.connection();
        try {

            PreparedStatement ps = connection
                    .prepareStatement("SELECT MAX(pasien_id) as value from db_pasien.pasien2");

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("value") + 1;
//                String id = rs.getString("value") + 1;
                String code = prefix + new Integer(id);
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
