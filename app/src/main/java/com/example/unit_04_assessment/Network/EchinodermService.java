package com.example.unit_04_assessment.Network;

import com.example.unit_04_assessment.Model.EchinodermsList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EchinodermService {
    String ENDPOINT = "/JDVila/storybook/master/echinoderms.json";

    @GET(ENDPOINT)
    Call<EchinodermsList> getEchinodermsListService();


}
