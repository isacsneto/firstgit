package model.DAO;

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

public class ProdutoDAO {

    public void create(Produto p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produtos (nome, preco, qtd , descricao, data_fabri, cnpj_fornec) values (?,?,?,?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getQtd());
            stmt.setString(4, p.getDescricao());
            stmt.setString(5, p.getData_fabri());
            stmt.setString(6, p.getCnpj_fornec());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registrado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Produto> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produtos");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                 produto.setQtd(rs.getInt("qtd"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setData_fabri(rs.getString("data_fabri"));
                produto.setCnpj_fornec(rs.getString("cnpj_fornec"));
                
                produtos.add(produto);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;
    }

    public void update(Produto p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produtos SET nome = ?, preco = ?, qtd = ?, descricao = ?, data_fabri = ?, cnpj_fornec = ? WHERE codigo = ?");
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getQtd()); 
            stmt.setString(4, p.getDescricao());
            stmt.setString(5, p.getData_fabri());
            stmt.setString(6, p.getCnpj_fornec());
            stmt.setInt(7, p.getCodigo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Produto p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update produtos set qtd = 0 WHERE codigo = ?");
            stmt.setInt(1, p.getCodigo());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Estoque zerado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Produto> readCodigo(String codigo) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produtos where codigo = ?");
            stmt.setString(1, codigo);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQtd(rs.getInt("qtd"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setData_fabri(rs.getString("data_fabri"));
                produto.setCnpj_fornec(rs.getString("cnpj_fornec"));
                
                produtos.add(produto);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;
    }
    
    public static ArrayList<Produto> List(String ValToSearch) {
        ArrayList<Produto> pro = new ArrayList<Produto>();
        Statement st;
        ResultSet rs;
        try{
            Connection con = ConnectionFactory.getConnection();
            st = con.createStatement();
            String query="SELECT * FROM `produtos` WHERE CONCAT(`codigo`,`nome`,`cnpj_fornec`) LIKE '%"+ValToSearch+"%';";
            rs = st.executeQuery(query);
            
            Produto produto;
            
            while(rs.next())
            {
               produto = new Produto();
               produto.setCodigo(rs.getInt("codigo"));
               produto.setNome(rs.getString("nome"));
               produto.setPreco(rs.getDouble("preco"));
               produto.setQtd(rs.getInt("qtd"));
               produto.setDescricao(rs.getString("descricao"));
               produto.setData_fabri(rs.getString("data_fabri"));
               produto.setCnpj_fornec(rs.getString("cnpj_fornec"));
               pro.add(produto);
            }    
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return pro;
    
    }
    
     public void updateEstoque(Produto p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        

        try {
            stmt = con.prepareStatement("call estoque(?,?)");
            stmt.setInt(1, p.getCodigo());
            stmt.setInt(2, p.getNova_qtd()); 
           
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
