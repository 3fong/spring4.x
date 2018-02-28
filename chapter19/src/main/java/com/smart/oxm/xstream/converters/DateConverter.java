package com.smart.oxm.xstream.converters;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class DateConverter implements Converter {
	private Locale locale;
	public DateConverter(Locale locale) {
		super();
		this.locale = locale;
	}
    /**
     * ʵ�ָ÷������ж�Ҫת��������
     */
	public boolean canConvert(Class clazz) {
		return Date.class.isAssignableFrom(clazz);
	}
	/**
	 * ʵ�ָ÷�������дJAVA����XMLת���߼�
	 */
	public void marshal(Object value, HierarchicalStreamWriter writer,
	MarshallingContext context) {
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL,
		this.locale);
		writer.setValue(formatter.format(value));
	}
	/**
	 * ʵ�ָ÷�������дXML��JAVA����ת���߼�
	 */
	public Object unmarshal(HierarchicalStreamReader reader,
	UnmarshallingContext context) {
		GregorianCalendar calendar = new GregorianCalendar();
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL,
		this.locale);
		try {
			calendar.setTime(formatter.parse(reader.getValue()));
		} catch (ParseException e) {
			throw new ConversionException(e.getMessage(), e);
		}
		return calendar.getGregorianChange();
	}
}
