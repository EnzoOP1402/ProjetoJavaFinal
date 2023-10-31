package com.example.DemoApiClienteProduto.Repository;
import com.example.DemoApiClienteProduto.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

    @Query("select a from Produto where a.desc like ?1%")
    List<Produto> findByParteInicialDesc(String parteIniDesc);

    @Query("select a from Produto where a.preco < ?1")
    List<Produto> findByValoresMenoresQue(double preco);

    List<Produto> findByMarca(String marca);

    @Query("select a from Produto where a.marca like %?1% and a.preco < ?2")
    List<Produto> findByMarcaValorMenorQue(String marca, double preco);
}
