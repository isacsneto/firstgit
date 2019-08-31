/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import Check.ChecarIdvenda;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Produto;
import model.bean.VendaProduto;

/**
 *
 * @author isac_
 */
public class VendasProdutosDAO {
    
    public void create(VendaProduto f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO vendasprodutos (codvenda, codproduto, qtdproduto) VALUES (?,?,?)");
            stmt.setInt(1, f.getCodvenda());
            stmt.setInt(2, f.getCodproduto());
            stmt.setInt(3, f.getQtdproduto());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Novo produto adicionado!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar produto." + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    /*public int lastid(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            //SELECT idvenda FROM vendas ORDER BY idvenda DESC LIMIT 1;
            st = con.prepareStatement("SELECT idvenda FROM vendas ORDER BY idvenda DESC LIMIT 1");
            rs = st.executeQuery();
            int i = (int) rs.getInt("idvenda");
            return i;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sei n!");
        }
        return 0; 
    }
    --//--
    public ResultSet lastid(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = con.prepareStatement("SELECT idvenda FROM vendas ORDER BY idvenda DESC LIMIT 1");
            rs = st.executeQuery();
            System.out.println(rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sei n!");
        }
        return rs; 
    }*/
    
    public static int getAutoIncrementProductID() {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;
    
    int autoIncKeyFromFunc = -1;
    try {
        stmt = con.prepareStatement("SELECT max(idvenda) FROM vendas");
        rs = stmt.executeQuery();
        if (rs.next()) {
            autoIncKeyFromFunc = rs.getInt(1);
            System.out.println("IDvenda é " + autoIncKeyFromFunc);
            rs.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return autoIncKeyFromFunc;
}
    
    public static int getVendaProductID() {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;
    int a = VendasProdutosDAO.getAutoIncrementProductID();
    
    int autoIncKeyFromFunc = -1;
    try {
        stmt = con.prepareStatement("SELECT qtdproduto FROM vendasprodutos WHERE codvenda = "+a+"");
        rs = stmt.executeQuery();
        if (rs.next()) {
            autoIncKeyFromFunc = rs.getInt(1);
            rs.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return autoIncKeyFromFunc;
}
    
    public static int getEstoqueProductID(int a) {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;
    
    int autoIncKeyFromFunc = -1;
    try {
        stmt = con.prepareStatement("SELECT qtd FROM produtos WHERE codigo = "+a+"");
        rs = stmt.executeQuery();
        if (rs.next()) {
            autoIncKeyFromFunc = rs.getInt(1);
            rs.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return autoIncKeyFromFunc;
}
    
        public static void updateEstoque(Produto f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produtos set qtd = ? WHERE codigo = ?");
            stmt.setInt(1, f.getQtd());
            stmt.setInt(2, f.getCodigo());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar estoque." + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public static double getValorTotalProductID() {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;
    int a = VendasProdutosDAO.getAutoIncrementProductID();
    
    double autoIncKeyFromFunc = -1;
    try {
        stmt = con.prepareStatement("SELECT valort FROM vendas WHERE idvenda = "+a+"");
        rs = stmt.executeQuery();
        if (rs.next()) {
            autoIncKeyFromFunc = rs.getDouble(1);
            System.out.println("Valor total é " + autoIncKeyFromFunc);
            rs.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return autoIncKeyFromFunc;
}

    public List<VendaProduto> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaProduto> vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vendasprodutos");
            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaProduto vendaproduto = new VendaProduto();

                vendaproduto.setCodvenda(rs.getInt("codvenda"));
                vendaproduto.setCodproduto(rs.getInt("codproduto"));
                vendaproduto.setQtdproduto(rs.getInt("qtdproduto"));
                
                vendas.add(vendaproduto);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados." + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return vendas;

    }


    public void delete(VendaProduto f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        if (ChecarIdvenda.checkVenda(f.getCodvenda())) {

        try {
            stmt = con.prepareStatement("DELETE from vendasprodutos WHERE codproduto = ? and codvenda = ?");
            stmt.setInt(1, f.getCodproduto());
            stmt.setInt(2, f.getCodvenda());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto." + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        } else {
            JOptionPane.showMessageDialog(null, "Essa venda não existe.");  
        }

    }

    public List<VendaProduto> readCodvenda(int codvenda) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaProduto> vendaproduto = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vendas where idvenda like?");
            stmt.setString(1, "%"+codvenda+"%"); //possivel bug setString ou setInt
            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaProduto rvenda = new VendaProduto();

                rvenda.setCodvenda(rs.getInt("codvenda"));
                rvenda.setCodproduto(rs.getInt("codproduto"));
                rvenda.setQtdproduto(rs.getInt("qtdproduto"));
                
                vendaproduto.add(rvenda);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return vendaproduto;

    }
    
    public static ArrayList<VendaProduto> List(int ValToSearch) {
        ArrayList<VendaProduto> pro = new ArrayList<VendaProduto>();
        Statement st;
        ResultSet rs;
        try{
            Connection con = ConnectionFactory.getConnection();
            st = con.createStatement();
            String s = "select vendasprodutos.codvenda, produtos.codigo, produtos.nome, vendasprodutos.qtdproduto, produtos.preco from produtos join vendasprodutos on produtos.codigo = vendasprodutos.codproduto where vendasprodutos.codvenda = "+ValToSearch+";";
            rs = st.executeQuery(s);
            
            VendaProduto vendaproduto;
            
            while(rs.next())
            {
               vendaproduto = new VendaProduto();
               vendaproduto.setCodvenda(rs.getInt("vendasprodutos.codvenda"));
               vendaproduto.setCodproduto(rs.getInt("produtos.codigo"));
               vendaproduto.setNomeproduto(rs.getString("produtos.nome"));
               vendaproduto.setQtdproduto(rs.getInt("vendasprodutos.qtdproduto"));
               vendaproduto.setPrecoproduto(rs.getDouble("produtos.preco"));
               pro.add(vendaproduto);
            }
            
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return pro;
    
    }
    
     public List<Produto> readMaisVendidos() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select vendasprodutos.codproduto, produtos.nome, sum(vendasprodutos.qtdproduto) as quantidade from vendasprodutos join produtos on vendasprodutos.codproduto = produtos.codigo  group by codproduto order by sum(qtdproduto) desc;");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p1 = new Produto();

                p1.setCodigo(rs.getInt("vendasprodutos.codproduto"));
                p1.setNome(rs.getString("produtos.nome"));
                p1.setQtd(rs.getInt("quantidade"));
                
                vendas.add(p1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados." + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return vendas;

    }


}
