
public class ProdutosDTO {
    
    //Declaração de atributos:
    private Integer id;
    private String nome;
    private Integer valor;
    private String status;
    
    //Métodos construtores:
    public ProdutosDTO() {
    }

    public ProdutosDTO(Integer id, String nome, Integer valor, String status) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.status = status;
    }
    
    //Métodos getters e setters:
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public void setStatus(String status) {
        this.status = status;
    } 
}
