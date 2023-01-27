/*
package com.jaimecorg.springprojects.tienda.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.jaimecorg.springprojects.tienda.dao.DetallePedidosDAO;
import com.jaimecorg.springprojects.tienda.model.DetallePedido;
import com.jaimecorg.springprojects.tienda.model.Pedido;
import com.jaimecorg.springprojects.tienda.model.Producto;

@Repository
public class DetallePedidosDAOImpl extends JdbcDaoSupport implements DetallePedidosDAO{


    @Autowired
    DataSource dataSource;
    
    @PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

   

   
    @Override
    public void insert(Pedido pedido, DetallePedido detallePedido) {
        String query = "insert into Detalle_Pedido (cantidad," + 
                                            " precio," + 
                                            " total," + 
                                            " codigo_pedido," + 
                                            " codigo_producto)" + 
                                            " values (?, ?, ?, ?, ?)";
        Object[] params = {
            detallePedido.getCantidad(),
            detallePedido.getProducto().getPrecio(),
            detallePedido.getProducto().getPrecio()*detallePedido.getCantidad(),
            pedido.getCodigo(),
            detallePedido.getProducto().getCodigo()
        };

        final int[] types = {
            Types.INTEGER,
            Types.DECIMAL,
            Types.DECIMAL,
            Types.INTEGER,
            Types.INTEGER
        };
        
        int update = getJdbcTemplate().update(query, params, types);        
    }




    @Override
    public List<DetallePedido> findDetalle(Pedido pedido) {

    
            String query = "SELECT dp.*, p.nombre nombre_producto, p.precio precio FROM Detalle_Pedido dp, Productos p" + 
            " where dp.codigo_producto = p.codigo and codigo_pedido = ?";
    


        Object params [] = {pedido.getCodigo()};
        int types [] = {Types.INTEGER};


            final List<DetallePedido> detalles = getJdbcTemplate().query(query, params, types,new RowMapper<DetallePedido>() {
    
                @Override
                @Nullable
                public DetallePedido mapRow(ResultSet rs, int rowNum) throws SQLException {
                    DetallePedido detalle = new DetallePedido();
                    detalle.setCodigo(rs.getInt("codigo"));
                    detalle.setCantidad(rs.getInt("cantidad"));
                    detalle.setSubTotal(rs.getDouble("total"));
                    Producto producto = new Producto();
                    producto.setCodigo(rs.getInt("codigo_producto"));
                    producto.setNombre(rs.getString("nombre_producto"));
                    producto.setPrecio(rs.getDouble("precio"));
                    detalle.setProducto(producto);
                    return detalle;
                }
            });
    
            return detalles;
    }
}
*/