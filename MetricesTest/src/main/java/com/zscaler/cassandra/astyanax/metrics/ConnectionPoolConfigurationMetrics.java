package com.zscaler.cassandra.astyanax.metrics;

import java.util.List;

import com.netflix.astyanax.AstyanaxContext;
import com.netflix.astyanax.Keyspace;
import com.yammer.metrics.core.Gauge;
import com.yammer.metrics.core.MetricsRegistry;
import com.zscaler.cassandra.astyanax.metrics.ConfigurationFactory;

/**
 * implementation of the Connection Pool configuration metrics . this
 * implementation requires connection with cassandra using astyanax . gauge will
 * hold value for each configuration which is being stored in Metric registry .
 * 
 * @author Sindhu
 * 
 */
public class ConnectionPoolConfigurationMetrics {

	private final static MetricsRegistry connectionPoolConfigurationRegistry = ConfigurationFactory
			.getRegistryInstance();

	private static final ConnectionPoolConfigurationMetrics connectionPoolConfigurationSingleton = new ConnectionPoolConfigurationMetrics();

	private ConnectionPoolConfigurationMetrics() {

	}

	/**
	 * provides the singleton instance of the ConnectionPoolConfigurationMetrics
	 */
	public static ConnectionPoolConfigurationMetrics getInstance() {
		return connectionPoolConfigurationSingleton;
	}

	AstyanaxContext<Keyspace> connectionPoolConfigurationContext = Connection
			.startConnection();

