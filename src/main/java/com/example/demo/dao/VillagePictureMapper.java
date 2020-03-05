package com.example.demo.dao;

import com.example.demo.entity.VillagePicture;
import com.example.demo.entity.VillagePictureExample;
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

public interface VillagePictureMapper {
    @SelectProvider(type=VillagePictureSqlProvider.class, method="countByExample")
    long countByExample(VillagePictureExample example);

    @DeleteProvider(type=VillagePictureSqlProvider.class, method="deleteByExample")
    int deleteByExample(VillagePictureExample example);

    @Delete({
        "delete from village_picture",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into village_picture (picture_id, village_id, ",
        "picture_url)",
        "values (#{pictureId,jdbcType=VARCHAR}, #{villageId,jdbcType=VARCHAR}, ",
        "#{pictureUrl,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(VillagePicture record);

    @InsertProvider(type=VillagePictureSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(VillagePicture record);

    @SelectProvider(type=VillagePictureSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="picture_id", property="pictureId", jdbcType=JdbcType.VARCHAR),
        @Result(column="village_id", property="villageId", jdbcType=JdbcType.VARCHAR),
        @Result(column="picture_url", property="pictureUrl", jdbcType=JdbcType.VARCHAR)
    })
    List<VillagePicture> selectByExample(VillagePictureExample example);

    @Select({
        "select",
        "id, picture_id, village_id, picture_url",
        "from village_picture",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="picture_id", property="pictureId", jdbcType=JdbcType.VARCHAR),
        @Result(column="village_id", property="villageId", jdbcType=JdbcType.VARCHAR),
        @Result(column="picture_url", property="pictureUrl", jdbcType=JdbcType.VARCHAR)
    })
    VillagePicture selectByPrimaryKey(Integer id);

    @UpdateProvider(type=VillagePictureSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VillagePicture record, @Param("example") VillagePictureExample example);

    @UpdateProvider(type=VillagePictureSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VillagePicture record, @Param("example") VillagePictureExample example);

    @UpdateProvider(type=VillagePictureSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VillagePicture record);

    @Update({
        "update village_picture",
        "set picture_id = #{pictureId,jdbcType=VARCHAR},",
          "village_id = #{villageId,jdbcType=VARCHAR},",
          "picture_url = #{pictureUrl,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(VillagePicture record);
}