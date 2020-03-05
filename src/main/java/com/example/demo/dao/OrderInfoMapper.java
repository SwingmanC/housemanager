package com.example.demo.dao;

import com.example.demo.entity.OrderInfo;
import com.example.demo.entity.OrderInfoExample;
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

public interface OrderInfoMapper {
    @SelectProvider(type=OrderInfoSqlProvider.class, method="countByExample")
    long countByExample(OrderInfoExample example);

    @DeleteProvider(type=OrderInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderInfoExample example);

    @Delete({
        "delete from order_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into order_info (order_id, user_id, ",
        "house_id, agency_id, ",
        "create_time, price)",
        "values (#{orderId,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
        "#{houseId,jdbcType=VARCHAR}, #{agencyId,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{price,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OrderInfo record);

    @InsertProvider(type=OrderInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OrderInfo record);

    @SelectProvider(type=OrderInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="house_id", property="houseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="agency_id", property="agencyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER)
    })
    List<OrderInfo> selectByExample(OrderInfoExample example);

    @Select({
        "select",
        "id, order_id, user_id, house_id, agency_id, create_time, price",
        "from order_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="house_id", property="houseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="agency_id", property="agencyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER)
    })
    OrderInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OrderInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    @UpdateProvider(type=OrderInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    @UpdateProvider(type=OrderInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderInfo record);

    @Update({
        "update order_info",
        "set order_id = #{orderId,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=VARCHAR},",
          "house_id = #{houseId,jdbcType=VARCHAR},",
          "agency_id = #{agencyId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "price = #{price,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrderInfo record);
}