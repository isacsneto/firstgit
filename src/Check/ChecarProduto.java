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
public class ChecarProduto {
    
    public static boolean checkp(int a, int b) {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT codproduto FROM `vendasprodutos` WHERE `codvenda` = ? AND `codproduto` = ?";
        
        try {
            ps = ConnectionFactory.getConnection().prepareStatement(query);
            ps.setInt(1, a);
            ps.setInt(2, b);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                checkUser = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar produto." + ex);
        }
         return checkUser;
    }
    
}
