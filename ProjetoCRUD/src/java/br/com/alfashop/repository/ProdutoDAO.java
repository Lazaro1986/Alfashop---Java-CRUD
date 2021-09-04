package br.com.alfashop.repository;

import br.com.alfashop.config.Conex;
import br.com.alfashop.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lázaro
 */
public class ProdutoDAO {
    
    Connection conn;
    
    public ProdutoDAO(){
        this.conn = Conex.getConnection();
    }
    
    public List<Produto> listar(){
        List<Produto> lista = new ArrayList<Produto>();
        try{
            Statement stmt = this.conn.createStatement();
            String sql = "select * from produtos";
            ResultSet rset = stmt.executeQuery(sql);
            while(rset.next()){
                Produto obj = new Produto();
                obj.setIdproduto(rset.getLong("idprodutos"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setMaisinfo(rset.getString("maisinfo"));
                obj.setPeso(rset.getFloat("peso"));
                obj.setValor(rset.getFloat("valor"));
                obj.setDestaque(rset.getString("destaque"));
                obj.setAtivo(rset.getString("ativo"));
                obj.setCategoriaid(rset.getLong("categorias_idcategorias"));
                //adiciono o obj em uma lista
                lista.add(obj);
            }
            rset.close();
            stmt.close();
            this.conn.close();
        }
        catch(Exception e){
            lista = null;
        }
        return lista;
    }
    
    /**
     * método para ser utilizado como JavaBean getProdutos()
     * @return 
     */
    public List<Produto> getProdutos(){
        return listar();
    }
    
    public List<Produto> buscar(String filtro){
        List<Produto> lista = new ArrayList<Produto>();
        try{
            Statement stmt = this.conn.createStatement();
            String sql = "select p.*, c.nome as nomecat from produtos p "
                        + "inner join categorias c on c.idcategorias = p.categorias_idcategorias "
                        + "where "+filtro;
            ResultSet rset = stmt.executeQuery(sql);
            while(rset.next()){
                Produto obj = new Produto();
                obj.setIdproduto(rset.getLong("idprodutos"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setMaisinfo(rset.getString("maisinfo"));
                obj.setPeso(rset.getFloat("peso"));
                obj.setValor(rset.getFloat("valor"));
                obj.setDestaque(rset.getString("destaque"));
                obj.setAtivo(rset.getString("ativo"));
                obj.setCategoriaid(rset.getLong("categorias_idcategorias"));
                obj.setNomecat(rset.getString("nomecat"));
                //adiciono o obj em uma lista
                lista.add(obj);
            }
            rset.close();
            stmt.close();
            this.conn.close();
        }
        catch(Exception e){
            lista = null;
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    /**
     * método para utilizar como JavaBean getDestaques()
     * @return 
     */
    public List<Produto> getDestaques(){
        return buscar("destaque='s'");
    }
    
    public int inserir(Produto obj){
        int res = 0;
        String nom = obj.getNome();
        String des = obj.getDescricao();
        String atv = obj.getAtivo();
        String sql = "insert into produtos (nome, descricao, ativo) values (?, ?, ?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, des);
            stmt.setString(3, atv);
            res = stmt.executeUpdate();
            
            stmt.close();
            this.conn.close();
        }
        catch(Exception e){
            res = 0;
        }
        return res;
    }
    
    public int atualizar(Produto obj){
        int res = 0;
        Long idpro = obj.getIdproduto();
        String nom = obj.getNome();
        String des = obj.getDescricao();
        String atv = obj.getAtivo();
        String sql = "update produtos set nome=?, descricao=?, ativo=? where idcategorias=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, des);
            stmt.setString(3, atv);
            stmt.setLong(4, idpro);
            res = stmt.executeUpdate();
            
            stmt.close();
            this.conn.close();
        }
        catch(Exception e){
            res = 0;
        }
        return res;
    }
    
    public int excluir(Produto obj){
        int res = 0;
        Long idpro = obj.getIdproduto();
        String sql = "delete from categorias where idprodutos=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setLong(1, idpro);
            res = stmt.executeUpdate();
            
            stmt.close();
            this.conn.close();
        }
        catch(Exception e){
            res = 0;
        }
        return res;
    }
}
