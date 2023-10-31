package com.example.DemoApiClienteProduto.Controller;

import com.example.DemoApiClienteProduto.Model.Cliente;
import com.example.DemoApiClienteProduto.Model.Produto;
import com.example.DemoApiClienteProduto.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiProduto")
public class ProdutoController {

    @Autowired
    ProdutoRepository prRep;

    @PostMapping("/inserirProduto")
    public void cadastrarProduto(@RequestBody Produto p){
        prRep.save(p);
    }

    @GetMapping("/todos")
    public List<Produto> buscarTodosProdutos(){
        return prRep.findAll();
    }

    @GetMapping("/buscarPorCodigo/{codigo}")
    public Optional<Produto> buscarPorCodigo(@PathVariable("codigo")int codigo){
        return prRep.findById(codigo);
    }

    @GetMapping("/buscarParteInicialDesc/{desc}")
    public List<Produto> buscarPorParteIniDesc(@PathVariable("desc") String desc){
        return prRep.findByParteInicialDesc(desc);
    }

    @DeleteMapping("/excluirProdutoTodosDados")
    public void excluirProduto(@RequestBody Produto p){
        prRep.delete(p);
    }

    @DeleteMapping("/excluirProdutoCodigo/{codigo}")
    public void excluirProdutoCodigo(@PathVariable("codigo") int codigo){
        prRep.deleteById(codigo);
    }

    @PutMapping("/atualizarProduto")
    public void atualizarProduto(@RequestBody Produto p){
        prRep.save(p);
    }
}
