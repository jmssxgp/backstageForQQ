package com.program.qq.Util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author xgp
 * @version 1.0
 * @date 2019/11/19 16:48
 */
public class getOpenIdUtil {

    public static String getOpenId(String code){
        BufferedReader in = null;
        String url = "https://api.q.qq.com/sns/jscode2session?appid=1109993068&secret=BYKleDDin5YyCr2o&js_code="+code+"&grant_type=authorization_code";
        try{
            URL qqUrl = new URL(url);
            URLConnection connection = qqUrl.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            JSONObject json = JSON.parseObject(sb.toString());
            return (String)json.get("openid");
        }catch (Exception e1){
            throw new RuntimeException(e1);
        }finally {
            try {
                if (in!=null){
                    in.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
