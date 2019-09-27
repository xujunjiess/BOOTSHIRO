package com.lanxin.shiro;

import com.lanxin.dao.UserDao;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2019/9/26.
 */
//自定义reamlm认证
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserDao userDao;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        String username=String.valueOf(principalCollection.getPrimaryPrincipal());
        List<String> roles=userDao.selectrolesByusername(username);
        List<String> perms=userDao.selectpermByusername(username);
        simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(perms);

        return simpleAuthorizationInfo;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=String.valueOf(authenticationToken.getPrincipal());
        String password=userDao.selectpassByusername(username);
        if(password!=null){
            SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(username,password,"");
            //simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("lanxin"));//设置加盐
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
