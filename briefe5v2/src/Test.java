import java.util.List;

import daoCandidat.DaoCandidatImpl;
import entite.Candidat;

public class Test {

	public static void main(String[] args) {
		DaoCandidatImpl daocandidat = new DaoCandidatImpl();
		Candidat candidat2 = new Candidat(2,"Nawan","Benoit",
				 "benoit@yahoo.fr","yimporima, natitingou Benin","BENIN");
		
		//Affichage de tous les candidats inscrits
		System.out.println("\nListe de tous les candidats inscrits : ");
		List<Candidat> candidats = daocandidat.getAllCandidats();
		
		for (Candidat cdts : candidats) {
			System.out.println("\n"+cdts);
		}
		
		//Ajout d'une nouvelle inscription
		Candidat candidat4 = new Candidat(10,"Latifa","Anas",
				 "anas@yahoo.fr","Tassila, Agadir","Maroc");
		daocandidat.addCandidat(candidat4); 
		
		
		
		 Candidat candidat1 = new Candidat(6,"Nawan","Benoit",
		 "benoit@yahoo.fr","yimporima, natitingou Benin","BENIN");
		
		 Candidat candidat3 = new Candidat(9,"Latifa","Anas",
				 "anas@yahoo.fr","Tassila, Agadir","Maroc");
		 
			/*
			 * System.out.println( candidat3.getId()+" | " +candidat3.getNom() +
			 * " | "+candidat3.getPrenom() + " | "+candidat3.getEmail() +
			 * " | "+candidat3.getAdresse() + " | "+candidat3.getPays());
			 
		 daocandidat.addCandidat(candidat3); 
			 */
		
		//Mise a jour d'un candidat par Id
		daocandidat.updateCandidatById(9, candidat2);
		System.out.println("Mise a jour reussie");
		
		
		//Suppression d'un candidat par Id
		daocandidat.deleteCandidatById(7);
		System.out.println("Un candidat supprime ");
		
		
	}

	}

