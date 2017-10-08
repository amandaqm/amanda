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

package kr.co.niceinfo.qm.amanda.data;


import android.content.Context;

import com.google.firebase.auth.AuthResult;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import kr.co.niceinfo.qm.amanda.data.db.DbHelper;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.data.db.model.Crisis;
import kr.co.niceinfo.qm.amanda.data.db.model.Level;
import kr.co.niceinfo.qm.amanda.data.db.model.Member;
import kr.co.niceinfo.qm.amanda.data.db.model.User;
import kr.co.niceinfo.qm.amanda.data.firebase.FirebaseHelper;
import kr.co.niceinfo.qm.amanda.data.network.ApiHeader;
import kr.co.niceinfo.qm.amanda.data.network.ApiHelper;
import kr.co.niceinfo.qm.amanda.data.network.model.BlogResponse;
import kr.co.niceinfo.qm.amanda.data.network.model.OpenSourceResponse;
import kr.co.niceinfo.qm.amanda.data.prefs.PreferencesHelper;
import kr.co.niceinfo.qm.amanda.di.ApplicationContext;


@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;
    private final FirebaseHelper mFirebaseHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper,
                          FirebaseHelper firebaseHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mFirebaseHelper = firebaseHelper;
    }

    //AppFirebaseHelper

    //회원가입
    @Override
    public Observable<AuthResult> register(User user) {
        return mFirebaseHelper.register(user);
    }


    public Observable<Member> updateUserInDatabase(Member member) {
        return mFirebaseHelper.updateUserInDatabase(member);
    }

    public Observable<Member> getMember(String uid) {
        return mFirebaseHelper.getMember(uid);
    }

    //로그인
    @Override
    public Observable<AuthResult> login(User user) {
        return mFirebaseHelper.login(user);
    }

    @Override
    public Observable<Void> logout() {
        return mFirebaseHelper.logout();
    }


    @Override
    public Observable<Void> sendEmailVerification() {
        return mFirebaseHelper.sendEmailVerification();
    }

    //boards 조회
    @Override
    public Observable<List<Board>> getBoards() {
        return mFirebaseHelper.getBoards();
    }

    //boards 조회
    @Override
    public Observable<Object> insertBoard(Board board) {
        return mFirebaseHelper.insertBoard(board);
    }

    //boards 수정
    @Override
    public Observable<Object> updateBoard(Board board) {
        return mFirebaseHelper.updateBoard(board);
    }

    //boards 삭제
    @Override
    public Observable<Object> deleteBoard(Board board) {
        return mFirebaseHelper.deleteBoard(board);
    }

    @Override
    public Observable<Board> getBoard(String noticeKey) {
        return mFirebaseHelper.getBoard(noticeKey);
    }

    //boards 조회
    @Override
    public Observable<List<Level>> getCrisisLevels(String name) {
        return mFirebaseHelper.getCrisisLevels(name);
    }

    @Override
    public Observable<List<Crisis>> getCrisis(String name) {
        return mFirebaseHelper.getCrisis(name);
    }



    //AppPreferencesHelper
    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPreferencesHelper.getCurrentUserProfilePicUrl();
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPreferencesHelper.setCurrentUserProfilePicUrl(profilePicUrl);
    }

    // API

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public Observable<BlogResponse> getBlogApiCall() {
        return mApiHelper.getBlogApiCall();
    }

    @Override
    public Observable<OpenSourceResponse> getOpenSourceApiCall() {
        return mApiHelper.getOpenSourceApiCall();
    }

    @Override
    public Observable<Object> postPushNoticeApiCall(Board notice) {
        return mApiHelper.postPushNoticeApiCall(notice);
    }

}
