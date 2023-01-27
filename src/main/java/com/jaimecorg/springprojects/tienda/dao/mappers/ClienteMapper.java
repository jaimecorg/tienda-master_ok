package com.jaimecorg.springprojects.tienda.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.jaimecorg.springprojects.tienda.model.Cliente;

public class ClienteMapper implements RowMapper<Cliente>{

    @Override
    @Nullable
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        Cliente cliente = new Cliente();

        cliente.setCodigo(rs.getInt("codigo"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setApellidos(rs.getString("apellidos"));
        cliente.setEmail(rs.getString("email"));
        cliente.setNumero(rs.getString("numero"));
        cliente.setVip(rs.getBoolean("vip"));

        return cliente;
    }
}
