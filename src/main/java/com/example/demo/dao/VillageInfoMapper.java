package com.example.demo.dao;

import com.example.demo.entity.VillageInfo;
import com.example.demo.entity.VillageInfoExample;
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

public interface VillageInfoMapper {
    @SelectProvider(type=VillageInfoSqlProvider.class, method="countByExample")
    long countByExample(VillageInfoExample example);

    @DeleteProvider(type=VillageInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(VillageInfoExample example);

    @Delete({
        "delete from village_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into village_info (village_id, support, ",
        "apartment, future_plan, ",
        "average_price, address, ",
        "green_rate, volume_rate, ",
        "parking_lot)",
        "values (#{villageId,jdbcType=VARCHAR}, #{support,jdbcType=VARCHAR}, ",
        "#{apartment,jdbcType=VARCHAR}, #{futurePlan,jdbcType=VARCHAR}, ",
        "#{averagePrice,jdbcType=INTEGER}, #{address,jdbcType=VARCHAR}, ",
        "#{greenRate,jdbcType=INTEGER}, #{volumeRate,jdbcType=INTEGER}, ",
        "#{parkingLot,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(VillageInfo record);

    @InsertProvider(type=VillageInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(VillageInfo record);

    @SelectProvider(type=VillageInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="village_id", property="villageId", jdbcType=JdbcType.VARCHAR),
        @Result(column="support", property="support", jdbcType=JdbcType.VARCHAR),
        @Result(column="apartment", property="apartment", jdbcType=JdbcType.VARCHAR),
        @Result(column="future_plan", property="futurePlan", jdbcType=JdbcType.VARCHAR),
        @Result(column="average_price", property="averagePrice", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="green_rate", property="greenRate", jdbcType=JdbcType.INTEGER),
        @Result(column="volume_rate", property="volumeRate", jdbcType=JdbcType.INTEGER),
        @Result(column="parking_lot", property="parkingLot", jdbcType=JdbcType.INTEGER)
    })
    List<VillageInfo> selectByExample(VillageInfoExample example);

    @Select({
        "select",
        "id, village_id, support, apartment, future_plan, average_price, address, green_rate, ",
        "volume_rate, parking_lot",
        "from village_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="village_id", property="villageId", jdbcType=JdbcType.VARCHAR),
        @Result(column="support", property="support", jdbcType=JdbcType.VARCHAR),
        @Result(column="apartment", property="apartment", jdbcType=JdbcType.VARCHAR),
        @Result(column="future_plan", property="futurePlan", jdbcType=JdbcType.VARCHAR),
        @Result(column="average_price", property="averagePrice", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="green_rate", property="greenRate", jdbcType=JdbcType.INTEGER),
        @Result(column="volume_rate", property="volumeRate", jdbcType=JdbcType.INTEGER),
        @Result(column="parking_lot", property="parkingLot", jdbcType=JdbcType.INTEGER)
    })
    VillageInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=VillageInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VillageInfo record, @Param("example") VillageInfoExample example);

    @UpdateProvider(type=VillageInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VillageInfo record, @Param("example") VillageInfoExample example);

    @UpdateProvider(type=VillageInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VillageInfo record);

    @Update({
        "update village_info",
        "set village_id = #{villageId,jdbcType=VARCHAR},",
          "support = #{support,jdbcType=VARCHAR},",
          "apartment = #{apartment,jdbcType=VARCHAR},",
          "future_plan = #{futurePlan,jdbcType=VARCHAR},",
          "average_price = #{averagePrice,jdbcType=INTEGER},",
          "address = #{address,jdbcType=VARCHAR},",
          "green_rate = #{greenRate,jdbcType=INTEGER},",
          "volume_rate = #{volumeRate,jdbcType=INTEGER},",
          "parking_lot = #{parkingLot,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(VillageInfo record);
}