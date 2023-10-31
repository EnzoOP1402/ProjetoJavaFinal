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
    ProdutoRepository ProdRep;

    @PostMapping("/inserirProduto")
    public void cadastrarProduto(@RequestBody Produto p){
        ProdRep.save(p);
    }

    @GetMapping("/todos")
    public List<Produto> buscarTodosProdutos(){
        return ProdRep.findAll();
    }

    @GetMapping("/bucarPorRa/{codigo}")
    public Optional<Produto> buscarPorCodigo(@PathVariable("codigo")int codigo){
        return ProdRep.findById(codigo);
    }

    @GetMapping("/buscarParteInicialDesc/{desc}")
    public List<Produto> buscarPorParteIniDesc(@PathVariable("desc") String desc){
        return ProdRep.findByParteInicialDesc(desc);
    }
}
