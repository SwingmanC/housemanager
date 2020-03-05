package com.example.demo.config;

public class Constants {
    //短信验证码发送间隔，有限时间
    public static int MESSAGE_CODE_SECONDS = 60;
    //短信验证码长度
    public static int MESSAGE_CODE_LENGTH = 6;

    public static class HouseState{
        public static final int NOT_PASS = 0;
        public static final int PASS=1;
        public static final int BOUGHT=2;
    }

    public static class AgencyState{
        public static final int NOT_PASS = 0;
        public static final int PASS = 1;
    }

    public static class UserState{
        public static final int FREEZE = 0;
        public static final int NORMAL = 1;
    }
}
