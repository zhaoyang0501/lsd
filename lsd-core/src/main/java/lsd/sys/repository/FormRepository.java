package lsd.sys.repository;
import java.util.List;

import lsd.common.repository.SimpleCurdRepository;
import lsd.sys.entity.Form;
public interface FormRepository   extends SimpleCurdRepository<Form ,Long>{
	public List<Form> findByState(String state);
	public List<Form> findByStateOrderByCreateDateDesc(String state);
}
