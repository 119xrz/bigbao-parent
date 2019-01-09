package com.bigbao.data.service;

import com.bigbao.data.beans.HistoryBean;

import java.util.List;

public interface HistoryService {

    List<HistoryBean> findAll();

    void saveHistory(HistoryBean historyBean);
}
