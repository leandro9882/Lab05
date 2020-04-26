package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {
	

public boolean isCorrect(String anagramma) {
	boolean esito=false;
	final String sql = "SELECT d.nome FROM parola d WHERE d.nome=?;";
	try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, anagramma);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			esito = true;
		}
		conn.close();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	return esito;
}

}
