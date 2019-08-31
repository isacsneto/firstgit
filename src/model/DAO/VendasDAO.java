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
import model.bean.Venda;
import model.bean.VendaProduto;

/**
 *
 * @author isac_
 */
public class VendasDAO {
    
    public void create(Venda f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO vendas (clientev, qtditens, datavenda, valort) VALUES (?,?,?,?)");
            stmt.setString(1, f.getClientev());
            stmt.setInt(2, f.getQtditens());
            stmt.setString(3, f.getDatavenda());
            stmt.setDouble(4, f.getValort());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Nova venda iniciada!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao iniciar venda." + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void update1(Venda f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE vendas set qtditens = ?, valort = ? WHERE idvenda = ?");
            stmt.setInt(1, f.getQtditens());
            stmt.setDouble(2, f.getValort());
            stmt.setInt(3, f.getIdvenda());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Compra fechada com sucesso.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar." + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void update2(Venda f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE vendas set clientev = ? WHERE idvenda = ?");
            stmt.setString(1, f.getClientev());
            stmt.setInt(2, f.getIdvenda());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao finalizar." + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Venda> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Venda> vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vendas");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();

                venda.setIdvenda(rs.getInt("idvenda"));
                venda.setClientev(rs.getString("clientev"));
                venda.setQtditens(rs.getInt("qtditens"));
                venda.setDatavenda(rs.getString("datavenda"));
                venda.setValort(rs.getDouble("valort"));
                
                vendas.add(venda);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados." + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return vendas;

    }
    
    public void deleteprodutos(VendaProduto f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        if (ChecarIdvenda.checkVenda(f.getCodvenda())) {

        try {
            stmt = con.prepareStatement("DELETE from vendasprodutos WHERE codvenda = ?");
            stmt.setInt(1, f.getCodvenda());

            stmt.execute();

            //JOptionPane.showMessageDialog(null, "Produtos excluídos com sucesso.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        } else {
            JOptionPane.showMessageDialog(null, "Essa venda não existe.");  
        }

    }

    public void delete(Venda f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        if (ChecarIdvenda.checkVenda(f.getIdvenda())) {

        try {
            stmt = con.prepareStatement("DELETE from vendas WHERE idvenda = ?");
            stmt.setInt(1, f.getIdvenda());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        } else {
            JOptionPane.showMessageDialog(null, "Essa venda não existe.");  
        }

    }

    public List<Venda> readIdvenda(int idvenda) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Venda> venda = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vendas where idvenda like?");
            stmt.setString(1, "%"+idvenda+"%"); //possivel bug setString ou setInt
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda rvenda = new Venda();

                rvenda.setIdvenda(rs.getInt("idvenda"));
                rvenda.setClientev(rs.getString("clientev"));
                rvenda.setQtditens(rs.getInt("qtsitens"));
                rvenda.setDatavenda(rs.getString("datavenda"));
                rvenda.setValort(rs.getDouble("valort"));
                
                venda.add(rvenda);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return venda;

    }
    
    public static ArrayList<Venda> List(String ValToSearch) {
        ArrayList<Venda> pro = new ArrayList<Venda>();
        Statement st;
        ResultSet rs;
        try{
            Connection con = ConnectionFactory.getConnection();
            st = con.createStatement();
            String query="SELECT * FROM vendas WHERE CONCAT(idvenda, clientev, datavenda) LIKE '%"+ValToSearch+"%';";
            rs = st.executeQuery(query);
            
            Venda venda;
            
            while(rs.next())
            {
               venda = new Venda();
               venda.setIdvenda(rs.getInt("idvenda"));
               venda.setClientev(rs.getString("clientev"));
               venda.setQtditens(rs.getInt("qtditens"));
               venda.setDatavenda(rs.getString("datavenda"));
               venda.setValort(rs.getDouble("valort"));
               pro.add(venda);
            }
            
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return pro;
    
    }
    
    public static ArrayList<VendaProduto> ListP(String a) {
        ArrayList<VendaProduto> pro = new ArrayList<VendaProduto>();
        Statement st;
        ResultSet rs;
        try{
            Connection con = ConnectionFactory.getConnection();
            st = con.createStatement();
            String query="SELECT vendasprodutos.codproduto, vendasprodutos.qtdproduto, produtos.nome, produtos.preco from produtos join vendasprodutos on produtos.codigo = vendasprodutos.codproduto where vendasprodutos.codvenda = "+a+"";
            rs = st.executeQuery(query);
            
            VendaProduto vendap;
            
            while(rs.next())
            {
               vendap = new VendaProduto();
               vendap.setCodproduto(rs.getInt("vendasprodutos.codproduto"));
               vendap.setQtdproduto(rs.getInt("vendasprodutos.qtdproduto"));
               vendap.setNomeproduto(rs.getString("produtos.nome"));
               vendap.setPrecoproduto(rs.getDouble("produtos.preco"));
               pro.add(vendap);
            }
            
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return pro;
    
    }
    
    public List<Venda> readConsumidor() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<Venda> vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select clientev, count(clientev) as compras_feitas, sum(qtditens) as quantidade_total, sum(valort) as valor_total from vendas where clientev not in ('111.111.111-11') group by clientev order by compras_feitas desc");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Venda p1 = new Venda();

                p1.setClientev(rs.getString("clientev"));
                p1.setQtd_compras(rs.getInt("compras_feitas"));
                p1.setQtditens(rs.getInt("quantidade_total"));
                p1.setValort(rs.getDouble("valor_total"));
                
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
