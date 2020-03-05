package com.example.demo.dao;

import com.example.demo.entity.AgencyInfo;
import com.example.demo.entity.AgencyInfoExample;
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

public interface AgencyInfoMapper {
    @SelectProvider(type=AgencyInfoSqlProvider.class, method="countByExample")
    long countByExample(AgencyInfoExample example);

    @DeleteProvider(type=AgencyInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(AgencyInfoExample example);

    @Delete({
        "delete from agency_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into agency_info (agency_id, address_id, ",
        "`location`, `name`, ",
        "email, telephone)",
        "values (#{agencyId,jdbcType=VARCHAR}, #{addressId,jdbcType=VARCHAR}, ",
        "#{location,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{telephone,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(AgencyInfo record);

    @InsertProvider(type=AgencyInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(AgencyInfo record);

    @SelectProvider(type=AgencyInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="agency_id", property="agencyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR)
    })
    List<AgencyInfo> selectByExample(AgencyInfoExample example);

    @Select({
        "select",
        "id, agency_id, address_id, `location`, `name`, email, telephone",
        "from agency_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="agency_id", property="agencyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR)
    })
    AgencyInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AgencyInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AgencyInfo record, @Param("example") AgencyInfoExample example);

    @UpdateProvider(type=AgencyInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AgencyInfo record, @Param("example") AgencyInfoExample example);

    @UpdateProvider(type=AgencyInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AgencyInfo record);

    @Update({
        "update agency_info",
        "set agency_id = #{agencyId,jdbcType=VARCHAR},",
          "address_id = #{addressId,jdbcType=VARCHAR},",
          "`location` = #{location,jdbcType=VARCHAR},",
          "`name` = #{name,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "telephone = #{telephone,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AgencyInfo record);
}