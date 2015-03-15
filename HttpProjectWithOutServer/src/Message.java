package com.iwinner.ws.maxis;

class Message {
	public void canned_Message(String s[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length; i++) {
			sb.append(s[i]);
		}
		System.out.println(sb.toString());
	}

	public static void main(String args[]) {
		String[] names = { "Hai", "Hello", "Good Morning", "Good Evening",
				"GoodNight" };
		Message m = new Message();
		m.canned_Message(names);

	}
}