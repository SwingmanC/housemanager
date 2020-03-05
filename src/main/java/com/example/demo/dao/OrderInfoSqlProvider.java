package com.example.demo.dao;

import com.example.demo.entity.OrderInfo;
import com.example.demo.entity.OrderInfoExample.Criteria;
import com.example.demo.entity.OrderInfoExample.Criterion;
import com.example.demo.entity.OrderInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OrderInfoSqlProvider {

    public String countByExample(OrderInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("order_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OrderInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("order_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OrderInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_info");
        
        if (record.getOrderId() != null) {
            sql.VALUES("order_id", "#{orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getHouseId() != null) {
            sql.VALUES("house_id", "#{houseId,jdbcType=VARCHAR}");
        }
        
        if (record.getAgencyId() != null) {
            sql.VALUES("agency_id", "#{agencyId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OrderInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("order_id");
        sql.SELECT("user_id");
        sql.SELECT("house_id");
        sql.SELECT("agency_id");
        sql.SELECT("create_time");
        sql.SELECT("price");
        sql.FROM("order_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OrderInfo record = (OrderInfo) parameter.get("record");
        OrderInfoExample example = (OrderInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("order_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{record.orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        }
        
        if (record.getHouseId() != null) {
            sql.SET("house_id = #{record.houseId,jdbcType=VARCHAR}");
        }
        
        if (record.getAgencyId() != null) {
            sql.SET("agency_id = #{record.agencyId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{record.price,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("order_info");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("order_id = #{record.orderId,jdbcType=VARCHAR}");
        sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        sql.SET("house_id = #{record.houseId,jdbcType=VARCHAR}");
        sql.SET("agency_id = #{record.agencyId,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("price = #{record.price,jdbcType=INTEGER}");
        
        OrderInfoExample example = (OrderInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OrderInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("order_info");
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getHouseId() != null) {
            sql.SET("house_id = #{houseId,jdbcType=VARCHAR}");
        }
        
        if (record.getAgencyId() != null) {
            sql.SET("agency_id = #{agencyId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OrderInfoExample example, boolean includeExamplePhrase) {
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