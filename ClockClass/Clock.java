public class Clock {
	private int hr,
		    min,
		    sec;

	public Clock() {
		this(12,0,0);
	}

	public Clock(int hr, int min, int sec) {
		this.setTime(hr,min,sec);
	}

	public void setTime(int hr, int min, int sec) {
		if(hr>=0&&hr<24) {
			this.hr=hr;
		} else {
			this.hr=12;
		}
		if(min>=0 && min < 60) {
			this.min = min;
		} else {
			this.min = 0;
		}
		if(sec>=0 && sec < 60) {
			this.sec = sec;
		} else {
			this.sec = 0;
		}
	}

	public void printTime() {
		System.out.println(this.hr + ":" + this.min + ":" + this.sec);
	}

	public void incrementHours() {
		this.hr=(this.hr+1)%24;	
	}

	public void incrementMinutes() {
		if(this.min<59) {
			this.min++;
		} else {
			this.min=0;
			this.incrementHours();
		}
	}

	public void incrementSeconds() {
		if(this.sec<59) {
			this.sec++;
		} else {
			this.sec=0;
			this.incrementMinutes();
		}
	}

	public int getHr() {
		return this.hr;
	}

	public int getMin() {
		return this.min;
	}

	public int getSec() {
		return this.sec;
	}

	public boolean equals(Clock reloj) {
		return this.hr==reloj.hr && this.min==reloj.min && this.sec == reloj.sec; 

	}

	public void makeCopy(Clock reloj) {
		this.hr = reloj.hr;
		this.min = reloj.min;
		this.sec = reloj.sec;
	}

	public Clock getCopy() {
		Clock default = new Clock(this.hr,this.min,this.sec);
		return Clock;
	}

	public static void main(String[] args) {
		Clock gda = new Clock();
		Clock tij = new Clock();
		gda.printTime();
		tij.printTime();
		tij.setTime(524,231,23);
		tij.printTime();
	}


}