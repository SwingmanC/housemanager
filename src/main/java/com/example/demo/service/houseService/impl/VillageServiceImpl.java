package com.example.demo.service.houseService.impl;

import com.example.demo.dao.VillageInfoMapper;
import com.example.demo.dao.VillagePictureMapper;
import com.example.demo.entity.VillageInfo;
import com.example.demo.entity.VillageInfoExample;
import com.example.demo.entity.VillagePicture;
import com.example.demo.entity.VillagePictureExample;
import com.example.demo.service.houseService.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillageServiceImpl implements VillageService {

    @Autowired
    private VillageInfoMapper villageInfoMapper;

    @Autowired
    private VillagePictureMapper villagePictureMapper;

    @Override
    public void addVillage(VillageInfo villageInfo) {
        villageInfoMapper.insert(villageInfo);
    }

    @Override
    public void updateVillage(VillageInfo villageInfo) {
        VillageInfoExample villageInfoExample = new VillageInfoExample();
        VillageInfoExample.Criteria criteria = villageInfoExample.createCriteria();
        criteria.andVillageIdEqualTo(villageInfo.getVillageId());
        villageInfoMapper.updateByExample(villageInfo,villageInfoExample);
    }

    @Override
    public Boolean deleteVillage(VillageInfo villageInfo) {
        VillageInfoExample villageInfoExample = new VillageInfoExample();
        VillageInfoExample.Criteria criteria = villageInfoExample.createCriteria();
        criteria.andVillageIdEqualTo(villageInfo.getVillageId());
        villageInfoMapper.deleteByExample(villageInfoExample);
        return true;
    }

    @Override
    public VillageInfo getVillageByVillageId(String villageId) {
        VillageInfoExample villageInfoExample = new VillageInfoExample();
        VillageInfoExample.Criteria criteria = villageInfoExample.createCriteria();
        criteria.andVillageIdEqualTo(villageId);

        List<VillageInfo> villageInfoList = villageInfoMapper.selectByExample(villageInfoExample);
        if(!villageInfoList.isEmpty())
        {
            return villageInfoList.get(0);
        }
        return null;
    }

    @Override
    public List<VillagePicture> getPicturesByVillageId(String villageId) {
        VillagePictureExample villagePictureExample = new VillagePictureExample();
        VillagePictureExample.Criteria criteria = villagePictureExample.createCriteria();
        criteria.andVillageIdEqualTo(villageId);

        return villagePictureMapper.selectByExample(villagePictureExample);
    }

    @Override
    public void addPicture(VillagePicture villagePicture) {
        villagePictureMapper.insert(villagePicture);
    }

    @Override
    public Boolean deletePicture(String pictureId) {
        VillagePictureExample villagePictureExample = new VillagePictureExample();
        VillagePictureExample.Criteria criteria = villagePictureExample.createCriteria();
        criteria.andPictureIdEqualTo(pictureId);
        villagePictureMapper.deleteByExample(villagePictureExample);
        return true;
    }

    @Override
    public Boolean deletePicturesByVillageId(String villageId) {
        VillagePictureExample villagePictureExample = new VillagePictureExample();
        VillagePictureExample.Criteria criteria = villagePictureExample.createCriteria();
        criteria.andVillageIdEqualTo(villageId);
        villagePictureMapper.deleteByExample(villagePictureExample);
        return true;
    }
}
