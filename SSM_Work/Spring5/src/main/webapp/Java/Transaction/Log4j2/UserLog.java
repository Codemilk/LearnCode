package Transaction.Log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLog {
    private final  static Logger LOGGER = LoggerFactory.getLogger(UserLog.class);

    public static void main(String[] args) {
        LOGGER.info("info hello");
        LOGGER.warn("warn hello");
    }

}
