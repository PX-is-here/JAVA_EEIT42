package Generator;


public class chloe75 {
	public static void main(String[] args) {
		myThread mt1 = new myThread("A"); // mt1 & mt2 的priority 是系統預設，我沒有去設定
		myThread mt2 = new myThread("B");
		myRunnable mr1 = new myRunnable("C");
		Thread t1 = new Thread();
		mt1.start();
		mt2.start();
		t1.start();
		
		new Thread() { 
			public void run() {
				System.out.println("OK");
			}
		}.start(); // 有了物件(=> new Thread(){})，要start()他
		
		System.out.println("chloe");
	}

	// TODO 那些是時間精準度要高的？
}


// 生命任務的表現
class myThread extends Thread {  // 進行 override(凌駕在他之上) => 發揚光大
	private String name;
	public myThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println(name + ":" + i);
			try {
				Thread.sleep(100);   /* 0.1 sec => 算久的，時間精準度不高。
									sleep() => 讓出空間給其他正在排隊等候的人 */
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
		}
	}	
}



class myRunnable implements Runnable {
	// 也要有run() ，才叫做runnable
	private String name;
	public myRunnable(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println(name + ":" + i);
			try {
				Thread.sleep(100);   /* 0.1 sec => 算久的，時間精準度不高。
									sleep() => 讓出空間給其他正在排隊等候的人 */
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
		}
		
	}
	
}


// Thread => 開始做到 生命結束
// schedule => 時間到了才做 ex. 鬧鐘，reminder

/* Timer ------ TimerTask
 	 	  |____ TimerTask
 	 	  |____ TimerTask
 	 	  |____ TimerTask
 	 	  		.
 	 	  		.
 	 	  		.
 				.
    => 若全部不玩 => 取消Timer
 */

// 實作runnable => 時間精準度不高
