package edu.mum.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityGraph;

import org.springframework.stereotype.Repository;

import edu.mum.dao.OrderDao;
import edu.mum.domain.Order;

@SuppressWarnings("unchecked")
@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

	public OrderDaoImpl() {
		super.setDaoType(Order.class);
	}

	public Order findByGraph(Long id) {
		EntityGraph<Order> graph = (EntityGraph<Order>) entityManager.getEntityGraph("graph.Order.items");

		Map<String, EntityGraph<Order>> hints = new HashMap<>();
		hints.put("javax.persistence.fetchgraph", graph);

		Order order = this.findOne(id);
		return order;

	}

}