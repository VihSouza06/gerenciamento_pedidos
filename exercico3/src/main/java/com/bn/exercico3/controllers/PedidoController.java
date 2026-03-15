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
        List<PedidoModel> requeste = pedidoService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<PedidoModel> criarPedido(@RequestBody PedidoModel pedidoModel){
        PedidoModel requeste = pedidoService.criarPedido(pedidoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(pedidoModel.getId()).toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedido(@PathVariable Long id){
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public PedidoModel buscarPedidoPorId(@PathVariable Long id){
        return pedidoService.buscarPedidoPorId(id);
    }

    @PutMapping("/{id}")
    public PedidoModel atualizarPedido(@PathVariable Long id, PedidoModel pedidoModel){
        return pedidoService.atualizarPedido(id, pedidoModel);
    }

}
