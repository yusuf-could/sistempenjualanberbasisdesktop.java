/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yusuf
 */
public class FungsiQuery {
     public FungsiQuery()
    {        
    }
    
    String sql="";
    int i;
    
public void InputDetail(String[] kolom, String[] isi, String nmTabel) 
        throws SQLException
{
    try
    {
        sql="INSERT INTO "+nmTabel+" (" ;
           for(i=0; i<kolom.length; i++)
           {
               sql += kolom[i];
               if(i<kolom.length-1)
               {
                   sql += ",";
               }
           }
           
           sql +=") values (";
           for(i=0; i<kolom.length; i++)
           {
               sql += "'" + isi[i] + "'";
               if(i<kolom.length-1)
               {
                   sql += ",";
               }
           }
           sql += ")";
           
           //Proses masuk ke database
            koneksi knks = new koneksi();
            Connection con = DriverManager.getConnection
                ("jdbc:mysql://localhost/db_inventory", "root", "");
            Statement st = con.createStatement();
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            con.close();
    }
    catch (Exception e)
    {
        System.out.println(e.getMessage());
    }   
}
    public void Edit(String[] kolom, String[] isi, 
            String nmTabel, String PrimaryKey, String data)
    {
        try
        {
            sql="UPDATE "+ nmTabel +" SET ";
            for(i=0; i<kolom.length; i++)
            {
                sql += kolom[i] + " = '" + isi[i] + "'";
                if(i<kolom.length-1)
                {
                    sql += ",";
                }
            }
            sql+=" WHERE "+ PrimaryKey + "='" + data + "'";
            
            //Proses Edit ke database
            koneksi knks =new koneksi();
            Connection con =DriverManager.getConnection
                ("jdbc:mysql://localhost/db_inventory","root","");
            Statement st=con.createStatement();
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            con.close();                    
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void Hapus(String nmTabel, String PrimaryKey, String data)
    {
       try
        {
            sql="DELETE FROM " + nmTabel +
                    " WHERE " + PrimaryKey +
                    " = '"+ data +"'";
            
            //Proses hapus ke database
            koneksi knks = new koneksi();
            Connection con = DriverManager.getConnection
                ("jdbc:mysql://localhost/db_inventory","root","");
            Statement st=con.createStatement();
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            con.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        } 
    }            

} //end class
    

