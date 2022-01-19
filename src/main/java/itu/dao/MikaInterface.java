package itu.dao;
import java.sql.Date;

import antlr.collections.List;
import itu.entities.Signalement;
import itu.entities.TypeSignalement;
import itu.entities.UserBackoffice;
import itu.entities.UtilisateurFO;
import itu.entities.UtilisateurMobile;

public interface MikaInterface {
public int connexion(String login , String mdp );
public void insertUserBackoffice(UserBackoffice u) ;
public List recherche(int type,Date date,int statut);
public void insertUtilisateurFO(UtilisateurFO user);
public void deleteUtilisateurMobile(UtilisateurMobile user);
public void inserTypeSignalement(TypeSignalement type);
public void updateTypeSignalement(TypeSignalement type);
public void deleteTypeSignalement(TypeSignalement type);
public void affecterSignalement(Signalement s);
public List listSignalement();
	
}
