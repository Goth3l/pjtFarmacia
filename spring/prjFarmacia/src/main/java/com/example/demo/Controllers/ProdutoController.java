package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Produto;
import com.example.demo.services.ProdutoService;

@RestController
@RequestMapping("/Produto")
public class ProdutoController {

	   private final ProdutoService produtoService;

	   @Autowired
	   public ProdutoController(ProdutoService produtoService) {
	       this.produtoService = produtoService;
	   }

	   @PostMapping
	   public Produto criarUsuario(@RequestBody Produto produto) {
	       return produtoService.salvarProduto(produto);
	   }

	   @GetMapping
	   public List<Produto> buscarTodos() {
	       return produtoService.buscarTodosProduto();
	   }

	   @GetMapping("/{id}")
	   public Produto buscarPorId(@PathVariable Long id) {
	       return produtoService.buscarProdutoPorId(id);
	   }

	   @DeleteMapping("/{id}")
	   public void deletarUsuario(@PathVariable Long id) {
		   produtoService.excluirProduto(id);
	   }

	   @PutMapping
	   public ResponseEntity<Produto> ProdutoAtualizado(@PathVariable Long id, @RequestBody Produto produto) {
	       Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
	       if (produtoAtualizado != null) {
	           return ResponseEntity.ok(produtoAtualizado);
	       } else {
	           return null;
	       }
	   }
	}


