package org.key.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@ServletComponentScan
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return configureApplication(builder);
    }

    public static void main(String[] args) {
        configureApplication(new SpringApplicationBuilder()).run(args);
    }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        LOG.info("Starting application ...\n"
                + "   _____                       _         _____            _               ____              _\n"
                + "  / ____|                     | |       / ____|          (_)             |  _ \\            | | \n"
                + " | (___   __ _ _ __ ___  _ __ | | ___  | (___  _ __  _ __ _ _ __   __ _  | |_) | ___   ___ | |_ \n"
                + "  \\___ \\ / _` | '_ ` _ \\| '_ \\| |/ _ \\  \\___ \\| '_ \\| '__| | '_ \\ / _` | |  _ < / _ \\ / _ \\| __|\n"
                + "  ____) | (_| | | | | | | |_) | |  __/  ____) | |_) | |  | | | | | (_| | | |_) | (_) | (_) | |_ \n"
                + " |_____/ \\__,_|_| |_| |_| .__/|_|\\___| |_____/| .__/|_|  |_|_| |_|\\__, | |____/ \\___/ \\___/ \\__|\n"
                + "                        | |                   | |                  __/ |\n"
                + "                        |_|                   |_|                 |___/");

        return builder.sources(Application.class).bannerMode(Banner.Mode.OFF);
    }

}
