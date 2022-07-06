package clowoodive.example.boot.springbootconfigurationproperties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.InetAddress;

@Setter
@Getter
@ConfigurationProperties(prefix = "my.account")
public class FourthConfig {
    private int myId;
    private String myName;
    private InetAddress myIpAddress;
    private int port;
}
