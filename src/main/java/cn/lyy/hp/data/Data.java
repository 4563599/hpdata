package cn.lyy.hp.data;

import org.apache.log4j.Logger;

import java.util.Timer;
import java.util.TimerTask;

public class Data {

    private Logger log = Logger.getLogger(Data.class);
    Timer timer = null;
    int count = 0;

    private static class DataHolder {
        private static final Data INSTANCE = new Data();
    }

    private Data() {
    }

    public static final Data getInstance() {
        return DataHolder.INSTANCE;
    }

    public void begin() {
        if (timer == null) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    log.debug("count :  " + count + "\n");
                    log.error("count :  " + count + "\n");
                    count = 0;
                }
            }, 0, 1000);
        }
    }

    public void count() {
        count++;
    }
}
