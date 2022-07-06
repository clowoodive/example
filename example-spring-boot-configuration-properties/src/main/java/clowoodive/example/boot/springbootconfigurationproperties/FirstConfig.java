package clowoodive.example.boot.springbootconfigurationproperties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "my.account")
public class FirstConfig {
    private int myId;
    private String myName;
    private InetAddress myIpAddress;
    private int port;
}
