
package br.dev.luiza.fastfood.domain.service;

import br.dev.luiza.fastfood.domain.model.Produto;
import br.dev.luiza.fastfood.domain.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {
    
    
    @Autowired
    private ProdutoRepository repository;
    
    public List<Produto> listar(){
        return repository.findAll();
    }
    
    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        produtoAtualizado.setId(id);
        return repository.save(produtoAtualizado);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Produto> buscarPorCategoria(String categoria) {
        return repository.findByCategoria(categoria);
    }
}
