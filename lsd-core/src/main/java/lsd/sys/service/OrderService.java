package lsd.sys.service;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import lsd.common.service.SimpleCurdService;
import lsd.sys.entity.FrontUser;
import lsd.sys.entity.Order;
import lsd.sys.repository.OrderRepository;
@Service
public class OrderService extends SimpleCurdService<Order, Long> {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Page<Order> findAll(final int pageNumber, final int pageSize,final Date orderDate){
        PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
        Specification<Order> spec = new Specification<Order>() {
             public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
             Predicate predicate = cb.conjunction();
             if (orderDate!=null) {
                  predicate.getExpressions().add(cb.equal(root.get("orderDate").as(Date.class),orderDate));
             }
             return predicate;
             }
        };
        Page<Order> result = (Page<Order>) simpleCurdRepository.findAll(spec, pageRequest);
        return result;
  }

	public List<Order> findByFrontUser(FrontUser user) {
		return this.orderRepository.findByFrontUser(user);
	} 
}
