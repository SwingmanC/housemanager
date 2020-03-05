package com.example.demo.dao;

import com.example.demo.entity.VillageInfo;
import com.example.demo.entity.VillageInfoExample.Criteria;
import com.example.demo.entity.VillageInfoExample.Criterion;
import com.example.demo.entity.VillageInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class VillageInfoSqlProvider {

    public String countByExample(VillageInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("village_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(VillageInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("village_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(VillageInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("village_info");
        
        if (record.getVillageId() != null) {
            sql.VALUES("village_id", "#{villageId,jdbcType=VARCHAR}");
        }
        
        if (record.getSupport() != null) {
            sql.VALUES("support", "#{support,jdbcType=VARCHAR}");
        }
        
        if (record.getApartment() != null) {
            sql.VALUES("apartment", "#{apartment,jdbcType=VARCHAR}");
        }
        
        if (record.getFuturePlan() != null) {
            sql.VALUES("future_plan", "#{futurePlan,jdbcType=VARCHAR}");
        }
        
        if (record.getAveragePrice() != null) {
            sql.VALUES("average_price", "#{averagePrice,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getGreenRate() != null) {
            sql.VALUES("green_rate", "#{greenRate,jdbcType=INTEGER}");
        }
        
        if (record.getVolumeRate() != null) {
            sql.VALUES("volume_rate", "#{volumeRate,jdbcType=INTEGER}");
        }
        
        if (record.getParkingLot() != null) {
            sql.VALUES("parking_lot", "#{parkingLot,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(VillageInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("village_id");
        sql.SELECT("support");
        sql.SELECT("apartment");
        sql.SELECT("future_plan");
        sql.SELECT("average_price");
        sql.SELECT("address");
        sql.SELECT("green_rate");
        sql.SELECT("volume_rate");
        sql.SELECT("parking_lot");
        sql.FROM("village_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        VillageInfo record = (VillageInfo) parameter.get("record");
        VillageInfoExample example = (VillageInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("village_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getVillageId() != null) {
            sql.SET("village_id = #{record.villageId,jdbcType=VARCHAR}");
        }
        
        if (record.getSupport() != null) {
            sql.SET("support = #{record.support,jdbcType=VARCHAR}");
        }
        
        if (record.getApartment() != null) {
            sql.SET("apartment = #{record.apartment,jdbcType=VARCHAR}");
        }
        
        if (record.getFuturePlan() != null) {
            sql.SET("future_plan = #{record.futurePlan,jdbcType=VARCHAR}");
        }
        
        if (record.getAveragePrice() != null) {
            sql.SET("average_price = #{record.averagePrice,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getGreenRate() != null) {
            sql.SET("green_rate = #{record.greenRate,jdbcType=INTEGER}");
        }
        
        if (record.getVolumeRate() != null) {
            sql.SET("volume_rate = #{record.volumeRate,jdbcType=INTEGER}");
        }
        
        if (record.getParkingLot() != null) {
            sql.SET("parking_lot = #{record.parkingLot,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("village_info");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("village_id = #{record.villageId,jdbcType=VARCHAR}");
        sql.SET("support = #{record.support,jdbcType=VARCHAR}");
        sql.SET("apartment = #{record.apartment,jdbcType=VARCHAR}");
        sql.SET("future_plan = #{record.futurePlan,jdbcType=VARCHAR}");
        sql.SET("average_price = #{record.averagePrice,jdbcType=INTEGER}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("green_rate = #{record.greenRate,jdbcType=INTEGER}");
        sql.SET("volume_rate = #{record.volumeRate,jdbcType=INTEGER}");
        sql.SET("parking_lot = #{record.parkingLot,jdbcType=INTEGER}");
        
        VillageInfoExample example = (VillageInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(VillageInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("village_info");
        
        if (record.getVillageId() != null) {
            sql.SET("village_id = #{villageId,jdbcType=VARCHAR}");
        }
        
        if (record.getSupport() != null) {
            sql.SET("support = #{support,jdbcType=VARCHAR}");
        }
        
        if (record.getApartment() != null) {
            sql.SET("apartment = #{apartment,jdbcType=VARCHAR}");
        }
        
        if (record.getFuturePlan() != null) {
            sql.SET("future_plan = #{futurePlan,jdbcType=VARCHAR}");
        }
        
        if (record.getAveragePrice() != null) {
            sql.SET("average_price = #{averagePrice,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getGreenRate() != null) {
            sql.SET("green_rate = #{greenRate,jdbcType=INTEGER}");
        }
        
        if (record.getVolumeRate() != null) {
            sql.SET("volume_rate = #{volumeRate,jdbcType=INTEGER}");
        }
        
        if (record.getParkingLot() != null) {
            sql.SET("parking_lot = #{parkingLot,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, VillageInfoExample example, boolean includeExamplePhrase) {
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