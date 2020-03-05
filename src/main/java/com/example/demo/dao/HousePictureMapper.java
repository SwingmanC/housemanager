package com.example.demo.dao;

import com.example.demo.entity.HousePicture;
import com.example.demo.entity.HousePictureExample;
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

public interface HousePictureMapper {
    @SelectProvider(type=HousePictureSqlProvider.class, method="countByExample")
    long countByExample(HousePictureExample example);

    @DeleteProvider(type=HousePictureSqlProvider.class, method="deleteByExample")
    int deleteByExample(HousePictureExample example);

    @Delete({
        "delete from house_picture",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into house_picture (picture_id, house_id, ",
        "picture_url)",
        "values (#{pictureId,jdbcType=VARCHAR}, #{houseId,jdbcType=VARCHAR}, ",
        "#{pictureUrl,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(HousePicture record);

    @InsertProvider(type=HousePictureSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(HousePicture record);

    @SelectProvider(type=HousePictureSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="picture_id", property="pictureId", jdbcType=JdbcType.VARCHAR),
        @Result(column="house_id", property="houseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="picture_url", property="pictureUrl", jdbcType=JdbcType.VARCHAR)
    })
    List<HousePicture> selectByExample(HousePictureExample example);

    @Select({
        "select",
        "id, picture_id, house_id, picture_url",
        "from house_picture",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="picture_id", property="pictureId", jdbcType=JdbcType.VARCHAR),
        @Result(column="house_id", property="houseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="picture_url", property="pictureUrl", jdbcType=JdbcType.VARCHAR)
    })
    HousePicture selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HousePictureSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HousePicture record, @Param("example") HousePictureExample example);

    @UpdateProvider(type=HousePictureSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HousePicture record, @Param("example") HousePictureExample example);

    @UpdateProvider(type=HousePictureSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HousePicture record);

    @Update({
        "update house_picture",
        "set picture_id = #{pictureId,jdbcType=VARCHAR},",
          "house_id = #{houseId,jdbcType=VARCHAR},",
          "picture_url = #{pictureUrl,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HousePicture record);
}