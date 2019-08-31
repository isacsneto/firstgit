/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Check;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author isac_
 */
public class ChecarFunc {
    public static boolean checkFunc(String func, String cpf)
    {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkFunc = false;
        String query = "SELECT * FROM `funcionario` WHERE `funcao` =? AND `cpf` =?";
        
        try {
            ps = ConnectionFactory.getConnection().prepareStatement(query);
            
            ps.setString(1, func);
            ps.setString(2, cpf);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                checkFunc = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao checar função." + ex);
        }
         return checkFunc;
    }
    
}
