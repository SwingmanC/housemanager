package com.example.demo.dao;

import com.example.demo.entity.UserInfo;
import com.example.demo.entity.UserInfoExample.Criteria;
import com.example.demo.entity.UserInfoExample.Criterion;
import com.example.demo.entity.UserInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserInfoSqlProvider {

    public String countByExample(UserInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("user_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(UserInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("user_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(UserInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_info");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("`password`", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getAge() != null) {
            sql.VALUES("age", "#{age,jdbcType=INTEGER}");
        }
        
        if (record.getCardId() != null) {
            sql.VALUES("card_id", "#{cardId,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            sql.VALUES("telephone", "#{telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            sql.VALUES("`state`", "#{state,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(UserInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("user_id");
        sql.SELECT("`name`");
        sql.SELECT("`password`");
        sql.SELECT("age");
        sql.SELECT("card_id");
        sql.SELECT("telephone");
        sql.SELECT("email");
        sql.SELECT("address");
        sql.SELECT("`state`");
        sql.FROM("user_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserInfo record = (UserInfo) parameter.get("record");
        UserInfoExample example = (UserInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("user_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("`password` = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getAge() != null) {
            sql.SET("age = #{record.age,jdbcType=INTEGER}");
        }
        
        if (record.getCardId() != null) {
            sql.SET("card_id = #{record.cardId,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            sql.SET("telephone = #{record.telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            sql.SET("`state` = #{record.state,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("user_info");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        sql.SET("`password` = #{record.password,jdbcType=VARCHAR}");
        sql.SET("age = #{record.age,jdbcType=INTEGER}");
        sql.SET("card_id = #{record.cardId,jdbcType=VARCHAR}");
        sql.SET("telephone = #{record.telephone,jdbcType=VARCHAR}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("`state` = #{record.state,jdbcType=INTEGER}");
        
        UserInfoExample example = (UserInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("user_info");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("`password` = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getAge() != null) {
            sql.SET("age = #{age,jdbcType=INTEGER}");
        }
        
        if (record.getCardId() != null) {
            sql.SET("card_id = #{cardId,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            sql.SET("telephone = #{telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            sql.SET("`state` = #{state,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, UserInfoExample example, boolean includeExamplePhrase) {
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