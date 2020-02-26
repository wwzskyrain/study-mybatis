package erik.study.mybatis.base.use.xml.config.mapper;

import erik.study.mybatis.base.use.xml.config.entity.Country;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author erik.wang
 * @date 2020-02-26 17:57
 * @description
 */
public interface CountryMapper {

    List<Country> selectAll();

    Country selectById(@Param("id") Long id);

}
