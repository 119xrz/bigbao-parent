package com.bigbao.data.service.impl;

import com.bigbao.data.beans.HistoryBean;
import com.bigbao.data.dao.HistoryDao;
import com.bigbao.data.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    HistoryDao historyDao;

    @Override
    public List<HistoryBean> findAll() {
        return historyDao.find("findAll",null);
    }

    @Override
    public void saveHistory(HistoryBean historyBean) {
        historyDao.insert("saveHistory",historyBean);
    }
}
