/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import UserDetails.UserInfo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Foxy
 */
public class DataBaseConnection {
    
    public ArrayList<UserInfo> UserRetrevialInfo = new ArrayList<>();
    public String retrievedName=null,retrievedEmailID=null,retrievedPhoneNumber=null;
    static int i=0;
    static boolean j = true;
    static Connection connection=null;
    static PreparedStatement preparedStatement =null;
    static ResultSet resultSet = null;
    static boolean value = false;
    public static final String CREATE_TABLE = "create table UserInformation(Name character varying(40) NOT NULL , EMAILID character varying(40) NOT NULL, PhoneNumber character varying(40) NOT NULL)";
    public static final String SELECT_TABLE = "select * from UserInformation";
    public static final String UPDATE_TABLE = "Insert into UserInformation values(?,?,?)";
    public static final String DELETE_TABLE = "delete from UserInformation where Name =? and PhoneNumber=?";
    public static final String DROP_TABLE = "drop table UserInformation";
    
    public void closeConnection()
    {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getConnection()
    {
        try {
            Class.forName("org.postgresql.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/UserData", "postgres","Nitinz!424");
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void createTable()
     {
        try {
            preparedStatement = connection.prepareStatement(CREATE_TABLE);
            value = preparedStatement.execute();
             preparedStatement.close();
             
        } catch (SQLException ex) {
         System.out.print("");
        }
       
     }
        
     public boolean tableCreationCheck()
     {
        try {
            value = preparedStatement.execute("SELECT_TABLE");
            preparedStatement.close();
        }  catch(NullPointerException npr)
            {
                System.out.print("");
            } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return value;
         
     }
     
     public void InsertUserInfoValues(ArrayList<UserInfo> userInfoIterator)
     {
        try {
            for(i=0;i<userInfoIterator.size();i++)
            {
         preparedStatement = connection.prepareStatement(UPDATE_TABLE);
         preparedStatement.setString(1, userInfoIterator.get(i).getName());
         preparedStatement.setString(2, userInfoIterator.get(i).getEmailId());
         preparedStatement.setString(3, userInfoIterator.get(i).getPhoneNumber());
         j = preparedStatement.execute();
         preparedStatement.close();
            } 
            if(j == false)
            {
        System.out.println("-----------------------------------------");
        System.out.println("Your information has been updated to the database successfully!");
        System.out.println("-----------------------------------------");
            }
            else
            {
                System.err.println("Something went wrong please try again!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
        public ArrayList<UserInfo> RetrieveUserInformationValues()
        {
        try {
            preparedStatement = connection.prepareStatement(SELECT_TABLE);
            resultSet = preparedStatement.executeQuery();
            System.out.println("Name"+ "\t"+"EmailID"+"\t"+"Phone Number");
            while((resultSet.next()))
            {
             UserInfo info = new UserInfo();   
            retrievedName = resultSet.getString(1);
            retrievedEmailID = resultSet.getString(2);
            retrievedPhoneNumber = resultSet.getString(3);
            info.setName(retrievedName);
            info.setEmailId(retrievedEmailID);
            info.setPhoneNumber(retrievedPhoneNumber);
            UserRetrevialInfo.add(info);
            System.out.println(retrievedName+ "\t" + retrievedEmailID+"\t"+retrievedPhoneNumber);
           
            }
            resultSet.close();
            preparedStatement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
           return UserRetrevialInfo;
     
        } 
    
}
