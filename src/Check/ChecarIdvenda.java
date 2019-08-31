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
public class ChecarIdvenda {
    
    public static boolean checkVenda(int idvenda)
    {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `vendas` WHERE `idvenda` =?";
        
        try {
            ps = ConnectionFactory.getConnection().prepareStatement(query);
            ps.setInt(1, idvenda);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                checkUser = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar venda." + ex);
        }
         return checkUser;
    }
}
