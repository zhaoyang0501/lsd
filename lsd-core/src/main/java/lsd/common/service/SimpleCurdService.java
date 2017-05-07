package lsd.common.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import lsd.common.entity.BaseEntity;
import lsd.common.repository.SimpleCurdRepository;
/***
 * 
 * @author pzy
 *
 * @param <M>
 * @param <ID>
 */
public class SimpleCurdService <M extends BaseEntity<?>, ID extends Serializable> {
	
	@Autowired
    protected SimpleCurdRepository<M, ID> simpleCurdRepository; 
	
	public M save(M m) {
	    return simpleCurdRepository.save(m);
	}
	
	public void delete(M m){
		simpleCurdRepository.delete(m);
	}
	
	public M find(ID id){
		  return simpleCurdRepository.findOne(id);
	}
	
	public List<M> findAll(){
		  return (List<M>) simpleCurdRepository.findAll();
	}
	public Page<M> findAll(final int pageNumber, final int pageSize,final String name,final String columnname){
         PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
         Specification<M> spec = new Specification<M>() {
              public Predicate toPredicate(Root<M> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              Predicate predicate = cb.conjunction();
              if (StringUtils.isNotBlank(name)) {
                   predicate.getExpressions().add(cb.like(root.get(columnname).as(String.class), "%"+name+"%"));
              }
              return predicate;
              }
         };
         Page<M> result = (Page<M>) simpleCurdRepository.findAll(spec, pageRequest);
         return result;
   } 
	
	public void delete(ID id){
		simpleCurdRepository.delete(id);
	}
}
