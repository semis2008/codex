package com.codex.util;

import com.codex.common.Constants;
import com.codex.model.User;


import javax.crypto.ExemptionMechanismException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by SEELE on 2016/9/3.
 */
public class UserUtil {

    public static User getLoginUser(HttpServletRequest request) {
        Object sessionObj = request.getSession().getAttribute(Constants.LOGIN_USER);
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
}
