package com.proyectorat.manager;

import com.proyectorat.model.Tipo;
import com.proyectorat.persistence.Dao_Tipo;
import com.proyectorat.util.Conexion;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author RAT
 */
public class TipoManagerImpl {

    Connection c;
    Dao_Tipo dao;

    public TipoManagerImpl() {
        dao = new Dao_Tipo();
    }

    public Tipo getTipo(String idactividad) {

        c = new Conexion().getCon();
        return dao.getTipoA(c, Integer.parseInt(idactividad));
    }

    public ArrayList<Tipo> getListado() {

        c = new Conexion().getCon();
        return dao.getListadoTipos(c);
    }

    public void getGuardarTipo(Tipo u) throws Exception {
        String ida;
        String mensaje, act, des, est;
        ida = u.getId_actividad();
        act = u.getActividad();
        des = u.getDescripcion();
        est = u.getEstado();
        
        mensaje = "";

        //Campos obligatorios
        if ("".equals(act) || null == act) {
            mensaje += "Ingrese usuario";
        }

        //Campos no obligatorios
        
        if ("".equals(des) || null == des) {
            mensaje += "Ingrese nombre";
        }
        
        if ("".equals(est) || null == est) {
            mensaje += "Ingrese clave";
        }
        
        
        //Excepciones
        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
        
        c= new Conexion().getCon();
        
        mensaje = dao.getGuardarTipo(c, Integer.parseInt(ida), act, des, est);
    }
    
    public void getEditarTipo(Tipo u) throws Exception {
        String ida;
        String mensaje, act, des, est;
        ida = u.getId_actividad();
        act = u.getActividad();
        des = u.getDescripcion();
        est = u.getEstado();
        mensaje = "";

        //Campos obligatorios
        if ("".equals(act) || null == act) {
            mensaje += "Ingrese usuario";
        }

        //Campos no obligatorios
        if ("".equals(est) || null == est) {
            est = "Activo";
        }
        
        if ("".equals(des) || null == des) {
            mensaje += "Ingrese nombre";
        }
        
        //Excepciones
        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
        
        c= new Conexion().getCon();
        
        mensaje = dao.getEditarTipo(c, Integer.parseInt(ida), act, des, est);
    }
    
    public Tipo getEliminarTipo(String idactividad) {

        c = new Conexion().getCon();
        return dao.getEliminarTipo(c, Integer.parseInt(idactividad));
    }
}
