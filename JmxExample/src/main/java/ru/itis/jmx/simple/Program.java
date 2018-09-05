package ru.itis.jmx.simple;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * 05.09.2018
 * Program
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Program {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer server
                = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("ru.itis.jmx.simple:type=cache1");
        StringsCache cache = new StringsCache();
        server.registerMBean(cache, name);

        Thread.sleep(Long.MAX_VALUE);

    }
}
