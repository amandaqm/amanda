package kr.co.niceinfo.qm.amanda.presenter.base;


import com.androidnetworking.error.ANError;

import kr.co.niceinfo.qm.amanda.ui.base.AmandaView;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the AmandaView type that wants to be attached with.
 */
public interface AmandaPresenter<V extends AmandaView> {

    void onAttach(V AmandaView);

    void onDetach();

    void handleApiError(ANError error);

    void setUserAsLoggedOut();
}
