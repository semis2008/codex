package com.codex.util;

import com.codex.common.Constants;
import com.codex.model.User;
import org.springframework.web.util.WebUtils;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by SEELE on 2016/9/3.
 */
public class UserUtil {

    public static User getLoginUser(HttpServletRequest request) {
        Object sessionObj = WebUtils.getSessionAttribute(request,Constants.LOGIN_USER);
        if(sessionObj==null) {
            return null;
        }else {
            try {
                User loginUser = (User) sessionObj;
                return loginUser;
            }catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }


    public static String getPassEncrypt(String pass) throws Exception{
        return SHAUtil.SHA256Encrypt(SHAUtil.shaEncode(pass+"123qwe")).substring(0,16);
    }

    /**
     * 生成7位随机数
     * @return
     * @throws Exception
     */
    public static String getUserKey() throws Exception{
        return UUIDUtil.getUUID().substring(0,7);
    }


    public static void main(String args[]) throws Exception{
        System.out.print(UserUtil.getUserKey());
    }
}
