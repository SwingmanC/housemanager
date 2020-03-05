package com.example.demo.controller;

import com.example.demo.config.Constants;
import com.example.demo.core.Result;
import com.example.demo.core.ResultGenerator;
import com.example.demo.entity.*;
import com.example.demo.service.accountService.UserService;
import com.example.demo.service.addressService.AddressService;
import com.example.demo.service.agencyService.AgencyService;
import com.example.demo.service.houseService.HouseService;
import com.example.demo.service.houseService.VillageService;
import com.example.demo.utils.RandomUtil;
import com.example.demo.vo.Agency;
import com.example.demo.vo.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
public class HouseController {

    private final String path = "C:\\Users\\lenovo\\IdeaProjects\\housemanage\\housemanager\\src\\main\\resources\\static\\images\\housePictures\\";

    @Autowired
    private UserService userService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private HttpSession session;

    @Autowired
    private VillageService villageService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private AgencyService agencyService;

    @RequestMapping("/getHouses")
    public String getHouses(Model model)
    {
        List<HouseInfo> houseInfoList = houseService.getHouses();
        List<House> houseList = new ArrayList<>();

        for(int i=0;i<houseInfoList.size();i++)
        {
            House house = new House();
            house.setAddressId(houseInfoList.get(i).getAddressId());
            house.setAgencyId(houseInfoList.get(i).getAgencyId());
            house.setArea(houseInfoList.get(i).getArea());
            house.setCompleteTime(houseInfoList.get(i).getCompleteTime());
            house.setFirstPrice(houseInfoList.get(i).getFirstPrice());
            house.setHouseId(houseInfoList.get(i).getHouseId());
            house.setLocation(houseInfoList.get(i).getLocation());
            house.setPropertyRight(houseInfoList.get(i).getPropertyRight());
            house.setReleaseTime(houseInfoList.get(i).getReleaseTime());
            house.setType(houseInfoList.get(i).getType());
            house.setTotalPrice(houseInfoList.get(i).getTotalPrice());
            house.setUnitPrice(houseInfoList.get(i).getUnitPrice());
            house.setVillageId(houseInfoList.get(i).getVillageId());
            house.setUserId(houseInfoList.get(i).getUserId());
            house.setHousePictures(houseService.getPicturesByHouseId(houseInfoList.get(i).getHouseId()));
            houseList.add(house);
        }

        model.addAttribute("houseList",houseList);

        return "house/house_list";
    }

    @ResponseBody
    @RequestMapping("/getHouseList")
    public List<House> getHouseList(@RequestParam(value = "city",required = false) String city,
                                        @RequestParam(value = "min_area",required = false) String min_area,
                                        @RequestParam(value = "max_area",required = false) String max_area,
                                        @RequestParam(value = "min_price",required = false) String min_price,
                                        @RequestParam(value = "max_price",required = false) String max_price,
                                        @RequestParam(value = "min_c_time",required = false) String min_c_time,
                                        @RequestParam(value = "max_c_time",required = false) String max_c_time){

        //System.out.println(6666666);
        AddressInfo addressInfo = new AddressInfo();
        List<AddressInfo> addressInfoList=new ArrayList<>();
        if (city==null){
            addressInfoList= addressService.getAllAddress(addressInfo);
        }else{
            addressInfo.setCity(city);
            addressInfoList=addressService.getAddressByCity(addressInfo);
        }

        if(max_area==null&&min_area==null){
            min_area="0";
            max_area="9999999";
        }
        if (max_price==null&&min_price==null){
            min_price="0";
            max_price="9999999";
        }
        if(max_c_time==null&&min_c_time==null){
            min_c_time="0000";
            max_c_time="9999";
        }

        List<HouseInfo> houseInfoList = houseService.getHouseByCondition(addressInfoList,min_area,max_area,min_price,max_price,min_c_time,max_c_time);//返回房产列表
        //List<HousePicture> housePictures = houseService.getFirstPictureByHouseList(houseInfoList);//返回列表房产的首图

        List<House> houseList = new ArrayList<>();

        for(int i=0;i<houseInfoList.size();i++)
        {
            House house = new House();
            house.setAddressId(houseInfoList.get(i).getAddressId());
            house.setAgencyId(houseInfoList.get(i).getAgencyId());
            house.setArea(houseInfoList.get(i).getArea());
            house.setCompleteTime(houseInfoList.get(i).getCompleteTime());
            house.setFirstPrice(houseInfoList.get(i).getFirstPrice());
            house.setHouseId(houseInfoList.get(i).getHouseId());
            house.setLocation(houseInfoList.get(i).getLocation());
            house.setPropertyRight(houseInfoList.get(i).getPropertyRight());
            house.setReleaseTime(houseInfoList.get(i).getReleaseTime());
            house.setType(houseInfoList.get(i).getType());
            house.setTotalPrice(houseInfoList.get(i).getTotalPrice());
            house.setUnitPrice(houseInfoList.get(i).getUnitPrice());
            house.setVillageId(houseInfoList.get(i).getVillageId());
            house.setUserId(houseInfoList.get(i).getUserId());
            house.setHousePictures(houseService.getPicturesByHouseId(houseInfoList.get(i).getHouseId()));
            houseList.add(house);
        }

        System.out.println(houseInfoList.size());
        return houseList;
    }

