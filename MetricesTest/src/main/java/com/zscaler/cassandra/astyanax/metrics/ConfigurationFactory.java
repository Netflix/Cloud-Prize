package com.zscaler.cassandra.astyanax.metrics;

import java.util.concurrent.TimeUnit;

import com.yammer.metrics.core.MetricsRegistry;

/**
 * implementation of the Configuration Factory class Provides all the
 * configuration input for the JmxReporter (Csv Reporter and Console Reporter)
 * 
 * @author Sindhu
 * 
 */

public class ConfigurationFactory {
	private String period;
	private TimeUnit timeUnit;
	private String fileDestinationConnPoolMonitorReport;
	private String fileDestinationConnPoolConfigurationReport;

	private String defaultPeriod = "1";
	private TimeUnit defaultTimeUnit = TimeUnit.SECONDS;
	private String defaultFileDestinationConnPoolMonitorReport = System
			.getProperties().getProperty("user.home");
	private String defaultFileDestinationConnPoolConfReport = System
			.getProperties().getProperty("user.home");

	private static final ConfigurationFactory configurationFactorySingleton = new ConfigurationFactory();

	private ConfigurationFactory() {

	}

	/** returns singleton instance of configuration factory */
	public static ConfigurationFactory getInstance() {
		return configurationFactorySingleton;
	}

	/** generates singleton instance of Metric Registry */

	private static final MetricsRegistry metricsRegistrySingleton = new MetricsRegistry();

	public static MetricsRegistry getRegistryInstance() {

		return metricsRegistrySingleton;
	}

	/** setter method for period input in ConsoleReporter and CSVreporter */
	public void setPeriod(String period) {
		this.period = period;
	}

	/** setter method for timeunit input in in ConsoleReporter and CSVreporter */
	public void setTimeunit(TimeUnit timeunit) {
		this.timeUnit = timeunit;
	}

	/**
	 * setter method for file location input in CSVreporter for connection pool
	 * monitor
	 */
	public void setFileDestinationConnPoolMonitorReport(
			String fileDestinationCPMreport) {
		this.fileDestinationConnPoolMonitorReport = fileDestinationCPMreport;
	}

	/**
	 * setter method for file location input in CSVreporter for connection pool
	 * configuration
	 */
	public void setFileDestinationConnPoolConfReport(
			String fileDestinationCPCreport) {
		this.fileDestinationConnPoolConfigurationReport = fileDestinationCPCreport;
	}

	/** getter method for period will return default value in case of null value */
	public long getPeriod() {
		return period == null ? Long.parseLong(defaultPeriod) : Long
				.parseLong(period);

	}

	/**
	 * getter method for time unit, will return default value in case of null
	 * value
	 */
	public TimeUnit getTimeunit() {

		return timeUnit == null ? defaultTimeUnit : timeUnit;
	}

	/**
	 * getter method for file location in csv reporter for connection pool
	 * monitor, will return default value in case of null value
	 */
	public String getFileDestinationConnPoolMonitorReport() {

		return fileDestinationConnPoolMonitorReport == null ? defaultFileDestinationConnPoolMonitorReport
				: fileDestinationConnPoolMonitorReport;
	}

	/**
	 * getter method for file location in csv reporter for connection pool
	 * configuration, will return default value in case of null value
	 */
	public String getFileDestinationConnPoolConfReport() {

		return fileDestinationConnPoolConfigurationReport == null ? defaultFileDestinationConnPoolConfReport
				: fileDestinationConnPoolConfigurationReport;
	}

}
