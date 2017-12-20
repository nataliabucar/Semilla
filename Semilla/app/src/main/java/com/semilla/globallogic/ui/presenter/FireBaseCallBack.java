package com.semilla.globallogic.ui.presenter;



public interface FireBaseCallBack<Vegetable> {
    void onError(Boolean hasSomeResponse, Exception e);

    void onFirstResponse(Vegetable result);

    void onNewData(Vegetable result);
}
