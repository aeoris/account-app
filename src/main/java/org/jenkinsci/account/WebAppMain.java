package org.jenkinsci.account;

import org.kohsuke.stapler.framework.AbstractWebAppMain;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Kohsuke Kawaguchi
 */
public class WebAppMain extends AbstractWebAppMain<Application> {
    public WebAppMain() {
        super(Application.class);
    }

    @Override
    protected String getApplicationName() {
        return "APP";
    }

    @Override
    public Application createApplication() throws Exception {
        Properties config = new Properties();
        FileInputStream in = new FileInputStream("config.properties");
        try {
            config.load(in);
            return new Application(config);
        } finally {
            in.close();
        }
    }
}
