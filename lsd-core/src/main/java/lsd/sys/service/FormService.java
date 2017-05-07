package lsd.sys.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lsd.common.service.SimpleCurdService;
import lsd.sys.entity.Form;
import lsd.sys.repository.FormRepository;
@Service
public class FormService extends SimpleCurdService<Form, Long> {
	
	@Autowired
	private FormRepository formRepository;
	
	public List<Form> findByState(String state){
		return this.formRepository.findByStateOrderByCreateDateDesc(state);
	}
}
