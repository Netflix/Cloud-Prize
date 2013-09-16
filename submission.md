Edit this page to describe your Submission.

## Which Categories Best Fit Your Submission and Why?
-----------------------------------------------------

Best Datastore Integration - Integrating few functionality of Java Driver into Astyanax

As we are extending Astyanax to include more functionality, which we have simulated from the Datastax Java Driver.

## Describe your Submission
---------------------------

Astyanax with additional metrics and reporting
Some of the popular Cassandra Java Clients are Hector, Astyanax and Java driver. The industry is moving towards CQL3 and Datastax Java Driver is the only client driver supporting it as of now. Hector, Astyanax and Java Driver all support Thrift. This is an effort to provide more functionality to astyanax by including some server side metrics to the Astyanax client.

Brief Comparison of Astyanax wrt the Java Driver
In addition to supporting CQL3 Java driver has a multitude of features which the Astyanax driver does not provide as of now. Here is a brief overview.

Asynchronous: Astyanax uses thrift protocol which does not support asynchronous capabilities unlike binary protocol of java driver. Binary protocol needs to maintain a relatively low number of connections per node open to achieve good performance.

Cassandra Query Tracing : Query tracing is not implemented in astyanax. which can be easily implemented if we can get access to the sessions and events table in system_trace keyspaces inside cassandra. Simple CQL statements like the ones mentioned below should give access to Query tracing.

select * from system_trace.sessions where session_id="Random UUID per query"; select * from system_trace.events where session_id="Random UUID per query";

Load balancing policy : Astyanax supports a configurable load balancing policy where can implement Round robin policy (by default), Token aware routing (token range needs to be provided through Priam and Eureka) but does not support Data-center aware load balancing (local data-center nodes to be provided, which will discover remote data-center using gossip protocol ).

Reconnection policies : If there is any connection error i.e due to time out exception, or the Node is down due to DC issues, in such situation java driver provides retry after a constant time and exponential back off strategy (increase the retrying time exponentially ). This feature is not supported by astyanax yet.

Retry Policies : Astyanax does not support retry policy unlike java driver which supports a default retry policy (never retry with different consistency level ), downgrading consistency retry policy (keeps on decreasing the consistency level upto a certain level), Fallthrough retry policy (rethrow the exception) and logging retry policy (parent policy for other policies which also provides logging).

Metrics and Reporting : Metrics and reporting can be implemented using Metrics library which are exposed through JMX . These metrics might be useful for reporting and debugging purposes in a production environment (metrics can be exposed using csv reporter, console reporter, slf4jreporter)

Feature Implemented : Astyanax Metrics and Reporting with JMX reporter
Metrics are very useful for reporting and debugging purposes in a production environment. They can be exposed via csv reporter, console reporter, slf4jreporter into various dashboards that should assist the operations team as well as development teams in understanding various issues/bottlenecks about their Cassandra Installations. Here in this project we use astyanax as the client to connect to the Cassandra Server host (co-ordinator) and then collect various stats about the Connection Pool which are exposed via JMX. Metrics library is used to monitor all the configuration details provided by connection pool monitor and connection pool configuration. Gauge is used to store values returned by connection pool monitor and connection pool configuration so that it can be stored inside metric registry. This metric registry is being used by JMX reporter to expose metrics via Console reporter and CSV reporter.


## Provide Links to Github Repo's for your Submission
------------------------------------------------------
Please check the code in this Repo:

https://github.com/mailmahee/Cloud-Prize
