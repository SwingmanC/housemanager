package com.example.demo.service.agencyService.impl;

import com.example.demo.dao.AgencyInfoMapper;
import com.example.demo.dao.AgencyStateMapper;
import com.example.demo.entity.*;
import com.example.demo.service.agencyService.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private AgencyInfoMapper agencyInfoMapper;

    @Autowired
    private AgencyStateMapper agencyStateMapper;

    @Override
    public void addAgency(AgencyInfo agencyInfo) {
        agencyInfoMapper.insert(agencyInfo);
    }

    @Override
    public void updateAgency(AgencyInfo agencyInfo) {
        AgencyInfoExample agencyInfoExample = new AgencyInfoExample();
        AgencyInfoExample.Criteria criteria = agencyInfoExample.createCriteria();
        criteria.andTelephoneEqualTo(agencyInfo.getTelephone());
        agencyInfoMapper.updateByExample(agencyInfo,agencyInfoExample);

    }

    @Override
    public Boolean deleteAgency(String agencyId) {
        AgencyInfoExample agencyInfoExample = new AgencyInfoExample();
        AgencyInfoExample.Criteria criteria = agencyInfoExample.createCriteria();
        criteria.andAgencyIdEqualTo(agencyId);
        agencyInfoMapper.deleteByExample(agencyInfoExample);
        return true;
    }

    @Override
    public List<AgencyInfo> getAgencies() {
        AgencyInfoExample agencyInfoExample = new AgencyInfoExample();
        return agencyInfoMapper.selectByExample(agencyInfoExample);
    }

    @Override
    public AgencyState getStateByAgencyId(String agencyId) {

        AgencyStateExample agencyStateExample = new AgencyStateExample();
        AgencyStateExample.Criteria criteria = agencyStateExample.createCriteria();
        criteria.andAgencyIdEqualTo(agencyId);

        List<AgencyState> agencyStateList = agencyStateMapper.selectByExample(agencyStateExample);
        if(!agencyStateList.isEmpty())
        {
            return agencyStateList.get(0);
        }
        return null;
    }

    @Override
    public void updateState(AgencyState agencyState) {
        AgencyStateExample agencyStateExample = new AgencyStateExample();
        AgencyStateExample.Criteria criteria = agencyStateExample.createCriteria();
        criteria.andAgencyIdEqualTo(agencyState.getAgencyId());
        agencyStateMapper.updateByExample(agencyState,agencyStateExample);
    }

    @Override
    public void addState(AgencyState agencyState) {
        agencyStateMapper.insert(agencyState);
    }

    @Override
    public AgencyInfo getAgencyInfoByAgencyId(String agencyId) {
        AgencyInfoExample agencyInfoExample = new AgencyInfoExample();
        AgencyInfoExample.Criteria criteria = agencyInfoExample.createCriteria();
        criteria.andAgencyIdEqualTo(agencyId);

        List<AgencyInfo> agencyInfoList = agencyInfoMapper.selectByExample(agencyInfoExample);
        if(!agencyInfoList.isEmpty())
        {
            return agencyInfoList.get(0);
        }
        return null;
    }

    @Override
    public Boolean deleteAgencyState(String agencyId) {
        AgencyStateExample agencyStateExample = new AgencyStateExample();
        AgencyStateExample.Criteria criteria = agencyStateExample.createCriteria();
        criteria.andAgencyIdEqualTo(agencyId);

        agencyStateMapper.deleteByExample(agencyStateExample);
        return true;
    }

    @Override
    public List<AgencyInfo> getAgencyInfoByAddressId(String addressId) {

        AgencyInfoExample agencyInfoExample = new AgencyInfoExample();
        AgencyInfoExample.Criteria criteria = agencyInfoExample.createCriteria();
        criteria.andAddressIdEqualTo(addressId);

        return agencyInfoMapper.selectByExample(agencyInfoExample);
    }
}
