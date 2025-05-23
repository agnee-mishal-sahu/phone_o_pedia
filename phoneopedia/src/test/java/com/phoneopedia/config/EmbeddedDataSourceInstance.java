package com.phoneopedia.config;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.config.Charset.UTF8;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.config.SchemaConfig.aSchemaConfig;

import javax.annotation.PreDestroy;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.Charset;
import com.wix.mysql.config.MysqldConfig;
import com.wix.mysql.config.SchemaConfig;
import com.wix.mysql.distribution.Version;

/**
 * Wix Embedded MySql DB configuration see https://github.com/wix/wix-embedded-mysql
 */
@Profile("test")
@Component
public class EmbeddedDataSourceInstance implements ApplicationContextInitializer<ConfigurableApplicationContext> {

  EmbeddedMysql mysqld;

  /**
   * {@inheritDoc}
   */
  @Override
  public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

    MysqldConfig config = aMysqldConfig(Version.v5_7_latest).withCharset(Charset.UTF8).withPort(2215)
        .withUser("Entercard", "3N73rc4rd").withTimeZone("UTC").withServerVariable("max_connect_errors", 666).build();

    SchemaConfig CUSTOMERDETAILS = aSchemaConfig("demo").withCharset(UTF8).build();

    this.mysqld = anEmbeddedMysql(config).addSchema(CUSTOMERDETAILS).start();
  }

  /**
   *
   */
  @PreDestroy
  public void destroy() {

    if (null != this.mysqld) {
      this.mysqld.stop();
    }
  }

}
