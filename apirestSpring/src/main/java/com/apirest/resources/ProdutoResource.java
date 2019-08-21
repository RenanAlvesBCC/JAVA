package com.apirest.resources;

import com.apirest.models.Produto;
import com.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;
//
//    public ProdutoResource(ProdutoRepository produtoRepository) {
//            this.produtoRepository = produtoRepository;
//    }

    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        System.out.println("opa");
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{id}")
    public Produto listaProdutoUnico(@PathVariable(value="id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    public Produto salvaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto/{id}")
    public Produto deleteProduto(@PathVariable(value="id") long id) {
        return produtoRepository.deleteById(id);
    }

//    @DeleteMapping("/produto/{id}")
//    public Produto deleteProduto(@RequestBody Produto produto) {
//        produtoRepository.delete(produto);
//    }

    @PutMapping("/produto")
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }   
}
