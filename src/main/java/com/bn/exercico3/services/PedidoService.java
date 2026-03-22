package com.bn.exercico3.services;

import com.bn.exercico3.models.PedidoModel;
import com.bn.exercico3.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoModel> findAll(){
        return pedidoRepository.findAll();
    }

    public PedidoModel criarPedido(PedidoModel pedidoModel){
        return pedidoRepository.save(pedidoModel);
    }

    public void deletarPedido(Long id){
        pedidoRepository.deleteById(id);
    }

    public PedidoModel buscarPedidoPorId(Long id){
        return pedidoRepository.findById(id).get();
    }

    public PedidoModel atualizarPedido(Long id, PedidoModel pedidoModel){
        PedidoModel novoPedido = pedidoRepository.findById(id).get();
        novoPedido.setData(pedidoModel.getData());
        novoPedido.setValorTotal(pedidoModel.getValorTotal());
        novoPedido.setStatus(pedidoModel.getStatus());
        return pedidoRepository.save(novoPedido);
    }
}
