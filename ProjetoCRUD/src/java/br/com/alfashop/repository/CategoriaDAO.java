package br.com.alfashop.repository;

import br.com.alfashop.config.Conex;
import br.com.alfashop.model.Categoria;
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
public class CategoriaDAO {

    Connection conn;
    
    public CategoriaDAO(){
        this.conn = Conex.getConnection();
    }
    
    public List<Categoria> listar(){
        List<Categoria> lista = new ArrayList<Categoria>();
        try{
            Statement stmt = this.conn.createStatement();
            String sql = "select * from categorias";
            ResultSet rset = stmt.executeQuery(sql);
            while(rset.next()){
                Categoria obj = new Categoria();
                obj.setIdcategoria(rset.getLong("idcategorias"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setAtivo(rset.getString("ativo"));
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
     * método para ser utilizado como JavaBean getCategorias()
     * @return 
     */
    public List<Categoria> getCategorias(){
        return listar();
    }
    
    public Categoria buscar(String filtro){
        Categoria obj = new Categoria();
        try{
            Statement stmt = this.conn.createStatement();
            String sql = "select * from categorias where "+filtro;
            ResultSet rset = stmt.executeQuery(sql);
            while(rset.next()){
                obj.setIdcategoria(rset.getLong("idcategorias"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setAtivo(rset.getString("ativo"));
            }
            rset.close();
            stmt.close();
            this.conn.close();
        }
        catch(Exception e){
            obj = null;
        }
        return obj;
    }
    
    public int inserir(Categoria obj){
        int res = 0;
        String nom = obj.getNome();
        String des = obj.getDescricao();
        String atv = obj.getAtivo();
        String sql = "insert into categorias (nome, descricao, ativo) values (?, ?, ?)";
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
    
    public int atualizar(Categoria obj){
        int res = 0;
        Long idcat = obj.getIdcategoria();
        String nom = obj.getNome();
        String des = obj.getDescricao();
        String atv = obj.getAtivo();
        String sql = "update categorias set nome=?, descricao=?, ativo=? where idcategorias=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, des);
            stmt.setString(3, atv);
            stmt.setLong(4, idcat);
            res = stmt.executeUpdate();
            
            stmt.close();
            this.conn.close();
        }
        catch(Exception e){
            res = 0;
        }
        return res;
    }
    
    public int excluir(Categoria obj){
        int res = 0;
        Long idcat = obj.getIdcategoria();
        String sql = "delete from categorias where idcategorias=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setLong(1, idcat);
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