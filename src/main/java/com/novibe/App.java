package com.novibe;


import com.novibe.common.DnsTaskRunner;
import com.novibe.common.config.EnvironmentVariables;
import com.novibe.common.util.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

    public static ApplicationContext context;

    static void main() {
        String provider = EnvironmentVariables.DNS.toUpperCase();

        String commonsBasePackage = "com.novibe.common";

        String dnsBasePackage = switch (provider) {
            case "CLOUDFLARE" -> "com.novibe.dns.cloudflare";
            case "NEXTDNS" -> "com.novibe.dns.next_dns";
            default -> {
                Log.fail(
                "Unsupported DNS provider! Must be CLOUDFLARE or NEXTDNS. Was: " + provider);
                System.exit(1);
                yield null;
            }
        };

        context = new AnnotationConfigApplicationContext(dnsBasePackage, commonsBasePackage);

        DnsTaskRunner runner = context.getBean(DnsTaskRunner.class);
        runner.run();
    }

}
