package com.example.demo.dao;

import com.example.demo.entity.HouseState;
import com.example.demo.entity.HouseStateExample;
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

public interface HouseStateMapper {
    @SelectProvider(type=HouseStateSqlProvider.class, method="countByExample")
    long countByExample(HouseStateExample example);

    @DeleteProvider(type=HouseStateSqlProvider.class, method="deleteByExample")
    int deleteByExample(HouseStateExample example);

    @Delete({
        "delete from house_state",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into house_state (state_id, house_id, ",
        "`state`)",
        "values (#{stateId,jdbcType=VARCHAR}, #{houseId,jdbcType=VARCHAR}, ",
        "#{state,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(HouseState record);

    @InsertProvider(type=HouseStateSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(HouseState record);

    @SelectProvider(type=HouseStateSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="state_id", property="stateId", jdbcType=JdbcType.VARCHAR),
        @Result(column="house_id", property="houseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER)
    })
    List<HouseState> selectByExample(HouseStateExample example);

    @Select({
        "select",
        "id, state_id, house_id, `state`",
        "from house_state",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="state_id", property="stateId", jdbcType=JdbcType.VARCHAR),
        @Result(column="house_id", property="houseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER)
    })
    HouseState selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HouseStateSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HouseState record, @Param("example") HouseStateExample example);

    @UpdateProvider(type=HouseStateSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HouseState record, @Param("example") HouseStateExample example);

    @UpdateProvider(type=HouseStateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HouseState record);

    @Update({
        "update house_state",
        "set state_id = #{stateId,jdbcType=VARCHAR},",
          "house_id = #{houseId,jdbcType=VARCHAR},",
          "`state` = #{state,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HouseState record);
}