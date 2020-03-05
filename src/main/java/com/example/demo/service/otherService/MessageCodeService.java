package com.example.demo.service.otherService;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.example.demo.config.Constants;
import com.example.demo.core.Result;
import com.example.demo.core.ResultGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MessageCodeService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public static final String CHECK_ID = "SMS_173471095";
    public static final String OK_CODE = "OK";
    public static final String ILLEGAL_PHONE = "isv.MOBILE_NUMBER_ILLEGAL";
    public static final String NUM_MESSAGE_LIMIT = "isv.BUSINESS_LIMIT_CONTROL";
    public static final int SUCCESS = 1;
    public static final int EXPIRE = 2;
    public static final int CODE_ERROR = 3;
    public static final int EMPTY_ERROR = 4;
    /**
     * 产品名称:云通信短信API产品,开发者无需替换
     */
    private static final String PRODUCT = "Dysmsapi";
    /**
     * 产品域名,开发者无需替换
     */
    private static final String DOMAIN = "dysmsapi.aliyuncs.com";

    @Value("${aliyunsms.accessKeyID}")
    private String accessKeyId;
    @Value("${aliyunsms.accessKeySecret}")
    private String accessKeySecret;


    /**
     * 阿里云发短信函数
     * @param phone 手机号
     * @param code 验证码
     * @param type 短信模板
     * @return SendSmsResponse
     * @throws ClientException ClientException
     */
    private SendSmsResponse sendSms(String phone, String code, String type) throws ClientException {

        SendSmsResponse response = new SendSmsResponse();

        if (phone.trim().length() != 11) {
            response.setCode(ILLEGAL_PHONE);
            return response;
        }

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "100000");
        System.setProperty("sun.net.client.defaultReadTimeout", "100000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", PRODUCT, DOMAIN);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phone.trim());
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("CSUSOFTWARE");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(type);
        //可选:模板中的变量替换JSON串
        request.setTemplateParam("{\"code\":\"" + code + "\"}");

        //hint 此处可能会抛出异常，注意catch
        try {
            return acsClient.getAcsResponse(request);
        } catch (Exception e) {
            response.setCode("message code error");
            return response;
        }
    }
    /**
     * 创建新的短信验证码
     * @param phone 手机号
     * @param type 验证码模板
     * @return SendSmsResponse
     * @throws ClientException ClientException
     */
    public SendSmsResponse create(String phone, String type) throws ClientException {
        String code = RandomStringUtils.randomNumeric(Constants.MESSAGE_CODE_LENGTH);
        SendSmsResponse response = this.sendSms(phone, code, type);
        String responseCode = response.getCode();
        if (responseCode != null && MessageCodeService.OK_CODE.equals(responseCode)) {
            redisTemplate.boundValueOps(phone).set(code, Constants.MESSAGE_CODE_SECONDS, TimeUnit.SECONDS);
        }
        return response;
    }
    /**
     * 校验手机号和验证码
     * @param phone 手机号
     * @param code 验证码
     * @return boolean
     */
    public int check(String phone, String code) {
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(code)) {
            return EMPTY_ERROR;
        }
        String storageValue = redisTemplate.boundValueOps(phone).get();
        if(StringUtils.isEmpty(storageValue))
        {
            return EXPIRE;
        }
        if (StringUtils.equals(storageValue, code)) {
            redisTemplate.delete(phone);
            return SUCCESS;
        } else {
            return CODE_ERROR;
        }
    }

    /**
     * 检查是否已经发送过
     * @param phone 手机号
     * @return boolean
     */
    public boolean hasSend(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return true;
        }
        return !StringUtils.isEmpty(redisTemplate.boundValueOps(phone).get());
    }

    /**
     * 判断短信发送结果
     */
    public Result getResult(String phone) throws ClientException{
        SendSmsResponse response;
        response = create(phone, MessageCodeService.CHECK_ID);
        if (response.getCode().equals(MessageCodeService.OK_CODE)){
            return ResultGenerator.success("验证码已发送，有效期一分钟");
        } else if (response.getCode().equals(MessageCodeService.ILLEGAL_PHONE)) {
            return ResultGenerator.fail("非法手机号");
        } else if (response.getCode().equals(MessageCodeService.NUM_MESSAGE_LIMIT)) {
            return ResultGenerator.fail("短信获取数量已达上限");
        } else {
            System.out.print(response.getCode());
            return ResultGenerator.fail("验证码发送失败");
        }
    }
}
