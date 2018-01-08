package com.vduty.vbackstage.security;
import java.util.concurrent.ConcurrentHashMap;

public class ValidateCodeHandle {

    private static ConcurrentHashMap validateCode = new ConcurrentHashMap<>();

    public static ConcurrentHashMap getCode() {
        return validateCode;
    }

    public static void save(String sessionId, String code) {
        validateCode.put(sessionId, code);
    }

    public static String getValidateCode(String sessionId) {
        Object obj = validateCode.get(sessionId);
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    public static boolean matchCode(String sessionId, String inputCode) {        
    	String saveCode = getValidateCode(sessionId);
        if (saveCode.equals(inputCode)) {
            return true;
        }
        return false;
    }

}