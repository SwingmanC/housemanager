package com.example.demo.dao;

import com.example.demo.entity.AgencyInfo;
import com.example.demo.entity.AgencyInfoExample.Criteria;
import com.example.demo.entity.AgencyInfoExample.Criterion;
import com.example.demo.entity.AgencyInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class AgencyInfoSqlProvider {

    public String countByExample(AgencyInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("agency_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(AgencyInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("agency_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(AgencyInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("agency_info");
        
        if (record.getAgencyId() != null) {
            sql.VALUES("agency_id", "#{agencyId,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressId() != null) {
            sql.VALUES("address_id", "#{addressId,jdbcType=VARCHAR}");
        }
        
        if (record.getLocation() != null) {
            sql.VALUES("`location`", "#{location,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            sql.VALUES("telephone", "#{telephone,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(AgencyInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("agency_id");
        sql.SELECT("address_id");
        sql.SELECT("`location`");
        sql.SELECT("`name`");
        sql.SELECT("email");
        sql.SELECT("telephone");
        sql.FROM("agency_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        AgencyInfo record = (AgencyInfo) parameter.get("record");
        AgencyInfoExample example = (AgencyInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("agency_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getAgencyId() != null) {
            sql.SET("agency_id = #{record.agencyId,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressId() != null) {
            sql.SET("address_id = #{record.addressId,jdbcType=VARCHAR}");
        }
        
        if (record.getLocation() != null) {
            sql.SET("`location` = #{record.location,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            sql.SET("telephone = #{record.telephone,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("agency_info");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("agency_id = #{record.agencyId,jdbcType=VARCHAR}");
        sql.SET("address_id = #{record.addressId,jdbcType=VARCHAR}");
        sql.SET("`location` = #{record.location,jdbcType=VARCHAR}");
        sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        sql.SET("telephone = #{record.telephone,jdbcType=VARCHAR}");
        
        AgencyInfoExample example = (AgencyInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AgencyInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("agency_info");
        
        if (record.getAgencyId() != null) {
            sql.SET("agency_id = #{agencyId,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressId() != null) {
            sql.SET("address_id = #{addressId,jdbcType=VARCHAR}");
        }
        
        if (record.getLocation() != null) {
            sql.SET("`location` = #{location,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            sql.SET("telephone = #{telephone,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, AgencyInfoExample example, boolean includeExamplePhrase) {
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