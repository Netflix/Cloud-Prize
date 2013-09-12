
package com.zscaler.cassandra.astyanax.metrics;







import com.netflix.astyanax.AstyanaxContext;

import com.netflix.astyanax.Keyspace;

import com.yammer.metrics.core.Gauge;
import com.yammer.metrics.core.MetricsRegistry;
import com.yammer.metrics.core.Timer;



/**
 *  implementation of the Connection Pool Monitoring metrics .
 * this implementation requires connection with cassandra using astyanax .
 * gauge will hold value for each configuration which is being stored in 
 * Metric registry .
 * 
 * @author Sindhu
 *
 */
public class ConnectionPoolMonitorMetrics {

	
	private static MetricsRegistry connectionPoolMonitorRegistry = ConfigurationFactory.getRegistryInstance();
	
	private static final ConnectionPoolMonitorMetrics connectionPoolMonitorSingleton=new ConnectionPoolMonitorMetrics();
	 
	private ConnectionPoolMonitorMetrics(){
		 
	 }

	
	 /** provides singleton instance of ConnectionPoolMonitorMetrics */
	 public static ConnectionPoolMonitorMetrics getInstance(){
		 return connectionPoolMonitorSingleton;
	 }

    private final Timer requests = connectionPoolMonitorRegistry.newTimer(ConnectionPoolMonitorMetrics.class, "requests");
  
    AstyanaxContext<Keyspace> connectionPoolMonitorContext=Connection.startConnection();
  
