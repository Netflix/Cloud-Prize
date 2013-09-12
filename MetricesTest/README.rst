
Astyanax with Metrics and Reporting
---------------------------------------
---------------------------------------

Astyanax lacks following features 
---------------------------------
---------------------------------

 - Asynchronous: Astyanax uses thrift protocol which does not support asynchronous
  capabilities unlike binary protocol of java driver using which relatively low number
  of connections per nodes needs to be maintained open to achieve good performance. 
 
 - Cassandra Query Tracing : Query trace is not implemented in astyanax. which can be 
  implemented if we can Get randomly generated UUID from  sessions and events table in 
  system_trace keyspaces inside cassandra and implement code for 
  select * from system_trace.sessions where session_id="Random UUID per query";
  select * from system_trace.events where session_id="Random UUID per query";  
  
 -Load balancing policy : Astyanax does not support configurable load balancing policy 
 unlike java driver using which we can implement Round robin policy(by default ),
 Data-center aware (local data-center nodes to be provided, which will discover
 remote data-center using gossip protocol ) and Token aware policy( token range needs to 
 be provided through configuration).  
 
 -Reconnection policies :If there is any connection error i.e  due to time out exception ,
 Node down .is such situation java driver provides constant(retry after constant time)
 and exponential back off strategy (increase the retrying time exponentially ).
 This feature is not supported by astyanax yet.
 
 - Retry Policies :Astyanax does not support retry policy unlike java driver which support
 Default retry policy (never retry with different consistency level ),downgrading consistency 
 retry policy(keeps on decreasing the consistency level upto a certain level), Fallthrough
 retry policy ( rethrow the exception ) and logging retry policy( parent policy for other 
 policies ,provide logging ).
 
 - Metrics and Reporting : Metrics and reporting can be implemented using Metrics library which are
 exposed through JMX . these metrics might be useful for reporting purposes in production environment
(metrics can be exposed using csv reporter(will be stored in csv files) , console reporter (displayed on
console ) , slf4jreporter(stored in log files )  )



Feature Implemented 
------------------------------------

Astyanax Metrics and Reporting with JMX reporter
-------------------------------------------------
-------------------------------------------------

Metrics is a toolkit available at "http://metrics.codahale.com/"

Maven dependency can be added like :

<dependencies>
    <dependency>
        <groupId>com.codahale.metrics</groupId>
        <artifactId>metrics-core</artifactId>
        <version>${metrics.version}</version>
    </dependency>
</dependencies>

->Central point for metrics is Metric Registry which is collection for all the metrics inside application.

-> Gauges are used to expose values returned by application .A gauge is a simplest metric type which will store 
value returned by application.Value returned by gauge is stored inside Metric registry

-> JMX reporter uses metric registry to expose metrics via different methods i.e. csv reporter,
console reporter and slf4jreporter. 

Metrics library is used to monitor all the configuration details provided by connection pool monitor and connection
pool configuration . Gauge is used to store values returned by connection pool monitor and connection
pool configuration so that it can be stored inside metric registry. This metric registry is being used by JMX 
reporter to expose metrics via Console reporter and CSV reporter .
Slf4j reporter can also be implemented using following line of code.

/*
final Slf4jReporter reporter = Slf4jReporter.forRegistry(registry)
                                            .outputTo(LoggerFactory.getLogger("com.zscaler.cassandra.astyanax.metrics"))
                                            .convertRatesTo(TimeUnit.SECONDS)
                                            .convertDurationsTo(TimeUnit.MILLISECONDS)
                                            .build();
reporter.start(1, TimeUnit.MINUTES);
  
*/



Code Description
-------------------------------------------------------
-------------------------------------------------------

-> Connection class is used for making connection to cassandra host using astyanax.
->ConnectionPoolConfigurationMetrics implemented to hold value returned by gauge inside Metric Registry from ConnectionPoolConfiguration 
->ConnectionPoolMonitorMetrics implemented to hold value returned by gauge inside Metric Registry from ConnectionPoolMonitor
->ConnectionPoolConfigurationReport implemented to get value from registry provided by onnectionPoolConfigurationMetrics and exposed 
 it via JMXreporter
