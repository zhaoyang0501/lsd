package lsd.common.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
@NoRepositoryBean
public interface SimpleCurdRepository<M, ID extends Serializable> extends PagingAndSortingRepository<M, ID>,JpaSpecificationExecutor<M> {
}
