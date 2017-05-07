package lsd.sys.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lsd.common.service.SimpleCurdService;
import lsd.sys.entity.Seat;
import lsd.sys.repository.SeatRepository;
@Service
public class SeatService extends SimpleCurdService<Seat, Long> {
	
	@Autowired
	private SeatRepository seatRepository;
	
	public Seat findByName(String name){
		return seatRepository.findByName(name);
	}
}
