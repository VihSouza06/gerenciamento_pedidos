package com.bn.exercico3.repositories;

import com.bn.exercico3.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {

}
