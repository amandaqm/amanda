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
            //urlConn 설정.
            urlConn.setRequestMethod("POST"); // URL 요청에 대한 메소드 설정 : POST.
            urlConn.setRequestProperty("Content-Type", "application/json");
            urlConn.setRequestProperty("Authorization", "key=" + BuildConfig.FCM_WEB_API_KEY);
            urlConn.setDoOutput(true);

            String input = jsonObject.toString();
            OutputStream os = urlConn.getOutputStream();
            os.write(input.getBytes("UTF-8"));

            os.flush();
            os.close();

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