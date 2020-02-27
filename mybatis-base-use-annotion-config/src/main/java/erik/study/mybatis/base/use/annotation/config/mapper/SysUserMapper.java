package erik.study.mybatis.base.use.annotation.config.mapper;

import erik.study.mybatis.base.use.annotation.config.entity.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @author erik.wang
 * @date 2020-02-26 20:39
 * @description
 */
public interface SysUserMapper {


    @Select({"select id, user_name as name, user_password as password, user_email as email ,user_info as info, head_img as headImg, create_time as createTime" +
            " from sys_user where id = #{id}"})
    SysUser selectById(@Param("id") Long id);


    //  这里标记一个id，在其他select方法的select注解上也能用，比如selectByName
    @Results(id = "sysUserMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "user_name", property = "name"),
            @Result(column = "user_password", property = "password"),
            @Result(column = "user_email", property = "email"),
            @Result(column = "user_info", property = "info"),
            @Result(column = "head_img", property = "headImg"),
            @Result(column = "create_time", property = "createTime"),
    })
    @Select("select * from sys_user")
    List<SysUser> selectAll();

    @ResultMap("sysUserMap")
    @Select("select * from sys_user where user_name = #{userName}")
    List<SysUser> selectByName(@Param("userName") String userName);


    @SelectProvider(type = SysUserProvider.class, method = "selectByPassword")
    List<SysUser> selectByPassword(String password);


    class SysUserProvider {
        public String selectByPassword(@Param("password") String password) {
            return new SQL() {
                {
                    SELECT("id, user_name as name, user_password as password, user_email as email ,user_info as info, head_img as headImg, create_time as createTime");
                    FROM("sys_user");
                    WHERE("user_password = #{password}");
                }
            }.toString();
        }
    }

}
