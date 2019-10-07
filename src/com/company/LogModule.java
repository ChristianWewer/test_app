package com.company;

import java.util.logging.Logger;
import java.util.logging.Level;

public class LogModule {
    public static Logger instatiateLogger(){
        Logger logger
                = Logger.getLogger(
                LogModule.class.getName());
        return logger;
    }
}
