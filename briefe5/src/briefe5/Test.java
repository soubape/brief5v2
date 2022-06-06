package briefe5;

import java.util.List;

import dao.CandidatDao;

public class Test {

	public static void main(String[] args) {
		CandidatDao candidatdao = new CandidatDao();
		
		//Affichage de tous les candidats inscrits
		System.out.println("\nListe de tous les candidats inscrits : ");
		List<Candidat> candidats = candidatdao.getAllCandidats();
		for (Candidat cdts : candidats) {
			System.out.println("\n"+cdts.toString());
		}
		
		//Ajout d'une nouvelle inscription
		Candidat candidat1 = new Candidat(4,"PAATCHA","Sebastien","paatcha@yahoo.fr","yimporima, natitingou Benin","BENIN");
		candidatdao.addCandidat(candidat1);
		System.out.println(
						candidat1.getId()+" | "
						+candidat1.getNom()
						+ " | "+candidat1.getPrenom()
						+ " | "+candidat1.getEmail()
						+ " | "+candidat1.getAdresse()
						+ " | "+candidat1.getPays());
		
		/*recherche d'un candidat par Id
		CandidatDao cdt = null ;
		cdt.updateCandidatById(1);
		System.out.println("Le candidat trouve est  : "+cdt);
		*/
}
}
