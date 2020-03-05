package com.example.demo.controller;

import com.aliyuncs.exceptions.ClientException;
import com.example.demo.config.Constants;
import com.example.demo.core.Result;
import com.example.demo.core.ResultGenerator;
import com.example.demo.entity.AdminInfo;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.accountService.AdminService;
import com.example.demo.service.accountService.UserService;
import com.example.demo.service.otherService.MessageCodeService;
import com.example.demo.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AccountController {

    @Autowired
    private MessageCodeService messageCodeService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private HttpSession session;

    @ResponseBody
    @RequestMapping("/user/telephoneIsExist")
    public Result telephoneIsExist(@RequestParam(value = "telephone") String telephone)
    {
        UserInfo userInfo = userService.getUserByTelephone(telephone);
        if (userInfo==null)
            return ResultGenerator.success("no");
        else
            return ResultGenerator.success("yes");
    }

    @ResponseBody
    @RequestMapping("/user/sendCode")
    public Result sendCode(@RequestParam(value = "telephone") String telephone)
    {
        if(messageCodeService.hasSend(telephone))
        {
            return ResultGenerator.fail("60秒内不要重复发送");
        }
        UserInfo userInfo = userService.getUserByTelephone(telephone);
        if(userInfo != null)
            return ResultGenerator.fail("此账号已存在");
        try{
            return messageCodeService.getResult(telephone);
        }catch(ClientException e){
            return ResultGenerator.fail(e.getErrCode());
        }
    }

    @ResponseBody
    @RequestMapping("/user/getCode")
    public Result getCode(@RequestParam(value = "telephone") String telephone){
        if(messageCodeService.hasSend(telephone))
        {
            return ResultGenerator.fail("60秒内不要重复发送");
        }
        UserInfo userInfo = userService.getUserByTelephone(telephone);
        if(userInfo == null)
            return ResultGenerator.fail("此账号不存在");
        try{
            return messageCodeService.getResult(telephone);
        }catch(ClientException e){
            return ResultGenerator.fail(e.getErrCode());
        }
    }

    @ResponseBody
    @RequestMapping("/user/verify")
    public Result verify(@RequestParam(value = "telephone") String telephone,
                         @RequestParam(value = "messageCode") String messageCode)
    {
        int code = messageCodeService.check(telephone,messageCode);
        if(code == MessageCodeService.SUCCESS)
        {
            return ResultGenerator.success("验证成功");
        }
        else if(code == MessageCodeService.CODE_ERROR)
        {
            return ResultGenerator.fail("验证码错误");
        }
        else if(code == MessageCodeService.EXPIRE)
        {
            return ResultGenerator.fail("验证码过期");
        }
        else
        {
            return ResultGenerator.fail("信息填写不完整");
        }

    }

    @PostMapping(value = "/user/register")
    public String register(@RequestParam(value = "phone") String telephone,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "name") String name,
                           Model model)
    {
        String msg="";
        UserInfo userInfo = userService.getUserByTelephone(telephone);
        if(userInfo == null)
        {
            userInfo = new UserInfo();
            userInfo.setUserId(RandomUtil.productId());
            userInfo.setTelephone(telephone);
            userInfo.setName(name);
            userInfo.setPassword(password);
            userInfo.setState(Constants.UserState.NORMAL);
            userService.addUser(userInfo);
            model.addAttribute("注册成功",msg);
            return "account/sign_in";
        }
        else
        {
            model.addAttribute("号码已存在");
            return "account/";
        }
    }

    @PostMapping("/user/loginByPassword")
    public String loginByPassword(@RequestParam(value = "telephone") String telephone,
                                  @RequestParam(value = "password") String password,
                                  Model model)
    {
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setTelephone(telephone);
        userInfo1.setPassword(password);
        UserInfo userInfo = userService.login(userInfo1);

        if (userInfo == null)
        {
            model.addAttribute("msg","密码错误");
            return "account/sign_in";
        }
        else
        {
            session.setAttribute("userInfo",userInfo);
            session.removeAttribute("adminInfo");
            session.removeAttribute("agencyInfo");
            return "index";
        }
    }

    @RequestMapping("/user/loginByTelephone")
    public String loginByTelephone(@RequestParam(value = "telephone") String telephone,
                                   Model model)
    {
        UserInfo userInfo = userService.getUserByTelephone(telephone);
        if(userInfo != null)
        {
            session.setAttribute("userInfo",userInfo);
            session.removeAttribute("adminInfo");
            session.removeAttribute("agencyInfo");
            return "index";
        }
        else
        {
            model.addAttribute("msg","此用户不存在");
            return "account/sign_in_code";
        }
    }

    @RequestMapping("/user/changePassword")
    public String changePassword(@RequestParam(value = "password") String password)
    {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        userInfo.setPassword(password);
        userService.updateUser(userInfo);
        return "index";
    }

    @RequestMapping("/user/changeInfo")
    public String changeInfo(@RequestParam(value = "age") int age,
                             @RequestParam(value = "cardId") String cardId,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "address") String address)
    {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        userInfo.setAge(age);
        userInfo.setCardId(cardId);
        userInfo.setEmail(email);
        userInfo.setAddress(address);
        userService.updateUser(userInfo);
        return "index";
    }

    @RequestMapping("/user/logout")
    public String userLogout()
    {
        session.removeAttribute("userInfo");
        return "account/sign_in";
    }

    @RequestMapping("/admin/login")
    public String login(@RequestParam(value = "telephone") String telephone,
                        @RequestParam(value = "password") String password,
                        Model model)
    {
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setTelephone(telephone);
        adminInfo.setPassword(password);
        adminInfo = adminService.login(adminInfo);

        if (adminInfo == null)
        {
            model.addAttribute("msg","密码错误");
            return "account/admin_sign_in";
        }
        else
        {
            session.setAttribute("adminInfo",adminInfo);
            session.removeAttribute("userInfo");
            session.removeAttribute("agencyInfo");
            return "index";
        }
    }

    @RequestMapping("/admin/logout")
    public String adminLogout()
    {
        session.removeAttribute("adminInfo");
        return "account/sign_in";
    }

    @RequestMapping("/user/viewLogin")
    public String viewLogin()
    {
        return "account/sign_in";
    }

    @RequestMapping("/user/viewLoginByCode")
    public String viewLoginByCode()
    {
        return "account/sign_in_code";
    }

    @RequestMapping("/admin/viewLogin")
    public String viewAdminLogin()
    {
        return "account/admin_sign_in";
    }

    @RequestMapping("/user/viewRegister")
    public String viewRegister()
    {
        return "account/sign_up";
    }

    @RequestMapping("/user/viewChangePassword")
    public String viewChangePassword()
    {
        return "account/change_password";
    }

    @RequestMapping("/user/viewChangeUserInfo")
    public String viewChangeUserInfo()
    {
        return "account/change_user_info";
    }
}
