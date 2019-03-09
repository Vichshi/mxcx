package mxcx.com.orange.test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

import mxcx.com.orange.vo.UserDto;

public class TestDemo {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
		String da = sdf.format(new Date());
		System.out.println(da);
		String tempale = "ds{a}deg{a}dss{a}fewf{a}sds{a}dee";
		String regex = "{a}";
		String re = tempale.replace(regex, "时间");
		System.out.println(re);
		
	}
	
	@Test
	public void test() {
		UserDto user = new UserDto();
		user.setUsername("vich");
		user.setPassword("123456");
		user.setDel(false);
		//reflect(user);
		testLine(user);
	}
	
	public void reflect(Object obj) {
		
		try {
			if(null != obj) {
				Class clz = obj.getClass();
				Field[] fields = clz.getDeclaredFields();
				Iterator<Field> iterator = Arrays.asList(fields).iterator();
				while(iterator.hasNext()){

					Field field =iterator.next();

					System.out.println(field.getName());
				
					}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
	}
	
	public void testLine(Object obj) {
		try {
			Class clazz = obj.getClass();
			BeanInfo bi = Introspector.getBeanInfo(UserDto.class);
	        PropertyDescriptor[] pds = bi.getPropertyDescriptors();
	        for(PropertyDescriptor p : pds){
	        	if("class".equals(p.getName())) {
	        		continue;
	        	}
	            String name = p.getName();
	            System.out.println(name);
	            Method readMethod = p.getReadMethod();
	            Object invoke = readMethod.invoke(obj);
	            System.out.println(invoke.toString());
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
