package com.codex.controller.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang.StringUtils;

/**
 * List工具类
 * 
 * @author ningwang4 2015年8月20日
 */
public class ListUtil {
  /**
   * 根据对象列表和对象的某个属性返回属性的List集合
   * 
   * @param <E>
   * 
   * @param objList 对象列表
   * @param propertyName 要操作的属性名称
   * @return <pre>
         *  指定属性的List集合;
         *  如果objList为null或者size等于0抛出 IllegalArgumentException异常;
         *  如果propertyName为null抛出 IllegalArgumentException异常
         * </pre>
   * @throws NoSuchMethodException
   * @throws InvocationTargetException
   */
  public static <T, E> List<E> getPropertyList(List<T> objList, String propertyName, Class<E> e) {
    List<E> propList = new LinkedList<E>();
    if (objList == null || objList.size() == 0 || propertyName == null || "".equals(propertyName)) {
      return propList;
    }
    PropertyUtilsBean p = new PropertyUtilsBean();
    for (int i = 0; i < objList.size(); i++) {
      T obj = objList.get(i);
      Object prop;
      try {
        prop = p.getProperty(obj, propertyName);
      } catch (Exception e1) {
        continue;
      }
      propList.add((E) prop);
    }
    return propList;
  }

  /**
   * 将List列表中的对象的某个属性封装成一个Map对象，key值是属性名，value值是对象列表中对象属性值的列表
   * 
   * @param objList 对象列表
   * @param propertyName 属性名称,可以是一个或者多个
   * @return 返回封装了属性名称和属性值列表的Map对象，如果参数非法则抛出异常信息
   * @throws IllegalAccessException
   * @throws InvocationTargetException
   * @throws NoSuchMethodException
   */
  public static <T> Map<String, List<Object>> getPropertiesMap(List<T> objList,
      String... propertyName) throws IllegalAccessException, InvocationTargetException,
      NoSuchMethodException {
    if (objList == null || objList.size() == 0)
      throw new IllegalArgumentException("No objList specified");
    if (propertyName == null || propertyName.length == 0) {
      throw new IllegalArgumentException("No propertyName specified for bean class '"
          + objList.get(0).getClass() + "'");
    }
    Map<String, List<Object>> maps = new HashMap<String, List<Object>>();
    for (int i = 0; i < propertyName.length; i++) {
      maps.put(propertyName[i], getPropertyList(objList, propertyName[i], Object.class));
    }
    return maps;
  }

  /**
   * 把List按照pageSize切分为多个List
   * 
   * @param list
   * @param pageSize
   * @return
   */
  public static <T> List<List<T>> splitList(List<T> list, int pageSize) {
    int listSize = list.size(); // list的大小
    int page = (listSize + (pageSize - 1)) / pageSize;// 页数
    List<List<T>> listArray = new ArrayList<List<T>>();// 创建list数组 ,用来保存分割后的list
    for (int i = 0; i < page; i++) { // 按照数组大小遍历
      List<T> subList = new ArrayList<T>(); // 数组每一位放入一个分割后的list
      for (int j = 0; j < listSize; j++) {// 遍历待分割的list
        int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;// 当前记录的页码(第几页)
        if (pageIndex == (i + 1)) {// 当前记录的页码等于要放入的页码时
          subList.add(list.get(j)); // 放入list中的元素到分割后的list(subList)
        }
        if ((j + 1) == ((j + 1) * pageSize)) {// 当放满一页时退出当前循环
          break;
        }
      }
      listArray.add(subList);// 将分割后的list放入对应的数组的位中
    }
    return listArray;
  }

  /**
   * 把String按照指定字符切割为List
   * @param str
   * @param regex
   * @return
   */
  public static List<String> stringToList(String str, String regex) {
    List<String> result = new ArrayList<String>();
    if (StringUtils.isBlank(str)) {
      return result;
    }
    if (StringUtils.isBlank(regex)) {
      regex = ",";
    }
    String[] strArr = str.split(regex);
    result = Arrays.asList(strArr);
    return result;
  }
  
  public static String listToString(List<String> ls, String regex) {
    StringBuilder sb = new StringBuilder();
    if (ls==null||ls.isEmpty()) {
      return "";
    }
    if (StringUtils.isBlank(regex)) {
      regex = ",";
    }
    
    int cnt=0;
    for(String s:ls){
      if(cnt==0){
        sb.append(s);
      }else{
        sb.append(regex).append(s);
      }
      cnt++;
    }
    
    return sb.toString();
  }
  
}
