/**
 * 
 */
/**
 * @author DELL
 *
 */
package com.fivefu.apply.common;

import java.util.Scanner;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 自动生成代码
 * @author DELL
 *
 */
//https://mp.baomidou.com/config/generator-config.html#strategy
public class MyBatisCodeGenerator {

	/**
	 * <p>
	 * 读取控制台内容
	 * </p>
	 */
	public static String scanner(String tip) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		StringBuilder help = new StringBuilder();
		help.append("请输入" + tip + "：");
		System.out.println(help.toString());
		if (scanner.hasNext()) {
			String ipt = scanner.next();
			if (StringUtils.isNotEmpty(ipt)) {
				return ipt;
			}
		}
		throw new MybatisPlusException("请输入正确的" + tip + "！");
	}
	
	public  static void generateByTables(String... tableNames){
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();
	
		String projectPath = System.getProperty("user.dir"); // 当前项目目录
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setAuthor("DELL").setOutputDir(projectPath + "/src/main/java")
				.setFileOverride(true)//覆盖现有文件
				.setServiceName("%sService")//.setSwagger2(true)
				.setOpen(false).setBaseResultMap(true);
		mpg.setGlobalConfig(gc);
	
		// 数据源配置
		String dbUrl = "jdbc:mysql://localhost:3306/szcg_red?useUnicode=true&amp;characterEncoding=UTF-8&useSSL=true";
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setDbType(DbType.MYSQL).setUrl(dbUrl)
				.setUsername("root").setPassword("123456")
				.setDriverName("com.mysql.jdbc.Driver");
		mpg.setDataSource(dataSourceConfig);
	
		// 包配置
		PackageConfig pc = new PackageConfig();
		// pc.setModuleName(scanner("模块名"));
		pc.setParent(null)
		.setXml("mybatis")
		.setParent("com.fivefu.apply");
		mpg.setPackageInfo(pc);
	
		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel)
		.setColumnNaming(NamingStrategy.underline_to_camel)
		//.setInclude(scanner("表名"))
		.setInclude(tableNames)
		.setRestControllerStyle(true)
		.setSuperControllerClass("com.fivefu.apply.controller.BaseController")
		.setControllerMappingHyphenStyle(true)
		.setTablePrefix(pc.getModuleName() + "_");
		mpg.setStrategy(strategy);
		mpg.execute();
		
	}
	
	
	public static void main(String[] args) {
		generateByTables("db_apply_count");
	}
}