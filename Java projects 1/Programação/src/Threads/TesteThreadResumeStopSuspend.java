package Threads;

public class TesteThreadResumeStopSuspend  {

	public static void main(String[] args) {
		ThreadResumeStopSuspend t1 = new ThreadResumeStopSuspend("Thread#1");
		ThreadResumeStopSuspend t2 = new ThreadResumeStopSuspend("Thread#2");
		t1.suspend();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.stop();
		t1.resume();
		
		
			
		
	}

}
