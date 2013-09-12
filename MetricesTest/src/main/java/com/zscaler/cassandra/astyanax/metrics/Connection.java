package com.zscaler.cassandra.astyanax.metrics;

import org.apache.log4j.Logger;

import com.datastax.driver.core.Cluster;

import com.netflix.astyanax.AstyanaxContext;
import com.netflix.astyanax.Keyspace;
import com.netflix.astyanax.connectionpool.NodeDiscoveryType;
import com.netflix.astyanax.connectionpool.impl.ConnectionPoolConfigurationImpl;
import com.netflix.astyanax.connectionpool.impl.CountingConnectionPoolMonitor;
import com.netflix.astyanax.impl.AstyanaxConfigurationImpl;
import com.netflix.astyanax.thrift.ThriftFamilyFactory;
import com.zscaler.cassandra.astyanax.metrics.ConnectionPoolConfigurationReport;

/**
 * implementation for the astyanax connection makes connection with cassandra
 * server using astyanax client with the given input and to start Metrices
 * reports methods
 * 
 * @author Sindhu
 * 
 */

public class Connection {

	private static final Logger logger = Logger.getLogger(Connection.class);
	private static ConnectionFactory connectionFactoryInstance = ConnectionFactory
			.getInstance();

	/** Used for starting connection to cassandra server with astyanax client */

	public static AstyanaxContext<Keyspace> startConnection() {

		AstyanaxContext<Keyspace> context = new AstyanaxContext.Builder()
				.forCluster(connectionFactoryInstance.getClusterName())
				.forKeyspace(connectionFactoryInstance.getKeyspaceName())
				.withAstyanaxConfiguration(
						new AstyanaxConfigurationImpl()
								.setDiscoveryType(NodeDiscoveryType.NONE))
				.withConnectionPoolConfiguration(
						new ConnectionPoolConfigurationImpl(
								connectionFactoryInstance
										.getConnectionPoolName())
								.setPort(
										connectionFactoryInstance
												.getPortNumber())
								.setMaxConnsPerHost(
										connectionFactoryInstance
												.getMaxConnPerHost())
								.setSeeds(
										connectionFactoryInstance
												.getHostAddress()))
				.withConnectionPoolMonitor(new CountingConnectionPoolMonitor())
				.buildKeyspace(ThriftFamilyFactory.getInstance());

		context.start();
		logger.debug("Connected to cluster:"
				+ connectionFactoryInstance.getClusterName() + "  "
				+ "with port number :"
				+ connectionFactoryInstance.getPortNumber() + " "
				+ "to the keyspace: "
				+ connectionFactoryInstance.getKeyspaceName() + " "
				+ "using host address :"
				+ connectionFactoryInstance.getHostAddress());

		return context;
	}

	private static void connectionSt(String... inputNode) {

		Cluster.builder().addContactPoints(inputNode)
				.withPort(connectionFactoryInstance.getCqlPortNumber()).build();

	}

	/** instantiate connection and report generator methods */
	public static void generateAstyanaxMetrics() {
		startConnection();
		ConnectionPoolConfigurationReport
				.generateConnectionPoolConfigurationReport();
		ConnectionPoolMonitorReport.generateConnectionPoolMonitorReport();
		Connection.connectionSt(connectionFactoryInstance.getHostAddress());

	}

}