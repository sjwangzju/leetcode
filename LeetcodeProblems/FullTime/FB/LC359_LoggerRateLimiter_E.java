package FullTime.FB;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap
 *
 * time: O(1)
 * space: O(N)
 */
public class LC359_LoggerRateLimiter_E {

    class Logger {
        Map<String, Integer> map;
        /** Initialize your data structure here. */
        public Logger() {
            this.map = new HashMap<>();
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!map.containsKey(message)) {
                map.put(message, timestamp);
                return true;
            }
            if (timestamp - map.get(message) < 10) {
                return false;
            }
            map.put(message, timestamp);
            return true;
        }
    }
}
