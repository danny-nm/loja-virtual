package br.com.alura.javaEJdbcTrabalhandoComBancoDeDadosModelo;

public class Produto {

	private Integer Id;
	private String nome;
	private String descricao;

	public Produto(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId(Integer id) {
		Id = id;
	}

	@Override
	public String toString() {
		return String.format("[produto: %d %s %s]", Id, nome, descricao);
	}

}
