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

package kr.co.niceinfo.qm.amanda.ui.fragment.blog;

import android.util.Log;

import com.androidnetworking.error.ANError;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.data.network.model.BlogResponse;
import kr.co.niceinfo.qm.amanda.presenter.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;

/**
 * Created by janisharali on 25/05/17.
 */

public class BlogPresenter<V extends BlogMvpView> extends BasePresenter<V>
        implements BlogMvpPresenter<V> {

    private static final String TAG = "BlogPresenter";
    @Inject
    public BlogPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        Log.i(TAG, "[BLOG] onViewPrepared");
        getAmandaView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .getBlogApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<BlogResponse>() {
                    @Override
                    public void accept(@NonNull BlogResponse blogResponse)
                            throws Exception {
                        Log.i(TAG, "[BLOG] accept");
                        if (blogResponse != null && blogResponse.getData() != null) {
                            getAmandaView().updateBlog(blogResponse.getData());
                        }
                        getAmandaView().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getAmandaView().hideLoading();

                        // handle the error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }


                    }
                }));
    }
}