	/** register port number to the connectionPoolConfigurationRegistry */
	private final Gauge<Integer> PortNumber = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class, "PortNumber",
					new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration().getPort();
						}
					});

	/** register connection pool name to the connectionPoolConfigurationRegistry */
	private final Gauge<String> ConnectionPoolName = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"ConnectionPoolName ", new Gauge<String>() {
						@Override
						public String value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration().getName();
						}
					});

	/**
	 * register max connection per host to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Integer> MaxConnPerHost = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"MaxConnPerHost", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getMaxConnsPerHost();
						}
					});

	/**
	 * register initial connection per host to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Integer> InitialConnPerHost = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"InitialConnPerHost", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getInitConnsPerHost();
						}
					});

	/**
	 * register max connection in Pool to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Integer> MaxConnInPool = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"MaxConnInPool", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getMaxConns();
						}
					});

	/**
	 * register MaxTimeoutWhenExhausted to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Integer> MaxTimeoutWhenExhausted = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"MaxTimeoutWhenExhausted", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getMaxTimeoutWhenExhausted();
						}
					});

	/** register MaxFailoverCount to the connectionPoolConfigurationRegistry */
	private final Gauge<Integer> MaxFailoverCount = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"MaxFailoverCount", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getMaxFailoverCount();
						}
					});

	/** register Seeds to the connectionPoolConfigurationRegistry */
	private final Gauge<String> Seeds = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class, "Seeds",
					new Gauge<String>() {
						@Override
						public String value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getSeeds();
						}
					});

	/** register SeedHosts to the connectionPoolConfigurationRegistry */
	private final Gauge<List> SeedHosts = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class, "SeedHosts",
					new Gauge<List>() {
						@Override
						public List value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getSeedHosts();
						}
					});

	/** register LocalDatacenter to the connectionPoolConfigurationRegistry */
	private final Gauge<String> LocalDatacenter = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"LocalDatacenter", new Gauge<String>() {
						@Override
						public String value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getLocalDatacenter();
						}
					});

	/**
	 * register SocketReadWriteTimeOut to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Integer> SocketReadWriteTimeOut = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"SocketReadWriteTimeout", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getSocketTimeout();
						}
					});

	/** register SocketConnectTimeOut to the connectionPoolConfigurationRegistry */
	private final Gauge<Integer> SocketConnectTimeOut = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"SocketConnectTimeOut", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getConnectTimeout();
						}
					});

	/**
	 * register ConnectionLimitWindowSize to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Integer> ConnectionLimitWindowSize = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"ConnectionLimitWindowSize", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getConnectionLimiterWindowSize();
						}
					});

	/**
	 * register ConnectionLimiterMaxPendingCount to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Integer> ConnectionLimiterMaxPendingCount = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"ConnectionLimiterMaxPendingCount", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getConnectionLimiterMaxPendingCount();
						}
					});

	/**
	 * register LatencyAwareWindowSize to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Integer> LatencyAwareWindowSize = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"LatencyAwareWindowSize", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getLatencyAwareWindowSize();
						}
					});

	/**
	 * register LatencyAwareSentinelCompare to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Float> LatencyAwareSentinelCompare = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"LatencyAwareSentinelCompare", new Gauge<Float>() {
						@Override
						public Float value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getLatencyAwareSentinelCompare();
						}
					});

	/**
	 * register LatencyAwareBadnessThreshold to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Float> LatencyAwareBadnessThreshold = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"LatencyAwareBadnessThreshold", new Gauge<Float>() {
						@Override
						public Float value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getLatencyAwareBadnessThreshold();
						}
					});

	/**
	 * register BlockedThreadThreshold to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Integer> BlockedThreadThreshold = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"BlockedThreadThreshold", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getBlockedThreadThreshold();
						}
					});

	/** register MinHostInPoolRatio to the connectionPoolConfigurationRegistry */
	private final Gauge<Float> MinHostInPoolRatio = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"MinHostInPoolRatio", new Gauge<Float>() {
						@Override
						public Float value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getMinHostInPoolRatio();
						}
					});

	/**
	 * register LatencyAwareUpdateInterval to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Integer> LatencyAwareUpdateInterval = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"LatencyAwareUpdateInterval", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getLatencyAwareUpdateInterval();
						}
					});

	/**
	 * register LatencyAwareResetInterval to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Integer> LatencyAwareResetInterval = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"LatencyAwareResetInterval", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getLatencyAwareResetInterval();
						}
					});

	/**
	 * register MaxPendingConnectionsPerHost to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Integer> MaxPendingConnectionsPerHost = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"MaxPendingConnectionsPerHost", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getMaxPendingConnectionsPerHost();
						}
					});

	/**
	 * register MaxBlockedThreadsPerHost to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Integer> MaxBlockedThreadsPerHost = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"MaxBlockedThreadsPerHost", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getMaxBlockedThreadsPerHost();
						}
					});

	/** register TimeoutWindow to the connectionPoolConfigurationRegistry */
	private final Gauge<Integer> TimeoutWindow = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"TimeoutWindow", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getTimeoutWindow();
						}
					});

	/** register MaxTimeoutCount to the connectionPoolConfigurationRegistry */
	private final Gauge<Integer> MaxTimeoutCount = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"MaxTimeoutCount", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getMaxTimeoutCount();
						}
					});

	/** register RetrySuspendWindow to the connectionPoolConfigurationRegistry */
	private final Gauge<Integer> RetrySuspendWindow = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"RetrySuspendWindow", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getRetrySuspendWindow();
						}
					});
	/** register RetryMaxDelaySlice to the connectionPoolConfigurationRegistry */
	private final Gauge<Integer> RetryMaxDelaySlice = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"RetryMaxDelaySlice", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getRetryMaxDelaySlice();
						}
					});

	/** register RetryDelaySlice to the connectionPoolConfigurationRegistry */
	private final Gauge<Integer> RetryDelaySlice = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"RetryDelaySlice", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getRetryDelaySlice();
						}
					});

	/**
	 * register MaxOperationsPerConnection to the
	 * connectionPoolConfigurationRegistry
	 */
	private final Gauge<Integer> MaxOperationsPerConnection = connectionPoolConfigurationRegistry
			.newGauge(ConnectionPoolConfigurationMetrics.class,
					"MaxOperationsPerConnection", new Gauge<Integer>() {
						@Override
						public Integer value() {
							return connectionPoolConfigurationContext
									.getConnectionPoolConfiguration()
									.getMaxOperationsPerConnection();
						}
					});

	/** getter method for port number */
	public Gauge<Integer> getPortNumber() {
		return PortNumber;
	}

	/** getter method for connection pool name */
	public Gauge<String> getConnectionPoolName() {
		return ConnectionPoolName;
	}

	/** getter method for max connection per host */
	public Gauge<Integer> getMaxConnPerHost() {
		return MaxConnPerHost;
	}

	/** getter method for initial connection per host */
	public Gauge<Integer> getInitialConnPerHost() {
		return InitialConnPerHost;
	}

	/** getter method for max connection in pool */
	public Gauge<Integer> getMaxConnInPool() {
		return MaxConnInPool;
	}

	/** getter method for max time when exhausted */
	public Gauge<Integer> getMaxTimeoutWhenExhausted() {
		return MaxTimeoutWhenExhausted;
	}

	/** getter method for max faliovercount */
	public Gauge<Integer> getMaxFailoverCount() {
		return MaxFailoverCount;
	}

	/** getter method for seeds */

	public Gauge<String> getSeeds() {
		return Seeds;
	}

	/** getter method for seed hosts */
	public Gauge<List> getSeedHosts() {
		return SeedHosts;
	}

	/** getter method for local datacenter */
	public Gauge<String> getLocalDatacenter() {
		return LocalDatacenter;
	}

	/** getter method for socket read write time out */
	public Gauge<Integer> getSocketReadWriteTimeOut() {
		return SocketReadWriteTimeOut;
	}

	/** getter method for socket connect time out */
	public Gauge<Integer> getSocketConnectTimeOut() {
		return SocketConnectTimeOut;
	}

	/** getter method for connection limit window size */
	public Gauge<Integer> getConnectionLimitWindowSize() {
		return ConnectionLimitWindowSize;
	}

	/** getter method for connection limit max pending count */
	public Gauge<Integer> getConnectionLimiterMaxPendingCount() {
		return ConnectionLimiterMaxPendingCount;
	}

	/** getter method for latency aware window size */
	public Gauge<Integer> getLatencyAwareWindowSize() {
		return LatencyAwareWindowSize;
	}

	/** getter method for letency aware sentinel compare */
	public Gauge<Float> getLatencyAwareSentinelCompare() {
		return LatencyAwareSentinelCompare;
	}

	/** getter method for latency aware badness threshold */
	public Gauge<Float> getLatencyAwareBadnessThreshold() {
		return LatencyAwareBadnessThreshold;
	}

	/** getter method for blocked thread threshhold */
	public Gauge<Integer> getBlockedThreadThreshold() {
		return BlockedThreadThreshold;
	}

	/** getter method for min host in pool ratio */
	public Gauge<Float> getMinHostInPoolRatio() {
		return MinHostInPoolRatio;
	}

	/** getter method for latency aware update interval */
	public Gauge<Integer> getLatencyAwareUpdateInterval() {
		return LatencyAwareUpdateInterval;
	}

	/** getter method for latency aware reset interval */

	public Gauge<Integer> getLatencyAwareResetInterval() {
		return LatencyAwareResetInterval;
	}

	/** getter method for MaxPendingConnectionsPerHost */
	public Gauge<Integer> getMaxPendingConnectionsPerHost() {
		return MaxPendingConnectionsPerHost;
	}

	/** getter method for MaxBlockedThreadsPerHost */
	public Gauge<Integer> getMaxBlockedThreadsPerHost() {
		return MaxBlockedThreadsPerHost;
	}

	/** getter method for TimeoutWindow */
	public Gauge<Integer> getTimeoutWindow() {
		return TimeoutWindow;
	}

	/** getter method for MaxTimeoutCount */
	public Gauge<Integer> getMaxTimeoutCount() {
		return MaxTimeoutCount;
	}

	/** getter method for RetrySuspendWindow */
	public Gauge<Integer> getRetrySuspendWindow() {
		return RetrySuspendWindow;
	}

	/** getter method for RetryMaxDelaySlice */

	public Gauge<Integer> getRetryMaxDelaySlice() {
		return RetryMaxDelaySlice;
	}

	/** getter method for RetryDelaySlice */
	public Gauge<Integer> getRetryDelaySlice() {
		return RetryDelaySlice;
	}

	/** getter method for MaxOperationsPerConnection */
	public Gauge<Integer> getMaxOperationsPerConnection() {
		return MaxOperationsPerConnection;
	}

	/** provide the metric registry filled with all the gauge values */
	public static MetricsRegistry getConnPoolConfigurationRegistry() {
		return connectionPoolConfigurationRegistry;
	}
}
