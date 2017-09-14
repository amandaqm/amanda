package kr.co.niceinfo.qm.amanda.data.firebase;

import android.support.annotation.NonNull;

public class FirebaseRxDataCastException extends Exception {

    public FirebaseRxDataCastException() {
    }

    public FirebaseRxDataCastException(@NonNull String detailMessage) {
        super(detailMessage);
    }

    public FirebaseRxDataCastException(@NonNull String detailMessage, @NonNull Throwable throwable) {
        super(detailMessage, throwable);
    }

    public FirebaseRxDataCastException(@NonNull Throwable throwable) {
        super(throwable);
    }
}