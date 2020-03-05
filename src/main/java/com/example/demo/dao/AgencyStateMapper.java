package com.example.demo.dao;

import com.example.demo.entity.AgencyState;
import com.example.demo.entity.AgencyStateExample;
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

public interface AgencyStateMapper {
    @SelectProvider(type=AgencyStateSqlProvider.class, method="countByExample")
    long countByExample(AgencyStateExample example);

    @DeleteProvider(type=AgencyStateSqlProvider.class, method="deleteByExample")
    int deleteByExample(AgencyStateExample example);

    @Delete({
        "delete from agency_state",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into agency_state (state_id, agency_id, ",
        "`state`)",
        "values (#{stateId,jdbcType=VARCHAR}, #{agencyId,jdbcType=VARCHAR}, ",
        "#{state,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(AgencyState record);

    @InsertProvider(type=AgencyStateSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(AgencyState record);

    @SelectProvider(type=AgencyStateSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="state_id", property="stateId", jdbcType=JdbcType.VARCHAR),
        @Result(column="agency_id", property="agencyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER)
    })
    List<AgencyState> selectByExample(AgencyStateExample example);

    @Select({
        "select",
        "id, state_id, agency_id, `state`",
        "from agency_state",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="state_id", property="stateId", jdbcType=JdbcType.VARCHAR),
        @Result(column="agency_id", property="agencyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER)
    })
    AgencyState selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AgencyStateSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AgencyState record, @Param("example") AgencyStateExample example);

    @UpdateProvider(type=AgencyStateSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AgencyState record, @Param("example") AgencyStateExample example);

    @UpdateProvider(type=AgencyStateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AgencyState record);

    @Update({
        "update agency_state",
        "set state_id = #{stateId,jdbcType=VARCHAR},",
          "agency_id = #{agencyId,jdbcType=VARCHAR},",
          "`state` = #{state,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AgencyState record);
}