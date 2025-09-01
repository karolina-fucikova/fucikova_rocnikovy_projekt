package cz.upce.waterjoy.repository;

import cz.upce.waterjoy.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    // Základní CRUD metody jsou automaticky k dispozici:
    // save(), findById(), findAll(), deleteById(), atd.
}
