/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinesLogic;

import dbAccess.DBAccess;
import model.Users;

/**
 *
 * @author Alexandru
 */
public class LoginController {
    private DBAccess dbAccess;

    public LoginController() {
        dbAccess = DBAccess.getInstance();
    }

    public int login(String username, String password) {
        int result = 0;
        Users resultedUser = null;
        Users user = new Users ();
        user.setUsername(username);
        user.setPassword(password);
        resultedUser = dbAccess.login (user);
        if ( resultedUser != null)
        {
            result = resultedUser.getType();
        }
        return result; 
    }

   
    
    
}
