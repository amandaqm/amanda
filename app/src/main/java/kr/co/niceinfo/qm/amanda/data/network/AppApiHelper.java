/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package kr.co.niceinfo.qm.amanda.data.network;

import android.util.Log;

import com.google.gson.JsonObject;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import kr.co.niceinfo.qm.amanda.BuildConfig;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.data.network.model.BlogResponse;
import kr.co.niceinfo.qm.amanda.data.network.model.OpenSourceResponse;

@Singleton
public class AppApiHelper implements ApiHelper {

    public static final String TAG = AppApiHelper.class.getName();
    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }



    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Observable<BlogResponse> getBlogApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BLOG)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectObservable(BlogResponse.class);
    }

    @Override
    public Observable<OpenSourceResponse> getOpenSourceApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_OPEN_SOURCE)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectObservable(OpenSourceResponse.class);
    }

    @Override
    public Observable<Object> postPushNoticeApiCall(Board notice) {
        Log.i(TAG, "notice: " +notice);

        JsonObject messageObj = new JsonObject();
        messageObj.addProperty("message",notice.getPostingTitle().toString());


        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_FCM)
                .addHeaders(mApiHeader.getFCMedApiHeader())
                .addHeaders("Content-Type","application/json")
                .addHeaders("Authorization","key="+ BuildConfig.FCM_SERVER_API_KEY)
                .addBodyParameter("to", "/topics/notice")
                .addBodyParameter("data", messageObj.toString())
                .build()
                .getObjectObservable(Object.class);
    }
}

