package dao;

import java.sql.SQLException;
import java.util.List;

import briefe5.Candidat;

public interface DaoImpl {
	
	public List<Candidat> getAllCandidats();
	public void addCandidat(Candidat c);
	public void updateCandidatById(int id);
	public void deleteCandidatById(int id);
}
