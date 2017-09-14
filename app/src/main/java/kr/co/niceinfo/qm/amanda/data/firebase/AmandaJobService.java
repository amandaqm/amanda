package kr.co.niceinfo.qm.amanda.data.firebase;

import android.util.Log;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

/**
 * Created by Woo-Young on 2017-09-03.
 */

public class AmandaJobService extends JobService {

    private static final String TAG = "MyJobService";


    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d(TAG, "Performing long running task in scheduled job");
        // TODO(developer): add long running task here.



        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
