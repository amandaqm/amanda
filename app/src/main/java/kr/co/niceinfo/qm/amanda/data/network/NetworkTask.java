package kr.co.niceinfo.qm.amanda.data.network;

import android.os.AsyncTask;

import com.google.gson.JsonObject;

/**
 * Created by Woo-Young on 2017-10-08.
 */

public class NetworkTask extends AsyncTask<Void, Void, String> {

    private String url;
    private JsonObject JsonObjValues;

    public NetworkTask(String url, JsonObject jsonObject) {
        this.url = url;
        this.JsonObjValues = jsonObject;
    }

    @Override
    protected String doInBackground(Void... params) {
        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
        result = requestHttpURLConnection.request(url, JsonObjValues); // 해당 URL로 부터 결과물을 얻어온다.
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어옴
    }
}