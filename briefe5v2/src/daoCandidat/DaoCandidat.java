package daoCandidat;

import java.util.List;

import entite.Candidat;

public interface DaoCandidat {
	public List<Candidat> getAllCandidats();
	public void addCandidat(Candidat c);
	public void updateCandidatById(
			int id,Candidat cdt);
	public void deleteCandidatById(int id);
	public int nombreligne();

}
