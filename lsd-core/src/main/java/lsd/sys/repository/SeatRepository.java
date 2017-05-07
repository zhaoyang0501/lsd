package lsd.sys.repository;
import lsd.common.repository.SimpleCurdRepository;
import lsd.sys.entity.Seat;
public interface SeatRepository   extends SimpleCurdRepository<Seat ,Long>{

	Seat findByName(String name);
}
