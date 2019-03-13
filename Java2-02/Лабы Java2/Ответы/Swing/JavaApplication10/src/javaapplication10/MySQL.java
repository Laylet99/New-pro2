package javaapplication10;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

//  Create Table dbo.pictures(
//	id    int   NOT NULL,
//	photo image NOT NULL,
//	name  nvarchar(50) NULL,
//  Constraint PK_pictures primary key clustered (id ASC) )

public class MySQL {
    static String url;
    static{
         url="jdbc:sqlserver://localhost;database=AdventureWorks";
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         }catch(ClassNotFoundException ex) { 
             System.err.println(ex.getMessage()); }
    }
    public static void putPhoto(String name, String path){
       try(Connection con=DriverManager.getConnection(url,"sa","1234")){
           
         File file=new File(path); 
         if (!file.exists()) return;
         int  size=(int)file.length();
         
         BufferedInputStream fis=new BufferedInputStream(
                                new FileInputStream(file));
         
         String sql="Insert into dbo.pictures (name,photo) Values(?,?)";
         PreparedStatement pst=con.prepareStatement(sql);
         pst.setString(1, name);
         pst.setBinaryStream(2, fis, size);
         pst.executeUpdate();
       }
       catch(SQLException | IOException ex) { 
           System.err.println(ex.getMessage()); } 
    }
    public static String[] getPhotos() {
        ArrayList<String> list=null;
        
        try(Connection con=DriverManager.
                        getConnection(url,"sa","1234")){
    
            String sql="Select id,name from dbo.pictures";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            list=new ArrayList<>();
            while(rs.next())
               list.add(rs.getString(1)+" "+rs.getString(2));
        }
        catch(SQLException ex) { System.err.println(ex.getMessage()); }
        
        return list.toArray(new String[]{});
    }
    public static InputStream getPhoto(int id){
        InputStream in=null;
        
        try(Connection con=DriverManager.
                        getConnection(url,"sa","1234")){
    
            String sql="Select photo from dbo.Pictures where id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs=pst.executeQuery();
            rs.next();
            in=rs.getBinaryStream(1); 
        }
        catch(SQLException ex) { System.err.println(ex.getMessage()); } 
        
        return in; 
    }
}
