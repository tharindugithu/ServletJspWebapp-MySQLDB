package com.tharindu.web.dao;

import java.sql.*;

import com.tharindu.web.model.Person;

public class PersonDao {
   public Person getPerson(int pid) throws ClassNotFoundException, SQLException {
	   Person p = new Person();
	  
	   
	   String url ="jdbc:mysql://localhost:3306/persons";
	   String uname = "root";
	   String pword ="1234";
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection con = DriverManager.getConnection(url,uname,pword);
	   Statement st = con.createStatement();
	   ResultSet rs =  st.executeQuery("SELECT * FROM persondata WHERE person_id="+pid);
	   if(rs.next()) {
		   p.setPid(rs.getInt("person_id"));
		   p.setPname(rs.getString("person_name"));
	   }
	   return p;
   }
}