    @RequestMapping("/getHouseInfo")
    public String getHouseInfo(@RequestParam(value = "houseId") String houseId, Model model){
        HouseInfo houseInfo = houseService.getHouseByHouseId(houseId);

        AddressInfo addressInfo = addressService.getAddressByAddressId(houseInfo.getAddressId());
        List<HousePicture> housePictureList = houseService.getPicturesByHouseId(houseId);

        VillageInfo villageInfo = villageService.getVillageByVillageId(houseInfo.getVillageId());
        List<VillagePicture> villagePictureList = villageService.getPicturesByVillageId(houseInfo.getVillageId());

        HouseState houseState = houseService.getStateByHouseId(houseId);

        UserInfo userInfo = userService.getUserByUserId(houseInfo.getUserId());
        AgencyInfo agencyInfo = agencyService.getAgencyInfoByAgencyId(houseInfo.getAgencyId());
        String agencyName = agencyInfo.getName();

        model.addAttribute("houseInfo", houseInfo);
        model.addAttribute("houseState",houseState);
        model.addAttribute("addressInfo",addressInfo);
        model.addAttribute("agencyName",agencyName);
        model.addAttribute("housePictureList", housePictureList);
        model.addAttribute("userInfo",userInfo);
        model.addAttribute("villageInfo", villageInfo);
        model.addAttribute("villagePictureList", villagePictureList);

        return "house/house_detail";
    }

    @RequestMapping("/updatePicture")
    public String updatePicture(@RequestParam(value = "file") MultipartFile file ,//文件
                                @RequestParam(value = "houseId") String houseId,Model model){
//        System.err.println(picture.getName());
//        String fileName=picture.getOriginalFilename();
//        String ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
//        String path = File.separator  + File.separator + "." + ext;
//        try {
//            File targetFile = new File(path);
//            if (!targetFile.getParentFile().exists()){
//                targetFile.getParentFile().mkdirs();
//            }
//            picture.transferTo(targetFile);
//            HousePicture housePicture = getPic(houseId,path);
//            houseService.addPicture(housePicture);
//            return "house/house_manage";
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //返回上传的文件是否为空，即没有选择任何文件，或者所选文件没有内容。
        //防止上传空文件导致奔溃

        System.err.println(file.getName());
        if (file.isEmpty()) {
            throw new NullPointerException("文件为空");
        }
        // 设置文件上传后的路径
        String filePath = "/house/images/housePictures/";
        // 获取文件名后缀名
        String suffix = file.getOriginalFilename();
        String prefix = suffix.substring(suffix.lastIndexOf(".")+1);
        //为防止文件重名被覆盖，文件名取名为：当前日期 + 1-1000内随机数
        Random random = new Random();
        Integer randomFileName = random.nextInt(1000);
        String fileName = RandomUtil.productId() + randomFileName +"." +  prefix;
        //创建文件路径
        File dest = new File(path + fileName);
        HousePicture housePicture = new HousePicture();
        String pictureId = RandomUtil.productId();
        housePicture.setPictureId(pictureId);
        housePicture.setHouseId(houseId);
        housePicture.setPictureUrl(filePath+fileName);
        houseService.addPicture(housePicture);
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        // 检测是否存在目录

        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        List<HouseInfo> houseInfoList = houseService.getHouseInfoListByUserId(userInfo.getUserId());
        model.addAttribute("houseInfoList",houseInfoList);

        if (!dest.getParentFile().exists()) {
            //假如文件不存在即重新创建新的文件已防止异常发生
            dest.getParentFile().mkdirs();
        }
        try {
            //transferTo（dest）方法将上传文件写到服务器上指定的文件
            file.transferTo(dest);
            //保存t_upload_file表中
            //String filePathNew = filePath + fileName;
            return "house/house_manage";
        } catch (Exception e) {
            return "house/house_manage";
        }


    }

