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

package kr.co.niceinfo.qm.amanda.ui.feed;


import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.ui.base.AmandaView;
import kr.co.niceinfo.qm.amanda.ui.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;

/**
 * Created by janisharali on 25/05/17.
 */

public class FeedPresenter<V extends AmandaView> extends BasePresenter<V> implements
        FeedMvpPresenter<V> {

    private static final String TAG = "FeedPresenter";

    @Inject
    public FeedPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
