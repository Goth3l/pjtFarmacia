package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Produto;
import com.example.demo.repositories.ProdutoRepository;
@Service
public class ProdutoService {
	//faltou instanciar o Repositorio
	private final ProdutoRepository produtoRepository;
	
	@Autowired
	   public ProdutoService(ProdutoRepository produtoRepository) {
	    this.produtoRepository = produtoRepository;
	   }
	   
	   public Produto salvarProduto(Produto produto) {
	       return produtoRepository.save(produto);
	       
	   }
	   
	   public Produto buscarProdutoPorId(Long id) {
	       return produtoRepository.findById(id).orElse(null);
	   }
	   
	   public List<Produto> buscarTodosProduto(){
	       return produtoRepository.findAll();
	   }
	   
	   public void excluirProduto(Long id) {
		   produtoRepository.deleteById(id);
	   }
	   public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
	       Optional<Produto> produtoExistente = produtoRepository.findById(id);
	       if(produtoExistente.isPresent()) {
	    	   Produto produto = produtoExistente.get();
	    	   produto.setNome(produtoAtualizado.getNome());
	    	   produto.setBula(produtoAtualizado.getBula());
	    	   produto.setDataValidade(produtoAtualizado.getDataValidade());
	    	   produto.setIdFornecedor(produtoAtualizado.getIdFornecedor());
	           return produtoRepository.save(produto);
	       }
	       else
	       {
	           return null;
	       }
	   }
}
