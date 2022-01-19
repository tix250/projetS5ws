package itu.test;

import itu.dao.MikaInterface;
import itu.entities.UserBackoffice;

public class Test {

	public static void main(String[] args) {
		
      MikaInterface mk = null;
      UserBackoffice u = new UserBackoffice();
      
      u.setLogin("tix");
      u.setMdp("123");
      
      mk.connexion("tix", "123");
      
	}

}
