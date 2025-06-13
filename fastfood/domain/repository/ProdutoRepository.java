
package br.dev.luiza.fastfood.domain.repository;

import br.dev.luiza.fastfood.domain.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
   List<Produto> findByCategoria(String categoria);
}
