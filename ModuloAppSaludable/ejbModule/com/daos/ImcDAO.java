package com.daos;

import java.sql.SQLException;

import com.entidades.Imc;
import com.entidades.Usuario;

import java.util.ArrayList;
import java.util.Calendar;
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
	public ArrayList<Imc> findId(Usuario idUsuario, Date fecha) throws SQLException{		
		TypedQuery<Imc> query = this.em.createQuery("SELECT i FROM Imc i WHERE i.idUsuario LIKE :user AND i.fecha LIKE :date",Imc.class)
					.setParameter("user", idUsuario)
					.setParameter("date", fecha);
					return (ArrayList<Imc>) query.getResultList();
		
		}
		
	//Insertar IMC pasado por parámetro.
	public void insert(Imc imc) throws SQLException {
		this.em.persist(imc);
		this.em.flush();
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
		TypedQuery<Imc> query = this.em.createQuery("SELECT i FROM Imc i",Imc.class);
			return (LinkedList<Imc>) query.getResultList();
	}
		
	//Obtener un IMC por ID.
	public Imc find(Long idImc) throws SQLException{
		return this.em.find(Imc.class,idImc);
	}	
	
}