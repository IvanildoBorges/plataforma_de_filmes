package br.com.platform.movies.model.dao;

import br.com.platform.movies.model.Administrator;
import br.com.platform.movies.model.Client;
import br.com.platform.movies.model.Person;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elieudo Maia
 * @author Ivanildo Borges
 */
public class PersonDAO extends InsertableOnDatabase{
  public List<Person> listAll() {
    PreparedStatement pstmt = null;
    List peopleList = new ArrayList<>();
    
    try {
      pstmt = this.getConnection().prepareStatement("select * from people;");
      
      ResultSet result = pstmt.executeQuery();
      
      while(result.next()) {
        Person person;
        
        boolean isAdmin = result.getBoolean(7);
        
        if (isAdmin) {
          person= new Administrator();
        } else {
          person = new Client();
        }
        
        person.setId(result.getInt(1));
        person.setName(result.getString(2));
        person.setEmail(result.getString(3));
        person.setTelephone(result.getString(5));
        person.setAddress(result.getString(6));
        person.setBirthDate(result.getDate(8));
        
        peopleList.add(person);
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
//      this.close(pstmt);
//      this.closeConnection(this.getConnection());
    }
    
    return peopleList;
  }
  
  public Person getById(int id) throws Exception {
    PreparedStatement pstmt = null;
    Person person;

    try {
      pstmt = this.getConnection().prepareStatement("select * from people where id = ?;");
      pstmt.setInt(1, id);
      
      ResultSet result = pstmt.executeQuery();
      
      result.next();
      
      
      if (result.getBoolean(7)) {
        person = new Administrator();
      } else {
        person = new Client();
      }
      
      person.setId(result.getInt(1));
      person.setName(result.getString(2));
      person.setEmail(result.getString(3));
      person.setTelephone(result.getString(5));
      person.setAddress(result.getString(6));
      person.setBirthDate(result.getDate(8));
      
    } catch (SQLException e) {
      this.close(pstmt);
      this.closeConnection(this.getConnection());
      throw new Exception("Filme não encontrado");
    }
    
    return person;
  }
  
  public int createPerson(Person person, boolean isAdmin) throws Exception {
    PreparedStatement pstmt = null;
    int ret = 0;
    try {
      pstmt = this.getConnection().prepareStatement("insert into people (name, email, password, telephone, address, is_admin, birth_date) values(?,?,?,?,?,?,?);");
      pstmt.setString(1, person.getName());
      pstmt.setString(2, person.getEmail());
      pstmt.setString(3, person.getPassword());
      pstmt.setString(4, person.getTelephone());
      pstmt.setString(5, person.getAddress());
      pstmt.setBoolean(6, isAdmin);
      pstmt.setDate(7, person.getBirthDate());
      
      ret = pstmt.executeUpdate();
    } catch (SQLException e) {
      throw new Exception("Ocorreu um erro ao cadastrar este usuário");
    } finally {
      this.close(pstmt);
      this.closeConnection(this.getConnection());
    }
    
    return ret;
  }
  
  public boolean deletePerson(int personId) throws Exception {
    PreparedStatement pstmt = null;
    
    pstmt = this.getConnection().prepareStatement("delete from people where id=?;");
    pstmt.setInt(1, personId);

    pstmt.executeQuery();

    return true;
  }
  
  public int updatePerson(Person person) {
    PreparedStatement pstmt = null;
    int ret = 0;
    boolean isAdmin = false;
    
    if (person instanceof Administrator) isAdmin = true; 
    
    try {
      pstmt = this.getConnection().prepareStatement("update people set name=?, email=?, password=?, telephone=?, address=?, is_admin=?, birth_date=? where id = ?;");
      pstmt.setString(1, person.getName());
      pstmt.setString(2, person.getEmail());
      pstmt.setString(3, person.getPassword());
      pstmt.setString(4, person.getTelephone());
      pstmt.setString(5, person.getAddress());
      pstmt.setBoolean(6, isAdmin);
      pstmt.setDate(7, person.getBirthDate());
      pstmt.setInt(8, person.getId());

      ret = pstmt.executeUpdate();
    } catch (SQLException e) {
      String errorMessage = "Erro ao atualizar cadastro de usuário";
      System.out.println(errorMessage + e.getMessage());
    } finally {
      // this.close(pstmt);
      //this.closeConnection(this.getConnection());
    }
    
    return ret;
  }
  
  public Person login(String user, String password) throws Exception {
    PreparedStatement pstmt = null;
    
    try {
      pstmt = this.getConnection().prepareStatement("select * from people where email = ? and password = ?;");
      
      pstmt.setString(1, user);
      pstmt.setString(2, password);
      
      ResultSet rs = pstmt.executeQuery();
      
      if (!rs.next()) {
        throw new Exception("Email ou senha incorreto(s)");
      }
      
      Person person;
      boolean isAdmin = rs.getBoolean(7);
      if (isAdmin) {
        person = new Administrator();
      } else {
        person = new Client();
      }
      
      person.setId(rs.getInt(1));
      person.setName(rs.getString(2));
      person.setEmail(rs.getString(3));
      person.setTelephone(rs.getString(5));
      person.setAddress(rs.getString(6));
      person.setBirthDate(rs.getDate(8));
      
      return person;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new Exception(e.getMessage());
    }
  }
  
  public boolean checkIsAdmin(int personId) throws Exception {
    PreparedStatement pstmt = null;
    
    try {
      pstmt = this.getConnection().prepareStatement("select is_admin from people where id = ?;");
      pstmt.setInt(1, personId);
      
      ResultSet rs = pstmt.executeQuery();
      
      if (!rs.next()) {
        throw new Exception("Usuário não encontrado");
      }
      
      boolean isAdmin = rs.getBoolean(1);
      
      return isAdmin;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new Exception(e.getMessage());
    }
  }
  
  public void close (Statement stmt) {
    if (stmt != null)
      try {
        stmt.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
  
  private void closeConnection(Connection connection) {
    try {
      connection.close();
    } catch (Exception e) {
      System.err.println("Erro when trying close database connection");
    }
  }
}