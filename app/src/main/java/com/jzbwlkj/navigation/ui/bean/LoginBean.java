package com.jzbwlkj.navigation.ui.bean;

/**
 * Created by Administrator on 2018/2/24.
 */

public class LoginBean {


    /**
     * code : 200
     * message : 操作成功
     * data : {"uid":6,"nickname":"驾驶员A","user_login":"13639447983","sex":1,"avatar":"user/20180205/7d99b66e83b4e946f5c848e7782c1a87.jpg","age":"25","work_years":"3","work_type":"收运工","token":"d2ecd07f9d89d0ba4728515035d74b32acdcb21acd4540b9542c75bf34680e37"}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uid : 6
         * nickname : 驾驶员A
         * user_login : 13639447983
         * sex : 1
         * avatar : user/20180205/7d99b66e83b4e946f5c848e7782c1a87.jpg
         * age : 25
         * work_years : 3
         * work_type : 收运工
         * token : d2ecd07f9d89d0ba4728515035d74b32acdcb21acd4540b9542c75bf34680e37
         */

        private int uid;
        private String nickname;
        private String user_login;
        private int sex;
        private String avatar;
        private String age;
        private String work_years;
        private String work_type;
        private String token;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUser_login() {
            return user_login;
        }

        public void setUser_login(String user_login) {
            this.user_login = user_login;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getWork_years() {
            return work_years;
        }

        public void setWork_years(String work_years) {
            this.work_years = work_years;
        }

        public String getWork_type() {
            return work_type;
        }

        public void setWork_type(String work_type) {
            this.work_type = work_type;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
