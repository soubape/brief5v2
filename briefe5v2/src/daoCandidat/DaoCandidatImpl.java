package daoCandidat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import entite.Candidat;

public class DaoCandidatImpl implements DaoCandidat {

	Connection conn = Connexion.createConnection();
	//Connection conn = null;
	@Override
	public List<Candidat> getAllCandidats() {
		List<Candidat> candidats = new ArrayList<Candidat>();
		try {
			
			Connection conn = Connexion.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM candidat");
			ResultSet rs =ps.executeQuery();
			ResultSetMetaData resultMeta = rs.getMetaData();
			System.out.println("- Il y a " + resultMeta.getColumnCount() + 
					" colonnes "+ "et "+nombreligne()+ " lignes dans la table");
			while(rs.next()){
		    	Candidat cdt = new Candidat();
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
			conn = Connexion.getConnection();
			String sql = "INSERT INTO candidat "
					+ "(idcandidat,nom,prenom,email,adresse,pays) "
					+ "VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getNom());
			ps.setString(3, c.getPrenom());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getAdresse());
			ps.setString(6, c.getPays());
			ps.executeUpdate();

			ps.close();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		System.out.println(c.getPrenom()+ " "+c.getNom()+ " vient de s'inscrire !");
		
	}

	@Override
	public void updateCandidatById(int id,Candidat cdt) {
		
		try {
			conn = Connexion.getConnection();
			String sql = "UPDATE candidat SET "
					+"idcandidat=?,nom=?,prenom=?,email=?,adresse=?,pays=?"
					+ " WHERE idcandidat = "+id;
			//System.out.println("ID = "+id);
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,cdt.getId());
			ps.setString(2,cdt.getNom());
			ps.setString(3,cdt.getPrenom());
			ps.setString(4,cdt.getEmail());
			ps.setString(5,cdt.getAdresse());
			ps.setString(6,cdt.getPays());
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i==1) {
				System.out.println("Mise a jour du candidat ayant l'id "+id +" effectuee");
			}
			else {
				System.out.println("Mise a jour echouee");
			}
			ps.close();
	}
		catch(Exception e) {
			e.getStackTrace();
		}
	
		
	}

	@Override
	public void deleteCandidatById(int id) {
		conn = Connexion.getConnection();
		try {
		String sql = "DELETE from candidat WHERE idcandidat = "+id;
		PreparedStatement stmt = conn.prepareStatement(sql);
		int i = stmt.executeUpdate();
		if(i==1)
		System.out.println("Le candidat ayant l'id"+id+" a ete supprime avec succès...");
//	      //étape 5: fermez l'objet de connexion
		else System.out.println("oups!");
		conn.close();
	    }
		
	    catch(Exception e){ 
	      System.out.println(e);
	    }
	}

	@Override
	public int nombreligne(){
		int nombreligne = 0;
		try {
			conn = Connexion.getConnection();
			String sql = "select count(*) from candidat";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			nombreligne = rs.getInt(1) ;
			//System.out.println("wertyuio"+nombreligne);
			/*if(ps.execute()==true)
				System.out.println("Nombre de ligne : "+nombreligne);
			else 
				System.out.println("Oups, une erreur s'est produite !");
			*/
			conn.close();
		}
		
		catch(Exception e) {
			e.getStackTrace();
		}
		
		return nombreligne;
		
	}
	

}
