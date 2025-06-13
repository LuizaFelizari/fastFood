
package br.dev.luiza.fastfood.domain.repository;

import br.dev.luiza.fastfood.domain.model.Pedido;
import br.dev.luiza.fastfood.domain.model.StatusPedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(StatusPedido status);
}
