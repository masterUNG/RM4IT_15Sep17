package appewtc.masterung.rm4it;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by masterung on 9/15/2017 AD.
 */

public class GetDataByTABLE extends AsyncTask<String, Void, String>{
    private Context context;

    public GetDataByTABLE(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[0]).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("Rm4it", "e doIn ==> " + e.toString());
            return null;
        }

    }
}