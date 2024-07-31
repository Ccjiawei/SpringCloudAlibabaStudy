package com.chenjw.mapper;

import com.chenjw.entity.Role;
import com.chenjw.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where user_name = #{userName}")
    User loadUserByUsername(@Param("userName") String username);

    @Select("select * from  role r, user_role ur where  r.id = ur.role_id and  ur.user_id = #{id}")
    List<Role> getUserRolesByUid(@Param("id") Integer id);

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") Integer id);

}
