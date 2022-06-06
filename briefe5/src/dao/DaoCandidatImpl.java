package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import briefe5.Candidat;
import briefe5.SingletonConnexion;

public class CandidatDao implements DaoImpl{
	Connection conn = SingletonConnexion.getConnection();
	
	@Override
	public List<Candidat> getAllCandidats() {
		List<Candidat> candidats = new ArrayList<Candidat>();
		try {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM candidat");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData resultMeta = rs.getMetaData();
			 
		    while(rs.next()){
		    	Candidat cdt = new Candidat();
		    	System.out.println("- Il y a " + resultMeta.getColumnCount() + " colonnes dans cette table");
			      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
			        System.out.print(resultMeta.getColumnName(i)+" | \t"); 
			    cdt.setId(rs.getInt("idcandidat"));
			    cdt.setNom(rs.getString("nom"));
			    cdt.setPrenom(rs.getString("prenom"));
			    cdt.setEmail(rs.getString("email"));
			    cdt.setAdresse(rs.getString("adresse"));
			    cdt.setPays(rs.getString("pays"));
			    candidats.add(cdt);
		      }

		    rs.close();
	
	}
	catch(Exception e){
		e.getStackTrace();
	}
		return candidats;
		
	}
	@Override
	public void addCandidat(Candidat c) {
	
		try {
			String sql = "INSERT INTO candidat "
					+ "(idcategorie,nom,prenom,email,adresse,pays) "
					+ "VALUES(4,'PAATCHA','PAATCHA','PAATCHA','PAATCHA','PAATCHA','PAATCHA')";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getNom());
			ps.setString(3, c.getPrenom());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getAdresse());
			ps.setString(6, c.getPays());
			System.out.println("avant ext");
			ps.executeUpdate();
			System.out.println("apres ext");
			ps.close();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		System.out.println(c.getPrenom()+ " "+c.getNom()+ " vient de s'inscrire!");
	}
	@Override
	public void updateCandidatById(int id) {
			/*Candidat cdt = null;
			try {
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM candidat WHERE idcategorie = ?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if( rs.next()) {
					cdt = new Candidat();
					cdt.setId(rs.getInt("idcategorie"));
					cdt.setNom(rs.getString("idcategorie"));
					cdt.setPrenom(rs.getString("idcategorie"));
					cdt.setEmail(rs.getString("idcategorie"));
					cdt.setAdresse(rs.getString("idcategorie"));
					cdt.setPays(rs.getString("idcategorie"));
					System.out.println(cdt.getNom());
				}
				else {
					System.out.println("Oups!");
				}
		}
			catch(Exception e) {
				e.getStackTrace();
			}*/
		
	}
	@Override
	public void deleteCandidatById(int id) {
		// TODO Auto-generated method stub
		
	}
}

