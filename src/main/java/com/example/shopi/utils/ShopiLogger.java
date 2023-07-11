package com.example.shopi.utils;

import com.example.shopi.log.LOGSTATE;
import com.example.shopi.log.Log;
import com.example.shopi.log.LogRepository;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ShopiLogger {

    private Logger logger = LoggerFactory.getLogger("shopi-logger");
    private LogRepository repository;

    public void log(LOGSTATE state, String msg, String module){
        switch (state){
            case INFO:
                logger.info("Message: " + msg + ", at module: " + module +", time: " + LocalDateTime.now());
                break;
            case WARN:
                logger.warn("Message: " + msg + ", at module: " + module +", time: " + LocalDateTime.now());
                break;
            case ERROR:
                logger.error("Message: " + msg + ", at module: " + module +", time: " + LocalDateTime.now());
                break;
            case TRACE:
                logger.trace("Message: " + msg + ", at module: " + module +", time: " + LocalDateTime.now());
                break;
            default:
                logger.debug("Message: " + msg + ", at module: " + module +", time: " + LocalDateTime.now());
                break;
        }
    }

}
