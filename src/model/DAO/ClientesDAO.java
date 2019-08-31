package model.DAO;

import Check.ChecarCpf;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Cliente;

public class ClientesDAO {

    public void create(Cliente c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cliente (nome, cpf, email, celular, cep, rua, numero) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getCelular());
            stmt.setString(5, c.getCep());
            stmt.setString(6, c.getRua());
            stmt.setString(7, c.getNumero());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registrado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Cliente> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("Select * from cliente");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setCep(rs.getString("cep"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getString("numero"));
                
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;

    }

    public void update(Cliente c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE cliente SET nome = ?, email = ?, celular = ?, cep = ?, rua = ?, numero = ? where cpf = ?");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getCelular());
            stmt.setString(4, c.getCep());
            stmt.setString(5, c.getRua());
            stmt.setString(6, c.getNumero());
            stmt.setString(7, c.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Cliente c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        if (ChecarCpf.checkCpfCliente(c.getCpf())) {
        
        try {
            stmt = con.prepareStatement("delete from `cliente` where cpf=?");
            stmt.setString(1, c.getCpf());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        } else {
            JOptionPane.showMessageDialog(null, "O CPF desse cliente não está cadastrado.");  
        }

    }
    
    public static ArrayList<Cliente> List(String ValToSearch) {
        ArrayList<Cliente> pro = new ArrayList<Cliente>();
        Statement st;
        ResultSet rs;
        try{
            Connection con = ConnectionFactory.getConnection();
            st = con.createStatement();
            String query="SELECT * FROM `cliente` WHERE CONCAT(`nome`,`cpf`) LIKE '%"+ValToSearch+"%';";
            rs = st.executeQuery(query);
            
            Cliente cliente;
            
            while(rs.next())
            {
               cliente = new Cliente();
               cliente.setNome(rs.getString("nome"));
               cliente.setCpf(rs.getString("cpf"));
               cliente.setEmail(rs.getString("email"));
               cliente.setCelular(rs.getString("celular"));
               cliente.setCep(rs.getString("cep"));
               cliente.setRua(rs.getString("rua"));
               cliente.setNumero(rs.getString("numero"));
               pro.add(cliente);
            }
            
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return pro;
    
    }

    public List<Cliente> readCpf(String cpf) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM cliente where cpf like ?");
            stmt.setString(1, "%"+cpf+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setCep(rs.getString("cep"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getString("numero"));
                
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;

    }

}
