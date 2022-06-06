package brief5v1;

import java.util.List;

public interface DaoCandidat {
	Connexion connexion = new Connexion();
	public List<Candidat> getAllCandidats();
	public void addCandidat(Candidat c);
	public void updateCandidatById(
			int id,Candidat cdt);
	public void deleteCandidatById(int id);
	public int nombreligne();
}
