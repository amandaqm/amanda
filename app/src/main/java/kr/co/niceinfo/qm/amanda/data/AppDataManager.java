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

import javax.inject.Inject;
import javax.inject.Singleton;

import kr.co.niceinfo.qm.amanda.data.db.DbHelper;
import kr.co.niceinfo.qm.amanda.data.network.ApiHelper;
import kr.co.niceinfo.qm.amanda.data.prefs.PreferencesHelper;
import kr.co.niceinfo.qm.amanda.di.ApplicationContext;

/**
 * Created by janisharali on 27/01/17.
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }


}
