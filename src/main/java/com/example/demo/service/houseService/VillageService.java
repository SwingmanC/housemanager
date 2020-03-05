package com.example.demo.service.houseService;

import com.example.demo.entity.VillageInfo;
import com.example.demo.entity.VillagePicture;

import java.util.List;

public interface VillageService {

    void addVillage(VillageInfo villageInfo);

    void updateVillage(VillageInfo villageInfo);

    Boolean deleteVillage(VillageInfo villageInfo);

    VillageInfo getVillageByVillageId(String villageId);

    List<VillagePicture> getPicturesByVillageId(String villageId);

    void addPicture(VillagePicture villagePicture);

    Boolean deletePicture(String pictureId);

    Boolean deletePicturesByVillageId(String villageId);
}
