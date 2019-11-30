package day1;

public class Mobile {

	
	public int makeCall(int number)
	{
		System.out.println("Call dialled");
		return 12345678;
	}
	
	public boolean sendSMS() {
		
		System.out.println("SMS sent");
		return true;
	}
	
	public boolean shutdown()
	{
		System.out.println("Shutdown initiated");
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mobile m = new Mobile();
		int makeCall = m.makeCall(123456789);
		System.out.println("Number dialled "+ makeCall);
		boolean sendSMS = m.sendSMS();
		System.out.println(sendSMS);
		boolean shutdown = m.shutdown();
		System.out.println(shutdown);
	}

}
