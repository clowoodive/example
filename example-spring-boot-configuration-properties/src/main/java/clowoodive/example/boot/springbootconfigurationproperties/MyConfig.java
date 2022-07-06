package clowoodive.example.boot.springbootconfigurationproperties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

@Setter
@Getter
@Configuration
//@PropertySource("classpath:my.properties")
@ConfigurationProperties(prefix = "my.account")
//@ConfigurationPropertiesScan
public class MyConfig {
    private int myId;
    private String myName;
    private InetAddress myIpAddress;
    private int port;

    public void setMyId(int myId) {
        this.myId = myId;
    }

//    public void setPort(int port) {
//        this.port = port;
//    }
//
//    public void setMyName(String myName) {
//        this.myName = myName;
//    }
//
//    public void setMyIpAddress(InetAddress myIpAddress) {
//        this.myIpAddress = myIpAddress;
//    }
}
