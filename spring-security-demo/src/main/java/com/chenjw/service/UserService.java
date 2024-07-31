package com.chenjw.service;

import com.chenjw.entity.User;
import com.chenjw.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("==============UserService=================");
        User user = userMapper.loadUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("账户不存在");
        }

        String encodePassword = passwordEncoder.encode(user.getPassword());
        System.out.println("加密后的密码："+encodePassword);

        user.setPassword(encodePassword);
        user.setUserRoles(userMapper.getUserRolesByUid(user.getId()));
        return user;
    }

    public User getUserById(Integer id){
        return userMapper.getUserById(id);
    }
}
