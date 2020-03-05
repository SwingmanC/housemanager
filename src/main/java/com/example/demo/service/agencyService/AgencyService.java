package com.example.demo.service.agencyService;

import com.example.demo.entity.AgencyInfo;
import com.example.demo.entity.AgencyState;

import java.util.List;

public interface AgencyService {

    void addAgency(AgencyInfo agencyInfo);

    void updateAgency(AgencyInfo agencyInfo);

    Boolean deleteAgency(String agencyId);

    List<AgencyInfo> getAgencies();

    AgencyState getStateByAgencyId(String agencyId);

    void updateState(AgencyState agencyState);

    void addState(AgencyState agencyState);

    AgencyInfo getAgencyInfoByAgencyId(String agencyId);

    Boolean deleteAgencyState(String agencyId);

    List<AgencyInfo> getAgencyInfoByAddressId(String addressId);
}
