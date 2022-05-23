package com.demo.safe.advanced.mvp;

public interface MvpMainView extends MvpLoadingView{
   void showToast(String msg);
   void updateView();
}
