
package br.dev.luiza.fastfood.controller;

import br.dev.luiza.fastfood.domain.model.Pedido;
import br.dev.luiza.fastfood.domain.service.PedidoService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return pedidoService.criar(pedido);
    }

    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable Long id, @RequestBody Pedido pedido) {
        return pedidoService.atualizar(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void cancelar(@PathVariable Long id) {
        pedidoService.cancelar(id);
    }

    @GetMapping("/status/{status}")
    public List<Pedido> listarPorStatus(@PathVariable String status) {
        return pedidoService.listarPorStatus(status);
    }

    @PutMapping("/status/{id}")
    public Pedido alterarStatus(@PathVariable Long id, @RequestBody String novoStatus) {
        return pedidoService.alterarStatus(id, novoStatus);
    }
}
