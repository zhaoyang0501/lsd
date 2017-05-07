package lsd.admin.web;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lsd.common.web.AbstractBaseCURDController;
import lsd.core.entity.Role;
import lsd.core.entity.User;
import lsd.sys.entity.FrontUser;
import lsd.sys.service.FrontUserService;



@Controller
@RequestMapping("sys/frontuser")
public class FrontUserController extends AbstractBaseCURDController<FrontUser,Long>  {
	
	@Override
	public FrontUserService getSimpleCurdService() {
		return (FrontUserService)super.getSimpleCurdService();
	}
	
	@Override
	public String getBasePath() {
		return "sys/frontuser";
	}
	
	@Override
	@RequestMapping("index")
	public String index(Model model) {
		return this.getBasePath()+"/index";
	}

	@ModelAttribute
	public FrontUser preget(@RequestParam(required=false) Long id,@RequestParam(required=false) String role) {
		FrontUser user = new FrontUser();
		if (id!=null){
			user = this.getSimpleCurdService().find(id);
		}
		return user;
	}
}
