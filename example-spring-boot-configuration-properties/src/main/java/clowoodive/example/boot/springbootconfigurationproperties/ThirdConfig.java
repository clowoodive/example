package clowoodive.example.boot.springbootconfigurationproperties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

@Setter
@Getter
@ConfigurationProperties(prefix = "my.account")
@Configuration
@ConfigurationPropertiesScan
public class ThirdConfig {
    private int myId;
    private String myName;
    private InetAddress myIpAddress;
    private int port;
}
