package lsd.sys.repository;
import java.util.List;

import lsd.common.repository.SimpleCurdRepository;
import lsd.sys.entity.FrontUser;
import lsd.sys.entity.Order;
public interface OrderRepository   extends SimpleCurdRepository<Order ,Long>{
	public List<Order> findByFrontUser(FrontUser user);
}
