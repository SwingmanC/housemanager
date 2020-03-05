package com.example.demo.dao;

import com.example.demo.entity.AddressInfo;
import com.example.demo.entity.AddressInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AddressInfoMapper {
    @SelectProvider(type=AddressInfoSqlProvider.class, method="countByExample")
    long countByExample(AddressInfoExample example);

    @DeleteProvider(type=AddressInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(AddressInfoExample example);

    @Delete({
        "delete from address_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into address_info (address_id, province, ",
        "city, region)",
        "values (#{addressId,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{region,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(AddressInfo record);

    @InsertProvider(type=AddressInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(AddressInfo record);

    @SelectProvider(type=AddressInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="region", property="region", jdbcType=JdbcType.VARCHAR)
    })
    List<AddressInfo> selectByExample(AddressInfoExample example);

    @Select({
        "select",
        "id, address_id, province, city, region",
        "from address_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="region", property="region", jdbcType=JdbcType.VARCHAR)
    })
    AddressInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AddressInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AddressInfo record, @Param("example") AddressInfoExample example);

    @UpdateProvider(type=AddressInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AddressInfo record, @Param("example") AddressInfoExample example);

    @UpdateProvider(type=AddressInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AddressInfo record);

    @Update({
        "update address_info",
        "set address_id = #{addressId,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "region = #{region,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AddressInfo record);
}