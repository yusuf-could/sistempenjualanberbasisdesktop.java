/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan;

/**
 *
 * @author yusuf
 */
public class UserSession {
 private static String userLogin;

    public static void setUserLogin(String userLogin) {
        UserSession.userLogin = userLogin;
    }
    
    
    
    
    
    
    public static String getUserLogin() {
        return userLogin;
    }   
}
