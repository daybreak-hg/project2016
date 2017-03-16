package sample;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SampleExecClassTest {

	@Test
	public void testTrue() {
		final SampleExecClass sampleExecClass = new SampleExecClass(true);
		final int result = sampleExecClass.exec();
		assertEquals(result, 0);
	}
	
	@Test
	public void testFalse() {
		final SampleExecClass sampleExecClass = new SampleExecClass(false);
		final int result = sampleExecClass.exec();
		assertEquals(result, 0);
	}

}
