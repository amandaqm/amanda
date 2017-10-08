package kr.co.niceinfo.qm.amanda.data.network;

import android.util.Log;

import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import kr.co.niceinfo.qm.amanda.BuildConfig;

/**
 * Created by Woo-Young on 2017-10-08.
 */

public class RequestHttpURLConnection {

    public static final String TAG = RequestHttpURLConnection.class.getName();

    public String request(String _url, JsonObject jsonObject) {

        // HttpURLConnection 참조 변수.
        HttpURLConnection urlConn = null;

        try {
            URL url = new URL(_url);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setDoOutput(true);
            // [2-1]. urlConn 설정.
            urlConn.setRequestMethod("POST"); // URL 요청에 대한 메소드 설정 : POST.
            urlConn.setRequestProperty("Content-Type", "application/json");
            urlConn.setRequestProperty("Authorization", "key=" + BuildConfig.FCM_WEB_API_KEY);
            urlConn.setDoOutput(true);

            //String input = "{\"notification\" : {\"title\" : \" 여기다 제목넣기 \", \"body\" : \"여기다 내용 넣기\"}, \"to\":\"/topics/notice\" , \"data\" : {\"message\" : \"제목\",}}";
            String input = jsonObject.toString();
            OutputStream os = urlConn.getOutputStream();
            os.write(input.getBytes("UTF-8")); // 출력 스트림에 출력.
            //os.write(strParams.getBytes("UTF-8")); // 출력 스트림에 출력.

            os.flush(); // 출력 스트림을 플러시(비운다)하고 버퍼링 된 모든 출력 바이트를 강제 실행.
            os.close(); // 출력 스트림을 닫고 모든 시스템 자원을 해제.


            // 실패 시 null을 리턴하고 메서드를 종료.
            Log.i(TAG, "urlConn.getResponseCode() : " + urlConn.getResponseCode());
            Log.i(TAG, "HttpURLConnection.HTTP_OK : " + HttpURLConnection.HTTP_OK);

            if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK)
                return null;

            // 요청한 URL의 출력물을 BufferedReader로 받는다.
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));

            // 출력물의 라인과 그 합에 대한 변수.
            String line;
            String page = "";

            // 라인을 받아와 합친다.
            while ((line = reader.readLine()) != null) {
                page += line;
            }

            return page;

        } catch (MalformedURLException e) { // for URL.
            e.printStackTrace();
        } catch (IOException e) { // for openConnection().
            e.printStackTrace();
        } finally {
            if (urlConn != null)
                urlConn.disconnect();
        }

        return null;

    }

}