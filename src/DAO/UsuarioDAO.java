package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import cadastro.usuario;
import factory.ConnectionFactory;

public class  UsuarioDAO{
	

	  public void incluir(usuario usuario){
	   String sql = ("INSERT INTO usuario(nome,email,password) VALUES(?,?,?)");
	   
	   Connection conn = null;
	   PreparedStatement pstm = null;
	   
	   try {
		   conn = ConnectionFactory.createConnecionToMySQL();
		   
		   pstm = conn.prepareStatement(sql);
		   
		   pstm.setString(1,usuario.getNome());
		   pstm.setString(2,usuario.getEmail());
		   pstm.setString(3,usuario.getPassword());
		   
		   
		   pstm.execute();
	   }catch (Exception e) {
		   e.printStackTrace();
	   }finally {
		   try {
			   if (pstm!=null) {
				   conn.close();
			   }
		   }catch (Exception e) {
				   e.printStackTrace();
			   }
		   }
	   }
	   
	   public void consulta(usuario usuario){
		   String sql = ("SELECT * FROM usuario where id = ?");
		   
		   Connection conn = null;
		   PreparedStatement pstm = null;
		   
		   try {
			   conn = ConnectionFactory.createConnecionToMySQL();
			   
			   pstm = conn.prepareStatement(sql);
			   
			   pstm.setLong(1,usuario.getId());
			   pstm.execute();
		   }catch (Exception e) {
			   e.printStackTrace();
		   }finally {
			   try {
				   if (pstm!=null) {
					   conn.close();
				   }
			   }catch (Exception e) {
					   e.printStackTrace();
				   }
			   }
		   }
		   
	   public void alterar(usuario usuario){
		   String sql = ("UPDATE usuario set nome = ?, password= ?,email = ? where id = ?");
		   
		   Connection conn = null;
		   PreparedStatement pstm = null;
		   
		   try {
			   conn = ConnectionFactory.createConnecionToMySQL();
			   
			   pstm = conn.prepareStatement(sql);
			   
			   
			   pstm.setLong(1,usuario.getId());
			   pstm.setString(2,usuario.getNome());
			   pstm.setString(3,usuario.getEmail());
			   pstm.setString(4,usuario.getPassword());
			   pstm.execute();
		   }catch (Exception e) {
			   e.printStackTrace();
		   }finally {
			   try {
				   if (pstm!=null) {
					   conn.close();
				   }
			   }catch (Exception e) {
					   e.printStackTrace();
				   }
			   }
	   }
	   
	   public void excluir(usuario usuario){
		   String sql = ("DELETE FROM usuario where id = ?");
		   
		   Connection conn = null;
		   PreparedStatement pstm = null;
		   
		   try {
			   conn = ConnectionFactory.createConnecionToMySQL();
			   
			   pstm = conn.prepareStatement(sql);
			   
			   pstm.setLong(1,usuario.getId());
			   pstm.execute();
		   }catch (Exception e) {
			   e.printStackTrace();
		   }finally {
			   try {
				   if (pstm!=null) {
					   conn.close();
				   }
			   }catch (Exception e) {
					   e.printStackTrace();
				   }
			   }
		   }
	   
	   
}