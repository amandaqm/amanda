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

package kr.co.niceinfo.qm.amanda.di.module;

import android.app.Application;
import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kr.co.niceinfo.qm.amanda.BuildConfig;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.AppDataManager;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.data.db.AppDbHelper;
import kr.co.niceinfo.qm.amanda.data.db.DbHelper;
import kr.co.niceinfo.qm.amanda.data.firebase.AppFirebaseHelper;
import kr.co.niceinfo.qm.amanda.data.firebase.FirebaseHelper;
import kr.co.niceinfo.qm.amanda.data.network.ApiHeader;
import kr.co.niceinfo.qm.amanda.data.network.ApiHelper;
import kr.co.niceinfo.qm.amanda.data.network.AppApiHelper;
import kr.co.niceinfo.qm.amanda.data.prefs.AppPreferencesHelper;
import kr.co.niceinfo.qm.amanda.data.prefs.PreferencesHelper;
import kr.co.niceinfo.qm.amanda.di.ApiInfo;
import kr.co.niceinfo.qm.amanda.di.ApplicationContext;
import kr.co.niceinfo.qm.amanda.di.DatabaseInfo;
import kr.co.niceinfo.qm.amanda.di.PreferenceInfo;
import kr.co.niceinfo.qm.amanda.utils.AppConstants;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    FirebaseHelper provideFirebaseHelper(FirebaseAuth firebaseAuth, FirebaseDatabase firebaseDatabase) {
        return new AppFirebaseHelper(firebaseAuth, firebaseDatabase);
    }

    @Provides
    public FirebaseDatabase provideFirebaseDatabase() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        return firebaseDatabase;
    }

    @Provides
    public FirebaseAuth provideFirebaseAuth() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        return firebaseAuth;
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

}
