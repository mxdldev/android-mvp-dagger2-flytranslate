package com.yige.translate.mvp.model;

import com.yige.translate.mvp.model.baidu.MD5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by gxl on 2017/11/28.
 */

public class YoudaoModel implements IYoudaoModel {
    private YoudaoAPI mYoudaoAPI;

    @Inject
    public YoudaoModel(YoudaoAPI youdaoAPI) {
        mYoudaoAPI = youdaoAPI;
    }

    @Override
    public Observable<ResponseBody> translate1(String query, String from, String to) {
        return mYoudaoAPI.translate(getParams(query,from,to));
    }
    private Map<String,String> getParams(String query, String from, String to){
        String appKey ="2bbece5300a58c9b";
        String salt = String.valueOf(System.currentTimeMillis());
        String sign = md5(appKey + query + salt+ "7k3GVXvHxpIEldmJwDuxzIftXcVyQ290");
        Map params = new HashMap();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);
        params.put("sign", sign);
        params.put("salt", salt);
        params.put("appKey", appKey);
        return params;
    }
    /**
     * 生成32位MD5摘要
     * @param string
     * @return
     */
    public static String md5(String string) {
        if(string == null){
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        try{
            byte[] btInput = string.getBytes("utf-8");
            /** 获得MD5摘要算法的 MessageDigest 对象 */
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            /** 使用指定的字节更新摘要 */
            mdInst.update(btInput);
            /** 获得密文 */
            byte[] md = mdInst.digest();
            /** 把密文转换成十六进制的字符串形式 */
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }catch(NoSuchAlgorithmException | UnsupportedEncodingException e){
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
