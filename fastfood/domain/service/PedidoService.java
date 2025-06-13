
package br.dev.luiza.fastfood.domain.service;

import br.dev.luiza.fastfood.domain.model.Pedido;
import br.dev.luiza.fastfood.domain.model.StatusPedido;
import br.dev.luiza.fastfood.domain.repository.PedidoRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    public Pedido criar(Pedido pedido) {
        pedido.setStatus(StatusPedido.ABERTO);
        pedido.setHorario(LocalDateTime.now());
        return pedidoRepository.save(pedido);
    
    }

    public Pedido alterarStatus(Long id, StatusPedido novoStatus) {
         Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus(novoStatus);
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }
    
    public void cancelar(Long id) {
        pedidoRepository.findById(id).map(pedido -> {
            pedido.setStatus(StatusPedido.CANCELADO);
            pedidoRepository.save(pedido);
            return pedido;
        }).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
    
    public Pedido atualizar(Long id, Pedido pedidoAtualizado) {
        return pedidoRepository.findById(id).map(pedido -> {
             pedidoAtualizado.setId(id);
        return pedidoRepository.save(pedidoAtualizado);
        }).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public List<Pedido> buscarPorStatus(StatusPedido status) {
        return pedidoRepository.findByStatus(status);
    }

}
