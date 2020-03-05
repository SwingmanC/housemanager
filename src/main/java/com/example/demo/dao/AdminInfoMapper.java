package com.example.demo.dao;

import com.example.demo.entity.AdminInfo;
import com.example.demo.entity.AdminInfoExample;
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

public interface AdminInfoMapper {
    @SelectProvider(type=AdminInfoSqlProvider.class, method="countByExample")
    long countByExample(AdminInfoExample example);

    @DeleteProvider(type=AdminInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(AdminInfoExample example);

    @Delete({
        "delete from admin_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into admin_info (admin_id, `name`, ",
        "`password`, age, telephone, ",
        "email)",
        "values (#{adminId,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, #{telephone,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(AdminInfo record);

    @InsertProvider(type=AdminInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(AdminInfo record);

    @SelectProvider(type=AdminInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR)
    })
    List<AdminInfo> selectByExample(AdminInfoExample example);

    @Select({
        "select",
        "id, admin_id, `name`, `password`, age, telephone, email",
        "from admin_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR)
    })
    AdminInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AdminInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AdminInfo record, @Param("example") AdminInfoExample example);

    @UpdateProvider(type=AdminInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AdminInfo record, @Param("example") AdminInfoExample example);

    @UpdateProvider(type=AdminInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdminInfo record);

    @Update({
        "update admin_info",
        "set admin_id = #{adminId,jdbcType=VARCHAR},",
          "`name` = #{name,jdbcType=VARCHAR},",
          "`password` = #{password,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "telephone = #{telephone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AdminInfo record);
}