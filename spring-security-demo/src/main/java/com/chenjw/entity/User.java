package com.chenjw.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
* 
* @TableName user
*/
@Data
public class User implements Serializable, UserDetails {

    private Integer id;
    private String userName;
    private String password;
    private boolean enable;
    private boolean locked;

    private List<Role> userRoles;

    /**
     * 获取权限
     * 获取当前用户对象所具有的角色信息
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Role role : userRoles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    /**
     * 获取当前用户对象的用户名
     * @return
     */
    @Override
    public String getUsername() {
        return this.userName;
    }

    /**
     * 获取当前用户对象的密码
     * @return
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * 当前账户是否未过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 当前账户是否未锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    /**
     * 当前账户密码是否未过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 当前账户是否可用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return enable;
    }
}
