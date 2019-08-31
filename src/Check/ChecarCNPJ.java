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
public class ChecarCNPJ {
    
    public static boolean checkCnpj(String cnpj)
    {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `fornecedor` WHERE `cnpj` =?";
        
        try {
            ps = ConnectionFactory.getConnection().prepareStatement(query);
            ps.setString(1, cnpj);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                checkUser = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar CNPJ" + ex);
        }
         return checkUser;
    }
    
}