    private HousePicture getPic(String houseId , String path){
        HousePicture housePicture = new HousePicture();
        housePicture.setHouseId(houseId);
        housePicture.setPictureUrl(path);
        return housePicture;
    }

    @RequestMapping("/addHouse")
    public String addHouse(@RequestParam(value = "province") String province,
                           @RequestParam(value = "city") String city,
                           @RequestParam(value = "region" ) String region,
                           @RequestParam(value = "agency") String agencyId,
                           @RequestParam(value = "location") String location,
                           @RequestParam(value = "completeTime") String completeTime,
                           @RequestParam(value = "releaseTime" ) String releaseTime,
                           @RequestParam(value = "area") int area,
                           @RequestParam(value = "type") String type,
                           @RequestParam(value = "unitPrice" ) int unitPrice,
                           @RequestParam(value = "firstPrice") int firstPrice,
                           @RequestParam(value = "totalPrice") int totalPrice,
                           @RequestParam(value = "propertyRight" ) int propertyRight) throws ParseException {


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        completeTime.replace('/','-');
        releaseTime.replace('/','-');
        Date ctime = formatter.parse(completeTime),rtime= formatter.parse(releaseTime);


        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setCity(city);
        addressInfo.setProvince(province);
        addressInfo.setRegion(region);
        addressInfo = addressService.getAddressByExample(addressInfo);

        HouseInfo houseInfo = new HouseInfo();
        String houseId = RandomUtil.productId();

        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        houseInfo.setUserId(userInfo.getUserId());
        houseInfo.setAddressId(addressInfo.getAddressId());

        //以下几行为测试代码
        //houseInfo.setUserId("1");
        //houseInfo.setVillageId("1");
        //houseInfo.setAddressId("1");
        //houseInfo.setAgencyId("1");

        houseInfo.setAgencyId(agencyId);
        houseInfo.setLocation(location);
        houseInfo.setHouseId(houseId);
        houseInfo.setVillageId("1");
        houseInfo.setCompleteTime(ctime);
        houseInfo.setReleaseTime(rtime);
        houseInfo.setArea(area);

        houseInfo.setType(type);
        houseInfo.setUnitPrice(unitPrice);
        houseInfo.setFirstPrice(firstPrice);
        houseInfo.setTotalPrice(totalPrice);
        houseInfo.setPropertyRight(propertyRight);

        HouseState houseState = new HouseState();//添加房产时的房产状态初始化
        String stateId = RandomUtil.productId();
        houseState.setHouseId(houseId);
        houseState.setStateId(stateId);
        houseState.setState(Constants.HouseState.NOT_PASS);
        houseService.addHouse(houseInfo);
        houseService.addState(houseState);
        return "index";
    }

    @ResponseBody
    @RequestMapping("/updateHouseState")
    public Result updateHouseState(@RequestParam(value = "houseId")String houseId){
        HouseState houseState = houseService.getStateByHouseId(houseId);
        houseState.setState(Constants.AgencyState.PASS);
        houseService.updateState(houseState);
        return ResultGenerator.success("修改成功");
    }

