package com.example.call_api_native;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.call_api_native.model.resp.ReviewResp;
import com.example.call_api_native.model.base.BaseDataResponse;
import com.example.call_api_native.model.base.BaseResponse;

import java.util.Objects;

import javax.net.ssl.HttpsURLConnection;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends FlutterActivity {
    private static final String CALL_API = "CallApi";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(Objects.requireNonNull(getFlutterEngine()).getDartExecutor().getBinaryMessenger(), CALL_API).setMethodCallHandler(
                (call, result) -> {
                    callAPI();
                    result.success(CALL_API);
                });
    }

    private void callAPI() {
        Log.d("kiennt", "callAPI");
        int offset = 0;
        int limit = 10;
        String filterString = "thu";
        APIClient.getClient().create(APIInterface.class).searchReview(offset, limit, filterString).enqueue(new Callback<BaseResponse<BaseDataResponse<ReviewResp>>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<BaseDataResponse<ReviewResp>>> call, @NonNull Response<BaseResponse<BaseDataResponse<ReviewResp>>> response) {
                if(response.code() == HttpsURLConnection.HTTP_OK) {
                    Log.d("kiennt", String.format("Call API Success: %s", response.body().getStatusCode()));
                } else {
                    Log.d("kiennt", String.format("Call API Error: %d", response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse<BaseDataResponse<ReviewResp>>> call, @NonNull Throwable t) {
                Log.d("kiennt", String.format("Call API Error: %s", t.getMessage()));
            }
        });
    }
}
