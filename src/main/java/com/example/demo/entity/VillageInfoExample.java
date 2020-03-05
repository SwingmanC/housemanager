package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class VillageInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VillageInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVillageIdIsNull() {
            addCriterion("village_id is null");
            return (Criteria) this;
        }

        public Criteria andVillageIdIsNotNull() {
            addCriterion("village_id is not null");
            return (Criteria) this;
        }

        public Criteria andVillageIdEqualTo(String value) {
            addCriterion("village_id =", value, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdNotEqualTo(String value) {
            addCriterion("village_id <>", value, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdGreaterThan(String value) {
            addCriterion("village_id >", value, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdGreaterThanOrEqualTo(String value) {
            addCriterion("village_id >=", value, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdLessThan(String value) {
            addCriterion("village_id <", value, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdLessThanOrEqualTo(String value) {
            addCriterion("village_id <=", value, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdLike(String value) {
            addCriterion("village_id like", value, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdNotLike(String value) {
            addCriterion("village_id not like", value, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdIn(List<String> values) {
            addCriterion("village_id in", values, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdNotIn(List<String> values) {
            addCriterion("village_id not in", values, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdBetween(String value1, String value2) {
            addCriterion("village_id between", value1, value2, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdNotBetween(String value1, String value2) {
            addCriterion("village_id not between", value1, value2, "villageId");
            return (Criteria) this;
        }

        public Criteria andSupportIsNull() {
            addCriterion("support is null");
            return (Criteria) this;
        }

        public Criteria andSupportIsNotNull() {
            addCriterion("support is not null");
            return (Criteria) this;
        }

        public Criteria andSupportEqualTo(String value) {
            addCriterion("support =", value, "support");
            return (Criteria) this;
        }

        public Criteria andSupportNotEqualTo(String value) {
            addCriterion("support <>", value, "support");
            return (Criteria) this;
        }

        public Criteria andSupportGreaterThan(String value) {
            addCriterion("support >", value, "support");
            return (Criteria) this;
        }

        public Criteria andSupportGreaterThanOrEqualTo(String value) {
            addCriterion("support >=", value, "support");
            return (Criteria) this;
        }

        public Criteria andSupportLessThan(String value) {
            addCriterion("support <", value, "support");
            return (Criteria) this;
        }

        public Criteria andSupportLessThanOrEqualTo(String value) {
            addCriterion("support <=", value, "support");
            return (Criteria) this;
        }

        public Criteria andSupportLike(String value) {
            addCriterion("support like", value, "support");
            return (Criteria) this;
        }

        public Criteria andSupportNotLike(String value) {
            addCriterion("support not like", value, "support");
            return (Criteria) this;
        }

        public Criteria andSupportIn(List<String> values) {
            addCriterion("support in", values, "support");
            return (Criteria) this;
        }

        public Criteria andSupportNotIn(List<String> values) {
            addCriterion("support not in", values, "support");
            return (Criteria) this;
        }

        public Criteria andSupportBetween(String value1, String value2) {
            addCriterion("support between", value1, value2, "support");
            return (Criteria) this;
        }

        public Criteria andSupportNotBetween(String value1, String value2) {
            addCriterion("support not between", value1, value2, "support");
            return (Criteria) this;
        }

        public Criteria andApartmentIsNull() {
            addCriterion("apartment is null");
            return (Criteria) this;
        }

        public Criteria andApartmentIsNotNull() {
            addCriterion("apartment is not null");
            return (Criteria) this;
        }

        public Criteria andApartmentEqualTo(String value) {
            addCriterion("apartment =", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentNotEqualTo(String value) {
            addCriterion("apartment <>", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentGreaterThan(String value) {
            addCriterion("apartment >", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentGreaterThanOrEqualTo(String value) {
            addCriterion("apartment >=", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentLessThan(String value) {
            addCriterion("apartment <", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentLessThanOrEqualTo(String value) {
            addCriterion("apartment <=", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentLike(String value) {
            addCriterion("apartment like", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentNotLike(String value) {
            addCriterion("apartment not like", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentIn(List<String> values) {
            addCriterion("apartment in", values, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentNotIn(List<String> values) {
            addCriterion("apartment not in", values, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentBetween(String value1, String value2) {
            addCriterion("apartment between", value1, value2, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentNotBetween(String value1, String value2) {
            addCriterion("apartment not between", value1, value2, "apartment");
            return (Criteria) this;
        }

        public Criteria andFuturePlanIsNull() {
            addCriterion("future_plan is null");
            return (Criteria) this;
        }

        public Criteria andFuturePlanIsNotNull() {
            addCriterion("future_plan is not null");
            return (Criteria) this;
        }

        public Criteria andFuturePlanEqualTo(String value) {
            addCriterion("future_plan =", value, "futurePlan");
            return (Criteria) this;
        }

        public Criteria andFuturePlanNotEqualTo(String value) {
            addCriterion("future_plan <>", value, "futurePlan");
            return (Criteria) this;
        }

        public Criteria andFuturePlanGreaterThan(String value) {
            addCriterion("future_plan >", value, "futurePlan");
            return (Criteria) this;
        }

        public Criteria andFuturePlanGreaterThanOrEqualTo(String value) {
            addCriterion("future_plan >=", value, "futurePlan");
            return (Criteria) this;
        }

        public Criteria andFuturePlanLessThan(String value) {
            addCriterion("future_plan <", value, "futurePlan");
            return (Criteria) this;
        }

        public Criteria andFuturePlanLessThanOrEqualTo(String value) {
            addCriterion("future_plan <=", value, "futurePlan");
            return (Criteria) this;
        }

        public Criteria andFuturePlanLike(String value) {
            addCriterion("future_plan like", value, "futurePlan");
            return (Criteria) this;
        }

        public Criteria andFuturePlanNotLike(String value) {
            addCriterion("future_plan not like", value, "futurePlan");
            return (Criteria) this;
        }

        public Criteria andFuturePlanIn(List<String> values) {
            addCriterion("future_plan in", values, "futurePlan");
            return (Criteria) this;
        }

        public Criteria andFuturePlanNotIn(List<String> values) {
            addCriterion("future_plan not in", values, "futurePlan");
            return (Criteria) this;
        }

        public Criteria andFuturePlanBetween(String value1, String value2) {
            addCriterion("future_plan between", value1, value2, "futurePlan");
            return (Criteria) this;
        }

        public Criteria andFuturePlanNotBetween(String value1, String value2) {
            addCriterion("future_plan not between", value1, value2, "futurePlan");
            return (Criteria) this;
        }

        public Criteria andAveragePriceIsNull() {
            addCriterion("average_price is null");
            return (Criteria) this;
        }

        public Criteria andAveragePriceIsNotNull() {
            addCriterion("average_price is not null");
            return (Criteria) this;
        }

        public Criteria andAveragePriceEqualTo(Integer value) {
            addCriterion("average_price =", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotEqualTo(Integer value) {
            addCriterion("average_price <>", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceGreaterThan(Integer value) {
            addCriterion("average_price >", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("average_price >=", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceLessThan(Integer value) {
            addCriterion("average_price <", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceLessThanOrEqualTo(Integer value) {
            addCriterion("average_price <=", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceIn(List<Integer> values) {
            addCriterion("average_price in", values, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotIn(List<Integer> values) {
            addCriterion("average_price not in", values, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceBetween(Integer value1, Integer value2) {
            addCriterion("average_price between", value1, value2, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotBetween(Integer value1, Integer value2) {
            addCriterion("average_price not between", value1, value2, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andGreenRateIsNull() {
            addCriterion("green_rate is null");
            return (Criteria) this;
        }

        public Criteria andGreenRateIsNotNull() {
            addCriterion("green_rate is not null");
            return (Criteria) this;
        }

        public Criteria andGreenRateEqualTo(Integer value) {
            addCriterion("green_rate =", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateNotEqualTo(Integer value) {
            addCriterion("green_rate <>", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateGreaterThan(Integer value) {
            addCriterion("green_rate >", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("green_rate >=", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateLessThan(Integer value) {
            addCriterion("green_rate <", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateLessThanOrEqualTo(Integer value) {
            addCriterion("green_rate <=", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateIn(List<Integer> values) {
            addCriterion("green_rate in", values, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateNotIn(List<Integer> values) {
            addCriterion("green_rate not in", values, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateBetween(Integer value1, Integer value2) {
            addCriterion("green_rate between", value1, value2, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateNotBetween(Integer value1, Integer value2) {
            addCriterion("green_rate not between", value1, value2, "greenRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateIsNull() {
            addCriterion("volume_rate is null");
            return (Criteria) this;
        }

        public Criteria andVolumeRateIsNotNull() {
            addCriterion("volume_rate is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeRateEqualTo(Integer value) {
            addCriterion("volume_rate =", value, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateNotEqualTo(Integer value) {
            addCriterion("volume_rate <>", value, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateGreaterThan(Integer value) {
            addCriterion("volume_rate >", value, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("volume_rate >=", value, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateLessThan(Integer value) {
            addCriterion("volume_rate <", value, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateLessThanOrEqualTo(Integer value) {
            addCriterion("volume_rate <=", value, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateIn(List<Integer> values) {
            addCriterion("volume_rate in", values, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateNotIn(List<Integer> values) {
            addCriterion("volume_rate not in", values, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateBetween(Integer value1, Integer value2) {
            addCriterion("volume_rate between", value1, value2, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateNotBetween(Integer value1, Integer value2) {
            addCriterion("volume_rate not between", value1, value2, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andParkingLotIsNull() {
            addCriterion("parking_lot is null");
            return (Criteria) this;
        }

        public Criteria andParkingLotIsNotNull() {
            addCriterion("parking_lot is not null");
            return (Criteria) this;
        }

        public Criteria andParkingLotEqualTo(Integer value) {
            addCriterion("parking_lot =", value, "parkingLot");
            return (Criteria) this;
        }

        public Criteria andParkingLotNotEqualTo(Integer value) {
            addCriterion("parking_lot <>", value, "parkingLot");
            return (Criteria) this;
        }

        public Criteria andParkingLotGreaterThan(Integer value) {
            addCriterion("parking_lot >", value, "parkingLot");
            return (Criteria) this;
        }

        public Criteria andParkingLotGreaterThanOrEqualTo(Integer value) {
            addCriterion("parking_lot >=", value, "parkingLot");
            return (Criteria) this;
        }

        public Criteria andParkingLotLessThan(Integer value) {
            addCriterion("parking_lot <", value, "parkingLot");
            return (Criteria) this;
        }

        public Criteria andParkingLotLessThanOrEqualTo(Integer value) {
            addCriterion("parking_lot <=", value, "parkingLot");
            return (Criteria) this;
        }

        public Criteria andParkingLotIn(List<Integer> values) {
            addCriterion("parking_lot in", values, "parkingLot");
            return (Criteria) this;
        }

        public Criteria andParkingLotNotIn(List<Integer> values) {
            addCriterion("parking_lot not in", values, "parkingLot");
            return (Criteria) this;
        }

        public Criteria andParkingLotBetween(Integer value1, Integer value2) {
            addCriterion("parking_lot between", value1, value2, "parkingLot");
            return (Criteria) this;
        }

        public Criteria andParkingLotNotBetween(Integer value1, Integer value2) {
            addCriterion("parking_lot not between", value1, value2, "parkingLot");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}