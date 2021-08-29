package com.mx.utaz.Model.Gadgets;

import com.mx.utaz.Model.Address.BeanAddress;
import com.mx.utaz.Service.ConnectionMySQL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DaoREG {
Connection con;
CallableStatement cstm;
ResultSet rs;
Logger logger = LoggerFactory.getLogger(DaoREG.class);
int r;

    public int agregar(BeanGadgets beanGadgets){
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call aparato_registrar(?,?,?,?,?,?,?)}");


            cstm.setString(1,beanGadgets.getNombre());
            cstm.setString(2,beanGadgets.getFecharegistro());
            cstm.setString(3,beanGadgets.getdireccion_fabricante().getCalle());
            cstm.setString(4,beanGadgets.getdireccion_fabricante().getColonia());
            cstm.setInt(5,beanGadgets.getdireccion_fabricante().getcodigo_postal());
            cstm.setString(6,beanGadgets.getdireccion_fabricante().getEstado());
            cstm.setString(7,beanGadgets.getdireccion_fabricante().getPais());

            cstm.executeUpdate();
        }catch(SQLException e){
            logger.error("no se ha podido hacer la accion : " + e.getMessage());
        }finally {
            ConnectionMySQL.closeConnections(con,cstm);
        }
        return r;
    }


public List<BeanGadgets> Listar(){
    List<BeanGadgets> listGadgets = new ArrayList<>();

    try{
        con = ConnectionMySQL.getConnection();
        cstm = con.prepareCall("select *from electrodomesticos as e inner join direccion as d on e.direccion_fabricante = d.id_direccion");
        rs = cstm.executeQuery();

        while(rs.next()) {
            BeanGadgets beanGadgets = new BeanGadgets();
            BeanAddress beanAddress = new BeanAddress();

            beanGadgets.setId(rs.getInt("id"));
            beanGadgets.setNombre(rs.getString("nombre"));
            beanGadgets.setFecharegistro(rs.getString("fecha_registro"));
            beanGadgets.setestado(rs.getInt("estado"));

            beanAddress.setid_direccion(rs.getInt("id_direccion"));
            beanAddress.setCalle(rs.getString("calle"));
            beanAddress.setColonia(rs.getString("colonia"));
            beanAddress.setcodigo_postal(rs.getInt("codigo_postal"));
            beanAddress.setEstado(rs.getString("estado"));
            beanAddress.setPais(rs.getString("pais"));

            beanGadgets.setdireccion_fabricante(beanAddress);

            listGadgets.add(beanGadgets);
        }
    }catch(SQLException e){
        logger.error("no se ha podido hacer la accion : " + e.getMessage());
    }finally {
        ConnectionMySQL.closeConnections(con,cstm,rs);
    }
return listGadgets;
}


    public BeanGadgets ListarId(int id){
        BeanGadgets beanGadgets = null;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("select *from electrodomesticos as e inner join direccion as d on e.direccion_fabricante = d.id_direccion where e.direccion = ?");
            cstm.setInt(1,id);
            rs = cstm.executeQuery();

            if(rs.next()) {
                beanGadgets = new BeanGadgets();
                BeanAddress beanAddress = new BeanAddress();

                beanGadgets.setId(rs.getInt("id"));
                beanGadgets.setNombre(rs.getString("nombre"));
                beanGadgets.setFecharegistro(rs.getString("fecha_registro"));
                beanGadgets.setestado(rs.getInt("estado"));

                beanAddress.setid_direccion(rs.getInt("id_direccion"));
                beanAddress.setCalle(rs.getString("calle"));
                beanAddress.setColonia(rs.getString("colonia"));
                beanAddress.setcodigo_postal(rs.getInt("codigo_postal"));
                beanAddress.setEstado(rs.getString("estado"));
                beanAddress.setPais(rs.getString("pais"));

                beanGadgets.setdireccion_fabricante(beanAddress);
            }
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        }finally {
            ConnectionMySQL.closeConnections(con,cstm,rs);
        }
        return beanGadgets;
    }


    public int modificar(BeanGadgets beanGadgets){
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call aparato_actualizar(?,?,?,?,?,?,?,?)}");

            cstm.setInt(1,beanGadgets.getId());
            cstm.setString(2,beanGadgets.getNombre());
            cstm.setString(3,beanGadgets.getFecharegistro());
            cstm.setString(4,beanGadgets.getdireccion_fabricante().getCalle());
            cstm.setString(5,beanGadgets.getdireccion_fabricante().getColonia());
            cstm.setInt(6,beanGadgets.getdireccion_fabricante().getcodigo_postal());
            cstm.setString(7,beanGadgets.getdireccion_fabricante().getEstado());
            cstm.setString(8,beanGadgets.getdireccion_fabricante().getPais());

            cstm.executeUpdate();
        }catch(SQLException e){
            logger.error("no se ha podido hacer la accion : " + e.getMessage());
        }finally {
            ConnectionMySQL.closeConnections(con,cstm);
        }
        return r;
    }

    public void eliminar(int id){
    try{
        con = ConnectionMySQL.getConnection();
        cstm = con.prepareCall("{call aparato_eliminar(?)}");
        cstm.setInt(1,id);
        cstm.executeUpdate();
    }catch (SQLException e){
        logger.error("no se ha podido hacer la accion : " + e.getMessage());
    }finally {
        ConnectionMySQL.closeConnections(con,cstm);
    }
    }

}
