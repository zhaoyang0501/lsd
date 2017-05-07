package lsd.admin.shiro;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;


/** 
* 自定义 密码验证类 md5 
* @author pzy
* 
*/ 

public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {  
    @Override  
       public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {  
           UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  
           Object tokenCredentials = DigestUtils.md5Hex(String.valueOf(token.getPassword()));  
           Object accountCredentials = getCredentials(info);  
           return equals(tokenCredentials, accountCredentials);  
       }  
}