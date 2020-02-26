package erik.study.mybatis.base.use.xml.config.mapper;

import erik.study.mybatis.base.use.xml.config.entity.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author erik.wang
 * @date 2020-02-26 20:39
 * @description
 */
public interface SysUserMapper {

    SysUser selectById(@Param("id") Long id);


}
