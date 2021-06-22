package com.resort.resortapp;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.sql.*;
@Controller
public class myController{
  int num=0;
    @GetMapping("/getregister")
    public String getRegister(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }
    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user){
        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:userdb.db");
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
        //   statement.executeUpdate("CREATE DATABASE IF NOT EXISTS user;");

          statement.executeUpdate("create table IF NOT EXISTS users (id integer, phone string, members integer, visit string, exit string);");
          String query = " insert into users (phone, members, visit, exit,id)"
                         + " values (?, ?, ?, ?,?)";
          PreparedStatement stmt=connection.prepareStatement (query);  
          stmt.setString(1, user.getPhone());
          stmt.setInt(2, user.getMembers());
          stmt.setString(3, user.getVisit());
          stmt.setString(4, user.getExit());
          stmt.setInt(5, num+1); 
          

		}catch(SQLException e)
        {
          // if the error message is "out of memory",
          // it probably means no database file is found
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }
        System.out.print(user);
        return "registered";
    }
    @RequestMapping("/listuser")
    public String listUser(Model model){
        ArrayList<User> users = new ArrayList<User>();
        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:userdb.db");
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
          ResultSet rs = statement.executeQuery("select * from users;");
			while(rs.next())
			{
			// read the result set
			users.add(new User(rs.getInt("id"), rs.getString("phone"), rs.getInt("members"), rs.getString("visit"), rs.getString("exit")));
			System.out.println("id = " + rs.getInt("id"));
			System.out.println("phone = " + rs.getString("phone"));
      System.out.println("members = " + rs.getInt("members"));
      System.out.println("visit = " + rs.getString("visit"));
      System.out.println("exit = " + rs.getString("exit"));
            
			
			}
		}catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }
        model.addAttribute("users",users);
        return "users";
    }

}