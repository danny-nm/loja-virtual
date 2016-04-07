package br.com.alura.javaEJdbcTrabalhandoComBancoDeDadosDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.javaEJdbcTrabalhandoComBancoDeDadosModelo.Categoria;
import br.com.alura.javaEJdbcTrabalhandoComBancoDeDadosModelo.Produto;

public class ProdutosDAO {

	private final Connection con;

	public ProdutosDAO(Connection con) {
		this.con = con;

	}

	public void salva(Produto produto) throws SQLException {
		String sql = "insert into Produto (nome, descricao) values (?,?)";

		try (PreparedStatement smtp = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			smtp.setString(1, produto.getNome());
			smtp.setString(2, produto.getDescricao());
			smtp.execute();

			try (ResultSet rs = smtp.getGeneratedKeys()) {
				if (rs.next()) {
					int id = rs.getInt("id");
					produto.setId(id);
				}

			}
		}
	}

	public List<Produto> lista() throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		String sql = "select * from produto";

		try (PreparedStatement smtp = con.prepareStatement(sql)) {
			smtp.execute();

			transformaResultadoEmProdutos(produtos, smtp);
		}
		return produtos;
	}

	private void transformaResultadoEmProdutos(List<Produto> produtos, PreparedStatement smtp) throws SQLException {
		try (ResultSet rs = smtp.getResultSet()) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				Produto produto = new Produto(nome, descricao);
				produto.setId(id);
				produtos.add(produto);

			}
		}
	}

	public List<Produto> busca(Categoria categoria) throws SQLException {
		
		List<Produto> produtos = new ArrayList<>();
		String sql = "select * from produto where categoria_id = ?";

		try (PreparedStatement smtp = con.prepareStatement(sql)) {
			smtp.setInt(1, categoria.getId());
			smtp.execute();

			transformaResultadoEmProdutos(produtos, smtp);
		}
		return produtos;
	}
}
