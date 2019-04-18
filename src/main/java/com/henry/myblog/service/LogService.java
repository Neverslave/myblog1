package com.henry.myblog.service;

import com.henry.myblog.model.Log;

import java.util.List;

public interface LogService {
    int insertLog(Log log);
     List<Log> queryAllLogs();


}
