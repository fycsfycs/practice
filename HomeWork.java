package tw.com.fcb.fcb_music;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class HomeWork {

	public static void main(String[] args){
		// TODO Auto-generated method stub
//		String name1,name2;
		
		
		
		
//		Scanner scanner = new Scanner(System.in);
//        
//        System.out.println("請輸入兩個名字(以空白鍵分開)：");
//        name1 = scanner.next();
//        name2 = scanner.next();
//        System.out.println("您輸入的名字為：" + name1 + " 和 " + name2 );
		
		CuteGirl girl = new CuteGirl();
		
		girl.show();
		
		girl.getTall();
		girl.getSpectial();
		
		Map<Integer, String> cutegirl = new HashMap<>();
		cutegirl.put(165, "face");
		cutegirl.put(161, "behavior");
		System.out.println("Map: " + cutegirl);
		
		Repository pos = new Repository();
		try {
			pos.select();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
