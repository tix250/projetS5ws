package itu.dao;

import itu.entities.Region;
import itu.entities.Signalement;
import itu.entities.Statistique;

public interface TixInterface {
	public Statistique  genererstatistique();
	public Signalement affecterSignialement (Signalement s , Region r);
}
