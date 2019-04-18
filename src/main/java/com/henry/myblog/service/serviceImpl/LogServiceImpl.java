package com.henry.myblog.service.serviceImpl;

import com.henry.myblog.mapper.LogMapper;
import com.henry.myblog.model.Log;
import com.henry.myblog.model.User;
import com.henry.myblog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;
    @Override
    public int insertLog(Log log) {
         return logMapper.insert(log);
    }

    @Override
    public List<Log> queryAllLogs() {
       return  logMapper.selectAll();
    }

    public Log createLog(String ip , User user){
        Log log = new Log
    }
}
