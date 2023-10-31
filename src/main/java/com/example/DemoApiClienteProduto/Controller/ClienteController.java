package com.example.DemoApiClienteProduto.Controller;

import com.example.DemoApiClienteProduto.Model.Cliente;
import com.example.DemoApiClienteProduto.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiCliente")
public class ClienteController {

    @Autowired
    ClienteRepository clRep;


    @PostMapping("/inserirCliente")
    public void cadastrarCliente(@RequestBody Cliente c){
        clRep.save(c);
    }

    @GetMapping("/todos")
    public List<Cliente> buscarTodosClientes(){
        return clRep.findAll();
    }

    @GetMapping("/buscarCodigo/{codigo}")
    public Optional<Cliente> buscarCodigoCliente(@PathVariable("codigo") int cod){
        return clRep.findById(cod);
    }

    @GetMapping("/buscarComecoNome/{parteNome}")
    public List<Cliente> buscarComecoNome(@PathVariable("parteNome") String nome){
        return clRep.findByComecoNome(nome);
    }

    @GetMapping("/buscarEmail/{email}")
    public List<Cliente> buscarEmail(@PathVariable("email")String email){
        return clRep.findByEmail(email);
    }

    @GetMapping("/buscarNomeEmail/{nomeEmail}")
    public List<Cliente> buscarNomeEmail(@PathVariable("nomeEmail") String nomeEmail){
        return clRep.findByNomeEmail(nomeEmail);
    }

}