    @RequestMapping("/updateHouseInfo")//更新房产
    public String updateHouseInfo(@RequestParam(value = "houseId") String houseId,
                                  @RequestParam(value = "location") String location,
                                  @RequestParam(value = "completeTime") String completeTime,
                                  @RequestParam(value = "releaseTime" ) String releaseTime,
                                  @RequestParam(value = "area") int area,
                                  @RequestParam(value = "type") String type,
                                  @RequestParam(value = "unitPrice" ) int unitPrice,
                                  @RequestParam(value = "firstPrice") int firstPrice,
                                  @RequestParam(value = "totalPrice") int totalPrice,
                                  @RequestParam(value = "propertyRight" ) int propertyRight,
                                  Model model)throws ParseException{

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        completeTime.replace('/','-');
        releaseTime.replace('/','-');
        Date ctime = formatter.parse(completeTime),rtime= formatter.parse(releaseTime);

        HouseInfo houseInfo = houseService.getHouseByHouseId(houseId);
        houseInfo.setLocation(location);
        houseInfo.setCompleteTime(ctime);
        houseInfo.setReleaseTime(rtime);
        houseInfo.setArea(area);
        houseInfo.setType(type);
        houseInfo.setUnitPrice(unitPrice);
        houseInfo.setFirstPrice(firstPrice);
        houseInfo.setTotalPrice(totalPrice);
        houseInfo.setPropertyRight(propertyRight);
        houseService.updateHouse(houseInfo);

        HouseState houseState = houseService.getStateByHouseId(houseId);
        houseState.setState(Constants.HouseState.NOT_PASS);
        houseService.updateState(houseState);

        List<HousePicture> housePictureList = houseService.getPicturesByHouseId(houseId);
        AddressInfo addressInfo = addressService.getAddressByAddressId(houseInfo.getAddressId());

        model.addAttribute("houseInfo",houseInfo);
        model.addAttribute("houseState",houseState);
        model.addAttribute("housePictureList",housePictureList);
        model.addAttribute("addressInfo",addressInfo);

        return "house/house_detail";
    }

    @RequestMapping("/viewAddHouse")
    public String viewAddHouse()
    {
        return "house/add_house";
    }

    @RequestMapping("/getUserHouseList")
    public String getUserHouseList(Model model){
        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");

        List<HouseInfo> houseInfoList = houseService.getHouseInfoListByUserId(userInfo.getUserId());
//        List<AgencyInfo> agencyInfoList = new ArrayList<>();
//
//        for(int i=0;i<houseInfoList.size();i++)
//        {
//            AgencyInfo agencyInfo = agencyService.getAgencyInfoByAgencyId(houseInfoList.get(i).getAgencyId());
//            agencyInfoList.add(agencyInfo);
//        }

        model.addAttribute("houseInfoList",houseInfoList);
        //model.addAttribute("agencyInfoList",agencyInfoList);
        return "house/house_manage";
    }

    @RequestMapping("/viewHouseInfoModify")
    public String viewHouseInfoModify(@RequestParam(value = "houseId")String houseId,
                                      Model model){
        HouseInfo houseInfo = houseService.getHouseByHouseId(houseId);
        UserInfo userInfo = userService.getUserByUserId(houseInfo.getUserId());
        AddressInfo addressInfo = addressService.getAddressByAddressId(houseInfo.getAddressId());

        model.addAttribute("houseInfo",houseInfo);
        model.addAttribute("addressInfo",addressInfo);
        model.addAttribute("userInfo",userInfo);
        return "house/house_info_modify";
    }

    @RequestMapping("/viewHousePictureUpdate")
    public String viewHousePictureUpdate(@RequestParam(value = "houseId")String houseId,
                                         Model model){

        HouseInfo houseInfo = houseService.getHouseByHouseId(houseId);

        model.addAttribute("houseInfo",houseInfo);
        return "house/house_picture_update";
    }

}
