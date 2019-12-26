package erik.study.mybatis.mapper.common.mapper;


import erik.study.mybatis.mapper.common.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysUserMapper {

    @Select(value = "select * from sys_user where id = #{id}")
    SysUser selectUserById(@Param("id") Long id);

    SysUser selectUserAndRoleById(Long id);

    SysUser selectUserAndRoleById2(Long id);

    SysUser selectUserAndRolesById(Long id);


    int insert(SysUser sysUser);

    int update(SysUser sysUser);

}
