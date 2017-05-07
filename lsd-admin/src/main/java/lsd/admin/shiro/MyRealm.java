package lsd.admin.shiro;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import lsd.core.entity.Role;
import lsd.core.entity.User;
import lsd.core.service.UserService;

public class MyRealm extends AuthorizingRealm {  
	private static final Logger log = LoggerFactory.getLogger(MyRealm.class);
	
	@Autowired
	private UserService userService; 
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String currentUsername = (String) super.getAvailablePrincipal(principals);
		User user = userService.findByUsername(currentUsername);
		List<String> roleList = new ArrayList<String>();
		List<String> permissionList = new ArrayList<String>();
		if(!CollectionUtils.isEmpty(user.getRoles())){
			for (Role role : user.getRoles()) {
				roleList.add(role.getCode());
			}
		}
		
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		simpleAuthorInfo.addRoles(roleList);
		simpleAuthorInfo.addStringPermissions(permissionList);
		return simpleAuthorInfo;
	} 
   
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws ShiroException {  
    	

    	UsernamePasswordToken token = (UsernamePasswordToken)authcToken;  
    	log.info("user{},password {}login",token.getUsername(),token.getPassword());
        User user=userService.findByUsername(token.getUsername());
        if(user!=null){
        	 AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), user.getUsername());  
        	 SecurityUtils.getSubject().getSession().setAttribute("currentUser", user);
             return authcInfo;  
        }else{
        	  throw new UnknownAccountException();
        }
    }
}