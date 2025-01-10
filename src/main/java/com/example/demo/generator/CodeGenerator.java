package com.example.demo.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    public static void main(String[] args) {

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D://IdeaProject//myVue//vchart-serve"+"/src/main/java");

        gc.setServiceName("%sService");	//去掉Service接口的首字母I
        gc.setAuthor("wyn");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/demo?serverTimezone=GMT%2B8&useSSL=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);

//        dsc.setUrl("jdbc:postgresql://localhost:5432/coalqd");
//        dsc.setDriverName("org.postgresql.Driver");
//        dsc.setUsername("postgres");
//        dsc.setPassword("root");
//        dsc.setDbType(DbType.POSTGRE_SQL);


        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example.demo");
        //pc.setModuleName("system"); //模块名
        pc.setController("controller");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 6、模板配置
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null); // 禁用默认的 XML 生成


        //自定义配置
        InjectionConfig cfg =new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };

        //自定义输出配置
        List<FileOutConfig> focList =new ArrayList<>();

        String projectPath ="D://IdeaProject//myVue//vchart-serve";

        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;

            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(templateConfig);


        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();

//        strategy.setInclude("coal_inspection_details",
//                "coal_quality_inspection",
//                "coal_quality_inspection_detail" ,
//                "coal_sampling_data",
//                "coal_sampling_details",
//                "conveyor_belt_sampling_data",
//                "conveyor_belt_sampling_details");

        strategy.setInclude("sys_role","sys_role_permission","sys_permission","sys_user_role");

        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作

        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }
}
