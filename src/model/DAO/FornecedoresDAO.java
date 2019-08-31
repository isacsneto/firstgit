package model.DAO;

import Check.ChecarCNPJ;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Fornecedor;

public class FornecedoresDAO {

    public void create(Fornecedor f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO fornecedor (nome, cnpj, email, celular, cep, rua, numero) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCnpj());
            stmt.setString(3, f.getEmail());
            stmt.setString(4, f.getCelular());
            stmt.setString(5, f.getCep());
            stmt.setString(6, f.getRua());
            stmt.setString(7, f.getNumero());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registrado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Fornecedor> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM fornecedor");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setCelular(rs.getString("celular"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setRua(rs.getString("rua"));
                fornecedor.setNumero(rs.getString("numero"));
                
                fornecedores.add(fornecedor);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return fornecedores;

    }

    public void update(Fornecedor f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE fornecedor set nome = ?, email = ?, celular = ?, cep = ?, rua = ?, numero = ? WHERE cnpj = ?");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getEmail());
            stmt.setString(3, f.getCelular());
            stmt.setString(4, f.getCep());
            stmt.setString(5, f.getRua());
            stmt.setString(6, f.getNumero());
            stmt.setString(7, f.getCnpj());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterado" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Fornecedor f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        if (ChecarCNPJ.checkCnpj(f.getCnpj())) {

        try {
            stmt = con.prepareStatement("DELETE from fornecedor WHERE cnpj = ?");
            stmt.setString(1, f.getCnpj());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        } else {
            JOptionPane.showMessageDialog(null, "O CNPJ desse fornecedor não está cadastrado.");  
        }

    }

    public List<Fornecedor> readCnpj(String cnpj) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM fornecedor where cnpj like?");
            stmt.setString(1, "%"+cnpj+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setCelular(rs.getString("celular"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setRua(rs.getString("rua"));
                fornecedor.setNumero(rs.getString("numero"));
                
                fornecedores.add(fornecedor);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return fornecedores;

    }
    
    public static ArrayList<Fornecedor> List(String ValToSearch) {
        ArrayList<Fornecedor> pro = new ArrayList<Fornecedor>();
        Statement st;
        ResultSet rs;
        try{
            Connection con = ConnectionFactory.getConnection();
            st = con.createStatement();
            String query="SELECT * FROM fornecedor WHERE CONCAT(nome, cnpj) LIKE '%"+ValToSearch+"%';";
            rs = st.executeQuery(query);
            
            Fornecedor fornecedor;
            
            while(rs.next())
            {
               fornecedor = new Fornecedor();
               fornecedor.setNome(rs.getString("nome"));
               fornecedor.setCnpj(rs.getString("cnpj"));
               fornecedor.setEmail(rs.getString("email"));
               fornecedor.setCelular(rs.getString("celular"));
               fornecedor.setCep(rs.getString("cep"));
               fornecedor.setRua(rs.getString("rua"));
               fornecedor.setNumero(rs.getString("numero"));
               pro.add(fornecedor);
            }
            
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return pro;
    
    }

}