->ConnectionPoolMonitorReport implemented to get value from registry provided by onnectionPoolMonitorMetrics and exposed 
 it via JMXreporter


Store gauge value in Metric registry 
--------------------------------------------

 private final MetricsRegistry registry = new MetricsRegistry();
	
		
	 
	 AstyanaxContext<Keyspace> context=Connection.start(input host address to make connection with astyanax i.e. localhost, amazon aws);
	 private final Gauge<Integer> PortNumber = registry.newGauge(ConnectionPoolConfigurationMetrics.class, "PortNumber", new Gauge<Integer>() {
	        @Override
	        public Integer value() {
	            return  contextcpcm.getConnectionPoolConfiguration().getPort();
	        }
	    });
	    

Exposed Metrics using JMX reporter (Console)
---------------------------------------------- 

 MetricsRegistry registry=new ConnectionPoolMetrics().getRegistry();  
		 JmxReporter jmxReportermonit = new JmxReporter(registry);
		 jmxReportermonit.start();
		 
		 
	// used to display results on console	 
		 com.yammer.metrics.reporting.ConsoleReporter.enable(registry, 1, TimeUnit.SECONDS);	    
	    
	    
	    
Exposed Metrics using JMX reporter (CSV reporter)
---------------------------------------------- 

 MetricsRegistry registry=new ConnectionPoolMetrics().getRegistry();  
		 JmxReporter jmxReportermonit = new JmxReporter(registry);
		 jmxReportermonit.start();
		 
		 
	// used to display results on console	 
		 com.yammer.metrics.reporting.CsvReporter.enable(registry, new File(file output destination), 1, TimeUnit.SECONDS);    
	    
	    

Exposed Metrics using JMX reporter (Slf4j reporter)
---------------------------------------------- 

 MetricsRegistry registry=new ConnectionPoolMetrics().getRegistry();  
		 JmxReporter jmxReportermonit = new JmxReporter(registry);
		 jmxReportermonit.start();
		 
		 
	// used to display results on console	 
		 com.yammer.metrics.reporting.Slf4jReporter.enable(registry, class name, 1, TimeUnit.SECONDS);    
	    




Metrics Samples
-------------------------------------------------------
-------------------------------------------------------

All the CSV reporter file can be found in src/main/resources folder.
-> ConnectionPoolConfigurationReport contains all the csv files contains metrics generated by ConnectionPoolConfiguration.
-> ConnectionPoolMonitorReport contains all the csv files contains metrics generated by ConnectionPoolMonitor.

Below are some of the samples generated by console reporter


/*
LatencyAwareWindowSize:
    value = 100

  LocalDatacenter:
      value = null

OperationSuccessCount:
value = 0

MaxBlockedThreadsPerHost:
value = 25

  MaxConnInPool:
  value = 1

OperationTimeoutCount:
   value = 0

  MaxConnPerHost:
   value = 1
    
PoolExhaustedTimeoutCount:
   value = 0

  MaxFailoverCount:
   value = -1
  
  SocketTimeoutCount:
   value = 0

  MaxOperationsPerConnection:
   value = 10000
   
  UnknownErrorCount:
    value = 0

  MaxPendingConnectionsPerHost:
    value = 5
    
  getConnectionCreateFailedCount:
  value = 0

  MaxTimeoutCount:
    value = 3
  
  getConnectionCreatedCount:
  
    value = 0

  MaxTimeoutWhenExhausted:
  value = 2000
  
  notFoundCount:
   value = 0

  MinHostInPoolRatio:
    value = 0.65

  requests:
  PortNumber:
    value = 9160

  RetryDelaySlice:
    value = 1000

  RetryMaxDelaySlice:
    value = 10

  RetrySuspendWindow:
    value = 20000

  SeedHosts:
    value = [ec2-54-227-122-226.compute-1.amazonaws.com(54.227.122.226):9160]

  Seeds:
    value = ec2-54-227-122-226.compute-1.amazonaws.com

  SocketConnectTimeOut:
            
    value = 2000

  SocketReadWriteTimeout:
    value = 11000

  TimeoutWindow:
    value = 10000
    
   */ 





 
 
  
 
   