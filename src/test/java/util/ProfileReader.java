package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Singleton Profile reader
 */
public class ProfileReader {

    private String urlKey = "url";
    private String osKey = "platform";
    private String browserKey = "browser";


    private String path = "." + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator +
            "profiles";

    private static ProfileReader reader = null;

    private ProfileReader() throws IOException {
        String profileName = System.getProperty(Constants.PROFILE);
        if (profileName == null || profileName.length() == 0) {
            profileName = "local-mac";
        }
        String filePath = path + File.separator + profileName + ".properties";
        Properties properties = new Properties();
        InputStream stream = null;
        try {
            stream = new FileInputStream(new File(filePath));
            properties.load(stream);
            assign(properties);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    public static ProfileReader getInstance() throws IOException {
        if (reader == null) {
            reader = new ProfileReader();
        }
        return reader;
    }

    private void assign(Properties properties) {
        setUrl(System.getProperty("url", (String) properties.get(urlKey)));
        setOS(System.getProperty("os", (String) properties.get(osKey)));
        setBrowser(System.getProperty("browser", (String) properties.get(browserKey)));
    }


    public String getUrl() {
        return urlKey;
    }

    public void setUrl(String url) {
        this.urlKey = url;
    }

    public String getOS() {
        return osKey;
    }

    public void setOS(String os) {
        this.osKey = os;
    }

    public String getBrowser() {
        return browserKey;
    }

    public void setBrowser(String browser) {
        this.browserKey = browser;
    }

}
