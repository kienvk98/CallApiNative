package com.example.call_api_native;

import com.example.call_api_native.model.req.UpdateCustomerDeviceReq;
import com.example.call_api_native.model.resp.ReviewResp;
import com.example.call_api_native.model.base.BaseDataResponse;
import com.example.call_api_native.model.base.BaseResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("/social/api/reviews/search")
    Call<BaseResponse<BaseDataResponse<ReviewResp>>> searchReview(@Query("offset") int offset, @Query("limit") int limit, @Query("filterString") String filterString);

    @GET("/api/api/Customer/UpdateCustomerDevice")
    Call<BaseResponse<BaseDataResponse<ReviewResp>>> updateCustomerDevice(@Body HashMap<String, String> body);

    @GET("/api/api/Customer/UpdateCustomerDevice")
    Call<BaseResponse<BaseDataResponse<ReviewResp>>> updateCustomerDeviceV1(@Body UpdateCustomerDeviceReq body);
}
