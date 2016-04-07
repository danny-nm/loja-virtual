package br.com.alura.javaEJdbcTrabalhandoComBancoDeDadosModelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.javaEJdbcTrabalhandoComBancoDeDados.ConnectionPool;
import br.com.alura.javaEJdbcTrabalhandoComBancoDeDadosDAO.ProdutosDAO;

public class TestaDAODeProduto {

	public static void main(String[] args) throws SQLException {

		Produto mesa = new Produto("Mesa Azul", "Mesa com 4 pés");

		try (Connection con = new ConnectionPool().getConection()) {
			ProdutosDAO dao = new ProdutosDAO(con);
			dao.salva(mesa);

			List<Produto> produtos = dao.lista();
			for (Produto produto : produtos) {
				System.out.println("Existe o  produto: " + produto);
			}

		}

	}

}
