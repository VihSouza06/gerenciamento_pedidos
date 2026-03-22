package com.bn.exercico3.controllers;

import com.bn.exercico3.models.PedidoModel;
import com.bn.exercico3.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoModel>>findAll(){
        List<PedidoModel> pedidos = pedidoService.findAll();
        return ResponseEntity.ok().body(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoModel> buscarPedidoPorId(@PathVariable Long id){
       PedidoModel pedido = pedidoService.buscarPedidoPorId(id);
       return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<PedidoModel> criarPedido(@RequestBody PedidoModel pedidoModel){
        PedidoModel pedidoCriado = pedidoService.criarPedido(pedidoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(pedidoModel.getId()).toUri();
        return ResponseEntity.created(uri).body(pedidoCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedido(@PathVariable Long id){
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoModel> atualizarPedido
            (@PathVariable Long id, @RequestBody PedidoModel pedidoModel){
        PedidoModel pedidoAtualizado = pedidoService.atualizarPedido(id, pedidoModel);
        return ResponseEntity.ok(pedidoAtualizado);
    }

}
