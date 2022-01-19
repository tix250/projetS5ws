package itu.dao;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import antlr.collections.List;
import itu.entities.Signalement;
import itu.entities.TypeSignalement;
import itu.entities.UserBackoffice;
import itu.entities.UtilisateurFO;
import itu.entities.UtilisateurMobile;

@Repository
@Transactional

public class MikaImpl implements MikaInterface{
	@PersistenceContext
	private EntityManager em;
	@Override
	public int connexion(String login  , String mdp) {
			
		int retour=0;
		UserBackoffice ub = new UserBackoffice();
		try {
			
			Query  req = em.createQuery("from UserBackoffice where login=:login and mdp =:mdp");
			req.setParameter("login", login);
			req.setParameter("mdp", mdp);
			ub = (UserBackoffice) req.getSingleResult();
			}
			catch (Exception e ) 
			{
				if (ub == null) 
				{
				throw new RuntimeException("compte introuvable");
				}
			}
			
			return ub.getIdBackoffice();
		}
	@Override
	public void insertUserBackoffice(UserBackoffice u) {
		em.persist(u);
	}
	@Override
	public List recherche(int type, Date date, int statut) {
		ArrayList<Signalement> signalement = new ArrayList<>();
		
		try {
			
			Query req = em.createQuery("select s from Signalement s where s.idTypesignalement=:type and s.date=:date and s.statut=:statut" )  ;
			req.setParameter("type",type);
			req.setParameter("date",date);
			req.setParameter("statut",statut);
			signalement = (ArrayList<Signalement>) req.getResultList();
			
			if (signalement== null) throw new RuntimeException("Tsy nisy signalement");
			
		}catch (Exception e ) {
			e.printStackTrace();		
		}
		
		return (List) signalement;
	}
	@Override
	public void insertUtilisateurFO(UtilisateurFO user) {
		em.persist(user);		
	}
	@Override
	public void deleteUtilisateurMobile(UtilisateurMobile user) {
		try {	
			Query req = em.createQuery("delete from UtilisateurMobile m where m.id_user=:iduser" )  ;
			req.setParameter("iduser",user.getId_user());
			req.executeUpdate();
			
		}catch (Exception e ) {
			e.printStackTrace();		
		}
		
	}
	@Override
	public void inserTypeSignalement(TypeSignalement type) {
		em.persist(type);
		
	}
	@Override
	public void updateTypeSignalement(TypeSignalement type) {
			try {
			
			Query req = em.createQuery("update TypeSignalement t set t.type_signalement=:type where t.id_type_signalement=:id" )  ;
			req.setParameter("type",type.getTypesignalement());
			req.setParameter("id",type.getIdTypesignalement());
			req.executeUpdate();
			
		}catch (Exception e ) {
			e.printStackTrace();		
		}
		
	}
	@Override
	public void deleteTypeSignalement(TypeSignalement type) {
		try {
			
			Query req = em.createQuery("delete from TypeSignalement t where t.id_type_signalement=:id" )  ;
			req.setParameter("id",type.getIdTypesignalement());
			req.executeUpdate();
			
		}catch (Exception e ) {
			e.printStackTrace();		
		}
		
	}
	@Override
	public void affecterSignalement(Signalement s) {
		try {
			
			Query req = em.createQuery("update Signalement s set s.statut=2 where s.id_signalement=:id" )  ;
			req.setParameter("id",s.getId_signalement());
			req.executeUpdate();
			
		}catch (Exception e ) {
			e.printStackTrace();		
		}
		
	}
	@Override
	public List listSignalement() {
		ArrayList<Signalement> resultat = new ArrayList<>();
		try {
			
			Query req = em.createQuery("select s from Signalement s " )  ;
			resultat = (ArrayList<Signalement>) req.getResultList();
			
			if (resultat== null) throw new RuntimeException("Tsy misy signalement");
			
		}catch (Exception e ) {
			e.printStackTrace();		
		}
		
		return (List) resultat;
	}

}
