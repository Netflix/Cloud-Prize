/**
 * 
 */
package com.zscaler.cassandra.astyanax.metrics;

/**
 * 
 * provides all the required parameters for making connection to cassandra
 * server using astyanax client Returns the default values in case parameters
 * wont be supplied using setter methods
 * 
 * @author Sindhu
 */
public class ConnectionFactory {
	private String hostAddress;
	private String clusterName;
	private String portNumber;
	private String cqlPortNumber;
	private String keyspaceName;
	private String maxConnectionPerHost;
	private String connectionPoolName;

	private final String defaultHostAddress = null;
	private final String defaultClusterName = null;
	private final String defaultPortNumber = "9160";
	private final String defaultCqlPortNumber = "9042";
	private final String defaultKeyspaceName = null;
	private final String defaultMaxConnectionPerHost = "1";
	private final String defaultConnectionPoolName = "MyConnectionPool";

	private static final ConnectionFactory connectionFactorySingleton = new ConnectionFactory();

	private ConnectionFactory() {

	}

	/** returns singleton instance of Connection factory */
	public static ConnectionFactory getInstance() {
		return connectionFactorySingleton;
	}

	/** setter method for host address */
	public void setHostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}

	/** setter method for Cluster Name */
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	/** setter method for port Number */
	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}

	/** setter method for cql port number */
	public void setCqlPortNumber(String cqlPortNumber) {
		this.cqlPortNumber = cqlPortNumber;
	}

	/** setter method for Keyspace Name */
	public void setKeyspaceName(String keyspaceName) {
		this.keyspaceName = keyspaceName;
	}

	/** setter method for Max connection per Host */
	public void setMaxConnPerHost(String maxConnPerHost) {
		this.maxConnectionPerHost = maxConnPerHost;
	}

	/** setter method for connection pool name */
	public void setConnectionPoolName(String connectionPoolName) {
		this.connectionPoolName = connectionPoolName;
	}

	/**
	 * getter method for host address , will provide default value in case of no
	 * input from setter method
	 */
	public String getHostAddress() {
		return hostAddress == null ? defaultHostAddress : hostAddress;
	}

	/**
	 * getter method for cluster name , will provide default value in case of no
	 * input from setter method
	 */
	public String getClusterName() {

		return clusterName == null ? defaultClusterName : clusterName;
	}

	/**
	 * getter method for port number , will provide default value in case of no
	 * input from setter method
	 */
	public int getPortNumber() {

		return portNumber == null ? Integer.parseInt(defaultPortNumber)
				: Integer.parseInt(portNumber);
	}

	public int getCqlPortNumber() {
		return cqlPortNumber == null ? Integer.parseInt(defaultCqlPortNumber)
				: Integer.parseInt(cqlPortNumber);
	}

	/**
	 * getter method for keyspace name , will provide default value in case of
	 * no input from setter method
	 */
	public String getKeyspaceName() {

		return keyspaceName == null ? defaultKeyspaceName : keyspaceName;
	}

	/**
	 * getter method for host max connection per host , will provide default
	 * value in case of no input from setter method
	 */
	public int getMaxConnPerHost() {

		return maxConnectionPerHost == null ? Integer
				.parseInt(defaultMaxConnectionPerHost) : Integer
				.parseInt(maxConnectionPerHost);
	}

	/**
	 * getter method for connection pool name , will provide default value in
	 * case of no input from setter method
	 */
	public String getConnectionPoolName() {

		return connectionPoolName == null ? defaultConnectionPoolName
				: connectionPoolName;

	}

}
