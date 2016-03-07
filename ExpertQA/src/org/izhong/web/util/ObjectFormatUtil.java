package org.izhong.web.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.izhong.expert.util.BaseUtil;
import org.izhong.web.model.AndCondition;
import org.izhong.web.model.Condition;
import org.izhong.web.model.ICondition;
import org.izhong.web.model.InArrayCondition;
import org.izhong.web.model.LengthCondition;
import org.izhong.web.model.Operators;
import org.izhong.web.model.OrCondition;
import org.izhong.web.model.OrderbyClause;

public class ObjectFormatUtil {
	public static ICondition ParserCondition(String xmlcondition) throws DocumentException
	{
//		<OrCondition>
//		  <AndCondition>
//		    <AndCondition>
//		      <Condition>
//		        <MemberName>answer</MemberName>
//		        <Operator>Like</Operator>
//		        <Value Type="String">answ</Value>
//		      </Condition>
//		      <Condition>
//		        <MemberName>description</MemberName>
//		        <Operator>Equals</Operator>
//		        <Value Type="String">desc</Value>
//		      </Condition>
//		    </AndCondition>
//		    <LengthCondition>
//		      <MemberName>title</MemberName>
//		      <Operator>GreaterThan</Operator>
//		      <Length Type="Int32">100</Length>
//		    </LengthCondition>
//		  </AndCondition>
//		  <InArrayCondition>
//		    <MemberName>title</MemberName>
//		    <InData>true</InData>
//		    <Values>
//		      <Value Type="String">123</Value>
//		      <Value Type="String">456</Value>
//		      <Value Type="String">xxxy</Value>
//		    </Values>
//		  </InArrayCondition>
//		</OrCondition>
		if(BaseUtil.isNotEmpty(xmlcondition))
		{
			Element condition = DocumentHelper.parseText(xmlcondition).getRootElement();
			return subParserCondition(condition);
		}
		return null;	
	}
	
	private static ICondition subParserCondition(Element condition)
	{
		String name = condition.getName();
		if(("AndCondition".equalsIgnoreCase(name)) || ("OrCondition".equalsIgnoreCase(name)))
		{
			List<Element> els = condition.elements();
			Element leftEl = els.get(0);
			Element rightEl = els.get(1);
			ICondition leftCondition = subParserCondition(leftEl);
			ICondition rightCondition = subParserCondition(rightEl);
			
			return (("AndCondition".equalsIgnoreCase(name)) ? new AndCondition(leftCondition, rightCondition) : new OrCondition(leftCondition, rightCondition));
		}
		else if("Condition".equalsIgnoreCase(name))
		{
			String membername = condition.element("MemberName").getText();
			String operator = condition.element("Operator").getText();
			String value = condition.element("Value").getText();
			String valueType = condition.element("Value").attribute("Type").getText();
			return new Condition(membername, toOperator(operator), toObject(value, valueType));
		}
		else if("LengthCondition".equalsIgnoreCase(name)) {
			String membername2 = condition.element("MemberName").getText();
			String operator2 = condition.element("Operator").getText();
			String length = condition.element("Length").getText();
			int len = Integer.parseInt(length);
			return new LengthCondition(membername2, toOperator(operator2), len);
		}
		else if("InArrayCondition".equalsIgnoreCase(name))
		{
			String membername2 = condition.element("MemberName").getText();
			String inData = condition.element("InData").getText();
			Element values = condition.element("Values");

			List<Element> eles = values.elements();
			int count = eles.size();
			Object[] objs = new Object[count];
			for(int i=0;i<count;i++)
			{
				Element el = eles.get(i);
				String v = el.getText();
				String type = el.attribute("Type").getText();
				objs[i] = toObject(v, type);
			}
			return new InArrayCondition(membername2, Boolean.parseBoolean(inData), objs);
		}
		else return null;
	}
	
	private static Operators toOperator(String operator)
	{
		return Enum.valueOf(Operators.class, operator);
	}
	
	private static Object toObject(String objText, String objType)
	{
		if("String".equalsIgnoreCase(objType))
			return objText;
		else if("Char".equalsIgnoreCase(objType) && (objText.length() > 0))
			return objText.charAt(0);		
		else if("Int16".equalsIgnoreCase(objType))
			return Short.parseShort(objText);		
		else if("Int32".equalsIgnoreCase(objType))
			return Integer.parseInt(objText);
		else if("Int64".equalsIgnoreCase(objType))
			return Long.parseLong(objText);		
		else if("Double".equalsIgnoreCase(objType))
			return Double.parseDouble(objText);
		else if("Single".equalsIgnoreCase(objType) || "Decimal".equalsIgnoreCase(objType))
			return Float.parseFloat(objText);
		else if("Boolean".equalsIgnoreCase(objType))
			return Boolean.parseBoolean(objText);
		else if("DateTime".equalsIgnoreCase(objType))
			return Date.parse(objText);		
		
		return null;
	}
	
	public static OrderbyClause[] ParserOrderbys(String xmlorderbys) throws DocumentException
	{
//		<Orderbys>
//		  <Orderby MemberName="description" Ascend="true" />
//		  <Orderby MemberName="example" Ascend="false" />
//		</Orderbys>
		if(BaseUtil.isNotEmpty(xmlorderbys))
		{
			Element root = DocumentHelper.parseText(xmlorderbys).getRootElement();
			List<Element> elist = root.elements();
			List<OrderbyClause> orders = new ArrayList<OrderbyClause>();
			for(int i=0;i<elist.size();i++)
			{
				Element el = elist.get(i);
				OrderbyClause orderby = new OrderbyClause(el.attribute("MemberName").getText(), Boolean.parseBoolean(el.attribute("Ascend").getText()));
				orders.add(orderby);
			}
			return orders.toArray(new OrderbyClause[0]);
		}
		return null;
	}
	
	public static String formatObject(Object value)
	{
		if(value instanceof String) return (String)value;
		if((value instanceof Integer)
				||(value instanceof Double)
				||(value instanceof Float)
				||(value instanceof Long))
				return value.toString();
		else if(value instanceof Boolean)
			return ((Boolean)value).toString();
		else if(value instanceof Date)
		{
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH24:MI:SS");
			return sd.format((Date)value);
		}
		return value.toString();
	}
	
	public static boolean mustbeFix(Object value)
	{
		if((value instanceof String)
				||(value instanceof Boolean)
				||(value instanceof Date)) return true;
		else return false;
	}
}
