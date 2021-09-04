package br.com.alfashop.model;

/**
 *
 * @author Lázaro
 */
public class Produto {
    private Long idproduto;
    private String nome;
    private String descricao;
    private String maisinfo;
    private Float valor;
    private Float peso;
    private String destaque;
    private String ativo;
    private Long categoriaid;
    private String nomecat;

    /**
     * @return the idprodutos
     */
    public Long getIdproduto() {
        return idproduto;
    }

    /**
     * @param idprodutos the idprodutos to set
     */
    public void setIdproduto(Long idprodutos) {
        this.idproduto = idprodutos;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the maisinfo
     */
    public String getMaisinfo() {
        return maisinfo;
    }

    /**
     * @param maisinfo the maisinfo to set
     */
    public void setMaisinfo(String maisinfo) {
        this.maisinfo = maisinfo;
    }

    /**
     * @return the valor
     */
    public Float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Float valor) {
        this.valor = valor;
    }

    /**
     * @return the peso
     */
    public Float getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Float peso) {
        this.peso = peso;
    }

    /**
     * @return the destaque
     */
    public String getDestaque() {
        return destaque;
    }

    /**
     * @param destaque the destaque to set
     */
    public void setDestaque(String destaque) {
        this.destaque = destaque;
    }

    /**
     * @return the ativo
     */
    public String getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the categoriaid
     */
    public Long getCategoriaid() {
        return categoriaid;
    }

    /**
     * @param categoriaid the categoriaid to set
     */
    public void setCategoriaid(Long categoriaid) {
        this.categoriaid = categoriaid;
    }

    /**
     * @return the nomecat
     */
    public String getNomecat() {
        return nomecat;
    }

    /**
     * @param nomecat the nomecat to set
     */
    public void setNomecat(String nomecat) {
        this.nomecat = nomecat;
    }
    
    
}
