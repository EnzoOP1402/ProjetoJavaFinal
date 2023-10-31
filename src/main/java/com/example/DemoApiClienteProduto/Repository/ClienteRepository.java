package com.example.DemoApiClienteProduto.Repository;
import com.example.DemoApiClienteProduto.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("select a from Cliente where a.nome like ?1%")
    List<Cliente> findByComecoNome(String nome);

    List<Cliente> findByEmail(String email);

    @Query("select a from Cliente a where a.nome like %?1% and a.email like %?2%")
    List<Cliente> findByNomeEmail(String nome, String email);
}
