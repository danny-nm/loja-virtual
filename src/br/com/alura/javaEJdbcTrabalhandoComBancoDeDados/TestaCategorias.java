package br.com.alura.javaEJdbcTrabalhandoComBancoDeDados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.javaEJdbcTrabalhandoComBancoDeDadosDAO.CategoriasDAO;
import br.com.alura.javaEJdbcTrabalhandoComBancoDeDadosDAO.ProdutosDAO;
import br.com.alura.javaEJdbcTrabalhandoComBancoDeDadosModelo.Categoria;
import br.com.alura.javaEJdbcTrabalhandoComBancoDeDadosModelo.Produto;

public class TestaCategorias {
	public static void main(String[] args) throws SQLException {
		try(Connection con = new ConnectionPool().getConection()){
			List<Categoria> categorias = new CategoriasDAO(con).listaComProdutos();
			for(Categoria categoria : categorias){
				System.out.println(categoria.getNome());
				
				for(Produto produto : categoria.getProdutos()){
					System.out.println(categoria.getNome() + " - " + produto.getNome());
				}
			}
		}
	}
}
