package com.example.demo.dao;

import com.example.demo.entity.HouseInfo;
import com.example.demo.entity.HouseInfoExample;
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

public interface HouseInfoMapper {
    @SelectProvider(type=HouseInfoSqlProvider.class, method="countByExample")
    long countByExample(HouseInfoExample example);

    @DeleteProvider(type=HouseInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(HouseInfoExample example);

    @Delete({
        "delete from house_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into house_info (house_id, village_id, ",
        "user_id, address_id, ",
        "agency_id, `location`, ",
        "complete_time, release_time, ",
        "area, `type`, unit_price, ",
        "first_price, total_price, ",
        "property_right)",
        "values (#{houseId,jdbcType=VARCHAR}, #{villageId,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=VARCHAR}, #{addressId,jdbcType=VARCHAR}, ",
        "#{agencyId,jdbcType=VARCHAR}, #{location,jdbcType=VARCHAR}, ",
        "#{completeTime,jdbcType=TIMESTAMP}, #{releaseTime,jdbcType=TIMESTAMP}, ",
        "#{area,jdbcType=INTEGER}, #{type,jdbcType=VARCHAR}, #{unitPrice,jdbcType=INTEGER}, ",
        "#{firstPrice,jdbcType=INTEGER}, #{totalPrice,jdbcType=INTEGER}, ",
        "#{propertyRight,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(HouseInfo record);

    @InsertProvider(type=HouseInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(HouseInfo record);

    @SelectProvider(type=HouseInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="house_id", property="houseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="village_id", property="villageId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.VARCHAR),
        @Result(column="agency_id", property="agencyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="complete_time", property="completeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="release_time", property="releaseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="area", property="area", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="unit_price", property="unitPrice", jdbcType=JdbcType.INTEGER),
        @Result(column="first_price", property="firstPrice", jdbcType=JdbcType.INTEGER),
        @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.INTEGER),
        @Result(column="property_right", property="propertyRight", jdbcType=JdbcType.INTEGER)
    })
    List<HouseInfo> selectByExample(HouseInfoExample example);

    @Select({
        "select",
        "id, house_id, village_id, user_id, address_id, agency_id, `location`, complete_time, ",
        "release_time, area, `type`, unit_price, first_price, total_price, property_right",
        "from house_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="house_id", property="houseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="village_id", property="villageId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.VARCHAR),
        @Result(column="agency_id", property="agencyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="complete_time", property="completeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="release_time", property="releaseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="area", property="area", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="unit_price", property="unitPrice", jdbcType=JdbcType.INTEGER),
        @Result(column="first_price", property="firstPrice", jdbcType=JdbcType.INTEGER),
        @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.INTEGER),
        @Result(column="property_right", property="propertyRight", jdbcType=JdbcType.INTEGER)
    })
    HouseInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HouseInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HouseInfo record, @Param("example") HouseInfoExample example);

    @UpdateProvider(type=HouseInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HouseInfo record, @Param("example") HouseInfoExample example);

    @UpdateProvider(type=HouseInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HouseInfo record);

    @Update({
        "update house_info",
        "set house_id = #{houseId,jdbcType=VARCHAR},",
          "village_id = #{villageId,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=VARCHAR},",
          "address_id = #{addressId,jdbcType=VARCHAR},",
          "agency_id = #{agencyId,jdbcType=VARCHAR},",
          "`location` = #{location,jdbcType=VARCHAR},",
          "complete_time = #{completeTime,jdbcType=TIMESTAMP},",
          "release_time = #{releaseTime,jdbcType=TIMESTAMP},",
          "area = #{area,jdbcType=INTEGER},",
          "`type` = #{type,jdbcType=VARCHAR},",
          "unit_price = #{unitPrice,jdbcType=INTEGER},",
          "first_price = #{firstPrice,jdbcType=INTEGER},",
          "total_price = #{totalPrice,jdbcType=INTEGER},",
          "property_right = #{propertyRight,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HouseInfo record);
}