package com.example.demo.dao;

import com.example.demo.entity.UserInfo;
import com.example.demo.entity.UserInfoExample;
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

public interface UserInfoMapper {
    @SelectProvider(type=UserInfoSqlProvider.class, method="countByExample")
    long countByExample(UserInfoExample example);

    @DeleteProvider(type=UserInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserInfoExample example);

    @Delete({
        "delete from user_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user_info (user_id, `name`, ",
        "`password`, age, card_id, ",
        "telephone, email, ",
        "address, `state`)",
        "values (#{userId,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, #{cardId,jdbcType=VARCHAR}, ",
        "#{telephone,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{state,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(UserInfo record);

    @InsertProvider(type=UserInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(UserInfo record);

    @SelectProvider(type=UserInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER)
    })
    List<UserInfo> selectByExample(UserInfoExample example);

    @Select({
        "select",
        "id, user_id, `name`, `password`, age, card_id, telephone, email, address, `state`",
        "from user_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER)
    })
    UserInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserInfo record);

    @Update({
        "update user_info",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "`name` = #{name,jdbcType=VARCHAR},",
          "`password` = #{password,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "card_id = #{cardId,jdbcType=VARCHAR},",
          "telephone = #{telephone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "`state` = #{state,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserInfo record);
}