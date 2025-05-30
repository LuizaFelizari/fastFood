
package br.dev.luiza.fastFood.controller;

import br.dev.luiza.FastFoodApplication.domain.model.Produto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProdutoController {
   
    List<Produto> listaProdutos;
    
    @GetMapping("/produtos")
    public List<Produto> listas() {
        
        listaProdutos = new ArrayList<Produto>();
        
        
        return listaProdutos;
    }
}
