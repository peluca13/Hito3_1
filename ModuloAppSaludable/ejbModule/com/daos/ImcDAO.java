package com.daos;

import java.sql.SQLException;

import com.entidades.Imc;
import com.entidades.Usuario;

import java.util.Date;
import java.util.LinkedList;
import java.text.SimpleDateFormat;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class ImcDAO {

	@PersistenceContext
	private EntityManager em;
	
	//Validar existe imc fecha
	public Imc findId(Long idUsuario, Date fecha) throws SQLException{
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
		DATE_FORMAT.format(fecha);
		Imc imc = null;
		return imc = (Imc) em.createQuery("SELECT i FROM IMC i WHERE i.ID_USUARIO LIKE :idUsuario AND i.FECHA LIKE :fecha")
				.setParameter("idUsuario", idUsuario)
				.setParameter("fecha", new java.sql.Date(fecha.getTime()))
				.getResultList();
		}
		
	//Insertar IMC pasado por parámetro.
	public Long insert(Imc imc) throws SQLException {
		this.em.persist(imc);
		this.em.flush();
		return imc.getIdImc();
	}
	
	//Actualizar IMC pasado por parámetro.
	public void edit(Imc imc) throws SQLException{
		this.em.merge(imc);
		this.em.flush();
	}
	
	//Eliminar IMC pasado por parámetro.
	public void delete(Long idImc) throws SQLException{
		Imc imc = em.find(Imc.class, idImc);
		em.remove(imc);
		em.flush();
	}
	
	//Obtener todos los IMC.
	public LinkedList<Imc> findAll() throws SQLException{
		TypedQuery<Imc> query = this.em.createQuery("SELECT i FROM IMC i",Imc.class);
			return (LinkedList<Imc>) query.getResultList();
	}
		
	//Obtener un IMC por ID.
	public Imc find(Long idImc) throws SQLException{
		return this.em.find(Imc.class,idImc);
	}	
	
}