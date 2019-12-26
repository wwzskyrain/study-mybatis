package erik.study.mybatis.mapper.spring.mapper;

import erik.study.mybatis.mapper.common.model.Country;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * @author erik.wang
 * @date 2019/05/04
 **/
public interface CountryMapper {

//    @Select(value = "select * from country where id = #{id} and country_code = #{countryCode}")
    Country selectOneByIdAndCode(@Param("id") Integer id, @Param("countryCode") String code);

}
