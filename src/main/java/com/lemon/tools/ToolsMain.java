package com.lemon.tools;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/11/13
 */
public class ToolsMain {
    public static void main(String[] args) {
        generator();
    }

    private static void generator() {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;

        try {
            System.out.println(ToolsMain.class.getClassLoader());
            System.out.println(ToolsMain.class.getResource("/").getPath());
            File configFile = new File(ToolsMain.class.getResource("/").getPath()+"generator_mysql.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config  = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            System.out.println(warnings.size());
            myBatisGenerator.generate(null);
            System.out.println(">>>>>>>>>>>>>>>>>>");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
