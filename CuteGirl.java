package tw.com.fcb.fcb_music;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;








public class CuteGirl implements CutePerson {

	public void show() {
		JavaBean bean1 = new JavaBean();
		JavaBean bean2 = new JavaBean();

		bean1.setBelong("應二部");
		bean1.setName("祐瑋");
		bean1.setFace("帥");
		System.out.println(bean1);
		
		bean2.setName("琪悅");

//		try {
//			BeanUtils.copyProperties(bean2,bean1);
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		bean2.setFace("美");
		System.out.println(bean2);
	}
	
	
	@Override
	public void getTall() {
		// TODO Auto-generated method stub
		System.out.println("From 155 to 165");
	}

	@Override
	public void getSpectial() {
		// TODO Auto-generated method stub
		System.out.println("face and behavior");
	}

}