    /** register no host count to the connectionPoolMonitorRegistry */
    private final Gauge<Long> NoHostCount = connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "NoHostCount", new Gauge<Long>() {
        @Override
        public Long value() {
            return   connectionPoolMonitorContext.getConnectionPoolMonitor().getNoHostCount();
        }
    });
    
    /** register ConnectionReturnedCount to the connectionPoolMonitorRegistry */
    private final Gauge<Long> ConnectionReturnedCount= connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "ConnectionReturnedCount", new Gauge<Long>() {
        @Override
        public Long value() {
            
        	return  connectionPoolMonitorContext.getConnectionPoolMonitor().getConnectionReturnedCount();
        }
    });
    
    /** register ConnectionBorrowedCount to the connectionPoolMonitorRegistry */
    private final Gauge<Long> ConnectionBorrowedCount = connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "ConnectionBorrowedCount", new Gauge<Long>() {
        @Override
        public Long value() {
         
        	return connectionPoolMonitorContext.getConnectionPoolMonitor().getConnectionBorrowedCount();
        
        }
    });
    
    /** register ConnectionCreatedCount to the connectionPoolMonitorRegistry */
    private final Gauge<Long> getConnectionCreatedCount = connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "getConnectionCreatedCount", new Gauge<Long>() {
        @Override
        public Long value() {
        
        	return  connectionPoolMonitorContext.getConnectionPoolMonitor().getConnectionCreatedCount();
        }
    });
    

    /** register ConnectionCreateFailedCount to the connectionPoolMonitorRegistry */
       
    private final Gauge<Long> getConnectionCreateFailedCount = connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "getConnectionCreateFailedCount", new Gauge<Long>() {
        @Override
        public Long value() {
        
        	return  connectionPoolMonitorContext.getConnectionPoolMonitor().getConnectionCreateFailedCount();
        }
    });
    
    /** register FailoverCount to the connectionPoolMonitorRegistry */
    private final Gauge<Long> FailoverCount = connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "FailoverCount", new Gauge<Long>() {
        @Override
        public Long value() {
        
        	return  connectionPoolMonitorContext.getConnectionPoolMonitor().getFailoverCount();
        }
    });
    
    /** register InterruptedCount to the connectionPoolMonitorRegistry */
    private final Gauge<Long> InterruptedCount = connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "InterruptedCount", new Gauge<Long>() {
        @Override
        public Long value() {
      
        	return  connectionPoolMonitorContext.getConnectionPoolMonitor().getInterruptedCount();
        }
    });
    
    /** register ConnectionClosedCount to the connectionPoolMonitorRegistry */
    private final Gauge<Long> ConnectionClosedCount = connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "ConnectionClosedCount", new Gauge<Long>() {
        @Override
        public Long value() {
        
        	return  connectionPoolMonitorContext.getConnectionPoolMonitor().getConnectionClosedCount();
        }
    });

    /** register OperationFailureCount to the connectionPoolMonitorRegistry */
    private final Gauge<Long> OperationFailureCount = connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "OperationFailureCount", new Gauge<Long>() {
        @Override
        public Long value() {
         
        	return  connectionPoolMonitorContext.getConnectionPoolMonitor().getOperationFailureCount();
        }
    });
    
    /** register BadRequestCount to the connectionPoolMonitorRegistry */
    private final Gauge<Long> BadRequestCount = connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "BadRequestCount", new Gauge<Long>() {
        @Override
        public Long value() {
       
        	return  connectionPoolMonitorContext.getConnectionPoolMonitor().getBadRequestCount();
        }
    });
    
    /** register OperationSuccessCount to the connectionPoolMonitorRegistry */
    private final Gauge<Long> OperationSuccessCount = connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "OperationSuccessCount", new Gauge<Long>() {
        @Override
        public Long value() {
       
        	return  connectionPoolMonitorContext.getConnectionPoolMonitor().getOperationSuccessCount();
        }
    });
    
    /** register OperationTimeoutCount to the connectionPoolMonitorRegistry */
    private final Gauge<Long> OperationTimeoutCount = connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "OperationTimeoutCount", new Gauge<Long>() {
        @Override
        public Long value() {
        
        	return   connectionPoolMonitorContext.getConnectionPoolMonitor().getOperationTimeoutCount();
        }
    });
    
    /** register PoolExhaustedTimeoutCount to the connectionPoolMonitorRegistry */
    private final Gauge<Long> PoolExhaustedTimeoutCount = connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "PoolExhaustedTimeoutCount", new Gauge<Long>() {
        @Override
        public Long value() {
       
        	return   connectionPoolMonitorContext.getConnectionPoolMonitor().getPoolExhaustedTimeoutCount();
        }
    });
    
    /** register SocketTimeoutCount to the connectionPoolMonitorRegistry */
    private final Gauge<Long> SocketTimeoutCount = connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "SocketTimeoutCount", new Gauge<Long>() {
        @Override
        public Long value() {
        
        	return   connectionPoolMonitorContext.getConnectionPoolMonitor().getSocketTimeoutCount();
        }
    });
    
    /** register UnknownErrorCount to the connectionPoolMonitorRegistry */
    private final Gauge<Long> UnknownErrorCount = connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "UnknownErrorCount", new Gauge<Long>() {
        @Override
        public Long value() {
        
        	return   connectionPoolMonitorContext.getConnectionPoolMonitor().getUnknownErrorCount();
        }
    });
    /** register  notFoundCount to the connectionPoolMonitorRegistry */

    private final Gauge<Long> notFoundCount = connectionPoolMonitorRegistry.newGauge(ConnectionPoolMonitorMetrics.class, "notFoundCount", new Gauge<Long>() {
        @Override
        public Long value() {
        
        	return   connectionPoolMonitorContext.getConnectionPoolMonitor().notFoundCount();
        }
    });
  
    
    

	public Gauge<Long> getNoHostCount() {
		return NoHostCount;
	}

	public Gauge<Long> getConnectionReturnedCount() {
		return ConnectionReturnedCount;
	}

	public Gauge<Long> getGetConnectionCreatedCount() {
		return getConnectionCreatedCount;
	}

	public Gauge<Long> getGetConnectionClosedCount() {
		return ConnectionClosedCount;
	}

	public Gauge<Long> getGetConnectionCreateFailedCount() {
		return getConnectionCreateFailedCount;
	}

	public Gauge<Long> getFailoverCount() {
		return FailoverCount;
	}

	public Gauge<Long> getInterruptedCount() {
		return InterruptedCount;
	}

	public Gauge<Long> getOperationFailureCount() {
		return OperationFailureCount;
	}

	public Gauge<Long> getBadRequestCount() {
		return BadRequestCount;
	}

	public Gauge<Long> getOperationSuccessCount() {
		return OperationSuccessCount;
	}

	public Gauge<Long> getOperationTimeoutCount() {
		return OperationTimeoutCount;
	}

	public Gauge<Long> getPoolExhaustedTimeoutCount() {
		return PoolExhaustedTimeoutCount;
	}

	public Gauge<Long> getSocketTimeoutCount() {
		return SocketTimeoutCount;
	}

	public Gauge<Long> getUnknownErrorCount() {
		return UnknownErrorCount;
	}

	public Gauge<Long> getNotFoundCount() {
		return notFoundCount;
	}
	
	public Gauge<Long> getConnectionBorrowedCount() {
		return ConnectionBorrowedCount;
	}

	
	
   
	 public Gauge<Long> getConnectionCreatedCount() {
	        return getConnectionCreatedCount;
	    }
   
     
   public Timer getRequestsTimer() {
       return requests;
    }

  
   
    /** returns MetricsRegistry filled with connection pool gauge value of connection pool monitor */
    public static MetricsRegistry getConnPoolMonitorRegistry(){
    	return connectionPoolMonitorRegistry;
    }

	
   
}
