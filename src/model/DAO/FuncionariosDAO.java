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
import model.bean.Funcionario;

public class FuncionariosDAO {

    public void create(Funcionario f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        if(!ChecarCpf.checkCpfUsuario(f.getCpf())) {

        try {
            stmt = con.prepareStatement("INSERT INTO funcionario (nome, cpf, email, datanascimento, celular, cep, rua, numero, funcao, senha) VALUES (?,?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getEmail());
            stmt.setString(4, f.getData_nasc());
            stmt.setString(5, f.getCelular());
            stmt.setString(6, f.getCep());
            stmt.setString(7, f.getRua());
            stmt.setString(8, f.getNumero());
            stmt.setString(9, f.getFuncao());
            stmt.setString(10, f.getSenha());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registrado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        } else {
            JOptionPane.showMessageDialog(null, "CPF já cadastrado.");
        }

    }

    public List<Funcionario> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setData_nasc(rs.getString("datanascimento"));
                funcionario.setCelular(rs.getString("celular"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setRua(rs.getString("rua"));
                funcionario.setNumero(rs.getString("numero"));
                funcionario.setFuncao(rs.getString("funcao"));
                
                funcionarios.add(funcionario);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return funcionarios;
    }

    public void update(Funcionario f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE funcionario SET nome = ?, email = ?, datanascimento = ?, celular = ?, cep = ?, rua = ?, numero = ?, funcao = ? WHERE cpf = ?");
            
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getEmail());
            stmt.setString(3, f.getData_nasc());
            stmt.setString(4, f.getCelular());
            stmt.setString(5, f.getCep());
            stmt.setString(6, f.getRua());
            stmt.setString(7, f.getNumero());
            stmt.setString(8, f.getFuncao());
            
            stmt.setString(9, f.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Funcionario f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM funcionario WHERE cpf = ?");
            stmt.setString(1, f.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Funcionario> readCpf(String cpf) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario where cpf like ?");
            stmt.setString(1, "%"+cpf+"%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setData_nasc(rs.getString("datanascimento"));
                funcionario.setCelular(rs.getString("celular"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setRua(rs.getString("rua"));
                funcionario.setNumero(rs.getString("numero"));
                funcionario.setFuncao(rs.getString("funcao"));
                
                funcionarios.add(funcionario);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return funcionarios;
    }
    
    public static ArrayList<Funcionario> List(String ValToSearch) {
        ArrayList<Funcionario> pro = new ArrayList<Funcionario>();
        Statement st;
        ResultSet rs;
        try{
            Connection con = ConnectionFactory.getConnection();
            st = con.createStatement();
            String query="SELECT * FROM `funcionario` WHERE CONCAT(`nome`,`cpf`) LIKE '%"+ValToSearch+"%';";
            rs = st.executeQuery(query);
            
            Funcionario funcionario;
            
            while(rs.next())
            {
               funcionario = new Funcionario();
               
               funcionario.setNome(rs.getString("nome"));
               funcionario.setCpf(rs.getString("cpf"));
               funcionario.setEmail(rs.getString("email"));
               funcionario.setData_nasc(rs.getString("datanascimento"));
               funcionario.setCelular(rs.getString("celular"));
               funcionario.setCep(rs.getString("cep"));
               funcionario.setRua(rs.getString("rua"));
               funcionario.setNumero(rs.getString("numero"));
               funcionario.setFuncao(rs.getString("funcao"));
               pro.add(funcionario);
            }        
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return pro;
    
    }

}
