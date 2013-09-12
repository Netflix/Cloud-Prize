package com.zscaler.astyanax.metricsTest;

import org.testng.annotations.Test;
import com.zscaler.cassandra.astyanax.metrics.Connection;

@Test
public class AstyanaxMetricsTest {

	/**
	 * @param args
	 */
	@Test
	public void test() {
		Connection.generateAstyanaxMetrics();

	}

}
