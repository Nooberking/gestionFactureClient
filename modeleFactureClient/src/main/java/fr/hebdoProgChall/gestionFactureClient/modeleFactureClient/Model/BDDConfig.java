package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BDDConfig {
    private String type;
    private String version;
    private String name;
    private String url;
    private String driver;
    private String username;
    private String password;

    public BDDConfig() {
    }

    public BDDConfig(String type, String version, String name, String url, String driver, String username, String password) {
        this.type = type;
        this.version = version;
        this.name = name;
        this.url = url;
        this.driver = driver;
        this.username = username;
        this.password = password;
    }
    @XmlElement
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlElement
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @XmlElement
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
