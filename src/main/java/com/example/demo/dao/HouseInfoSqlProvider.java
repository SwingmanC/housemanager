package com.example.demo.dao;

import com.example.demo.entity.HouseInfo;
import com.example.demo.entity.HouseInfoExample.Criteria;
import com.example.demo.entity.HouseInfoExample.Criterion;
import com.example.demo.entity.HouseInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class HouseInfoSqlProvider {

    public String countByExample(HouseInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("house_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(HouseInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("house_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(HouseInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("house_info");
        
        if (record.getHouseId() != null) {
            sql.VALUES("house_id", "#{houseId,jdbcType=VARCHAR}");
        }
        
        if (record.getVillageId() != null) {
            sql.VALUES("village_id", "#{villageId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressId() != null) {
            sql.VALUES("address_id", "#{addressId,jdbcType=VARCHAR}");
        }
        
        if (record.getAgencyId() != null) {
            sql.VALUES("agency_id", "#{agencyId,jdbcType=VARCHAR}");
        }
        
        if (record.getLocation() != null) {
            sql.VALUES("`location`", "#{location,jdbcType=VARCHAR}");
        }
        
        if (record.getCompleteTime() != null) {
            sql.VALUES("complete_time", "#{completeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReleaseTime() != null) {
            sql.VALUES("release_time", "#{releaseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getArea() != null) {
            sql.VALUES("area", "#{area,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("`type`", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getUnitPrice() != null) {
            sql.VALUES("unit_price", "#{unitPrice,jdbcType=INTEGER}");
        }
        
        if (record.getFirstPrice() != null) {
            sql.VALUES("first_price", "#{firstPrice,jdbcType=INTEGER}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.VALUES("total_price", "#{totalPrice,jdbcType=INTEGER}");
        }
        
        if (record.getPropertyRight() != null) {
            sql.VALUES("property_right", "#{propertyRight,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(HouseInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("house_id");
        sql.SELECT("village_id");
        sql.SELECT("user_id");
        sql.SELECT("address_id");
        sql.SELECT("agency_id");
        sql.SELECT("`location`");
        sql.SELECT("complete_time");
        sql.SELECT("release_time");
        sql.SELECT("area");
        sql.SELECT("`type`");
        sql.SELECT("unit_price");
        sql.SELECT("first_price");
        sql.SELECT("total_price");
        sql.SELECT("property_right");
        sql.FROM("house_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        HouseInfo record = (HouseInfo) parameter.get("record");
        HouseInfoExample example = (HouseInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("house_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getHouseId() != null) {
            sql.SET("house_id = #{record.houseId,jdbcType=VARCHAR}");
        }
        
        if (record.getVillageId() != null) {
            sql.SET("village_id = #{record.villageId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressId() != null) {
            sql.SET("address_id = #{record.addressId,jdbcType=VARCHAR}");
        }
        
        if (record.getAgencyId() != null) {
            sql.SET("agency_id = #{record.agencyId,jdbcType=VARCHAR}");
        }
        
        if (record.getLocation() != null) {
            sql.SET("`location` = #{record.location,jdbcType=VARCHAR}");
        }
        
        if (record.getCompleteTime() != null) {
            sql.SET("complete_time = #{record.completeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReleaseTime() != null) {
            sql.SET("release_time = #{record.releaseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getArea() != null) {
            sql.SET("area = #{record.area,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getUnitPrice() != null) {
            sql.SET("unit_price = #{record.unitPrice,jdbcType=INTEGER}");
        }
        
        if (record.getFirstPrice() != null) {
            sql.SET("first_price = #{record.firstPrice,jdbcType=INTEGER}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.SET("total_price = #{record.totalPrice,jdbcType=INTEGER}");
        }
        
        if (record.getPropertyRight() != null) {
            sql.SET("property_right = #{record.propertyRight,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("house_info");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("house_id = #{record.houseId,jdbcType=VARCHAR}");
        sql.SET("village_id = #{record.villageId,jdbcType=VARCHAR}");
        sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        sql.SET("address_id = #{record.addressId,jdbcType=VARCHAR}");
        sql.SET("agency_id = #{record.agencyId,jdbcType=VARCHAR}");
        sql.SET("`location` = #{record.location,jdbcType=VARCHAR}");
        sql.SET("complete_time = #{record.completeTime,jdbcType=TIMESTAMP}");
        sql.SET("release_time = #{record.releaseTime,jdbcType=TIMESTAMP}");
        sql.SET("area = #{record.area,jdbcType=INTEGER}");
        sql.SET("`type` = #{record.type,jdbcType=VARCHAR}");
        sql.SET("unit_price = #{record.unitPrice,jdbcType=INTEGER}");
        sql.SET("first_price = #{record.firstPrice,jdbcType=INTEGER}");
        sql.SET("total_price = #{record.totalPrice,jdbcType=INTEGER}");
        sql.SET("property_right = #{record.propertyRight,jdbcType=INTEGER}");
        
        HouseInfoExample example = (HouseInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(HouseInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("house_info");
        
        if (record.getHouseId() != null) {
            sql.SET("house_id = #{houseId,jdbcType=VARCHAR}");
        }
        
        if (record.getVillageId() != null) {
            sql.SET("village_id = #{villageId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressId() != null) {
            sql.SET("address_id = #{addressId,jdbcType=VARCHAR}");
        }
        
        if (record.getAgencyId() != null) {
            sql.SET("agency_id = #{agencyId,jdbcType=VARCHAR}");
        }
        
        if (record.getLocation() != null) {
            sql.SET("`location` = #{location,jdbcType=VARCHAR}");
        }
        
        if (record.getCompleteTime() != null) {
            sql.SET("complete_time = #{completeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReleaseTime() != null) {
            sql.SET("release_time = #{releaseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getArea() != null) {
            sql.SET("area = #{area,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getUnitPrice() != null) {
            sql.SET("unit_price = #{unitPrice,jdbcType=INTEGER}");
        }
        
        if (record.getFirstPrice() != null) {
            sql.SET("first_price = #{firstPrice,jdbcType=INTEGER}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.SET("total_price = #{totalPrice,jdbcType=INTEGER}");
        }
        
        if (record.getPropertyRight() != null) {
            sql.SET("property_right = #{propertyRight,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, HouseInfoExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}