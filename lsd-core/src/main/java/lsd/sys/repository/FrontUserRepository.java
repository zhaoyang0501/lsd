package lsd.sys.repository;
import lsd.common.repository.SimpleCurdRepository;
import lsd.sys.entity.FrontUser;
public interface FrontUserRepository   extends SimpleCurdRepository<FrontUser ,Long>{
	FrontUser findByUsernameAndPassword(String username, String password);
	FrontUser findByUsername(String username);
}
