package com.shsun.addata.utils.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelExporter {
	/**
	 * 
	 */
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ExcelExporter.class);

	/**
	 * 
	 * @author shsun
	 * 
	 */
	public static class DataGridHeader {
		/**
		 * displayed label
		 */
		public String title;
		/**
		 * the certain property of table
		 */
		public String field;

		/**
		 * 
		 * @param title
		 * @param field
		 */
		public DataGridHeader(String title, String field) {
			this.title = title;
			this.field = field;
		}
	}
	
	/**
	 * 
	 * header中的每一个元素，都要求是header_column的key；
	 * header_column中的每一个value，都要求是recordSet中的数据库表的列名称。
	 * 
	 * 
	 * @param header
	 *            excel文件中的单元格的文本标题，header的顺序决定excel文件中数据列的输出顺序
	 * @param header_column
	 *            excel文件中的单元格的文本标题 ----> 数据库表的列名
	 * @param list
	 *            从数据库中查询出来的结果集。key: 数据库表的列名, value: 数据库中的数据
	 * @param out
	 *            excel文件的输出流
	 * 
	 * @exception NullPointerException
	 *                如果上述4个参数中某个为null
	 */
	public static <T> void export(List<String> header, Map<String, String> header_column, List<Map<String, T>> list, OutputStream out) {
		WritableWorkbook workbook = null;
		try {
			workbook = Workbook.createWorkbook(out);
			doExport(workbook, header, header_column, list);
			workbook.write();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			close(workbook);
		}
	}

	/**
	 * 
	 * @param header
	 *            excel文件中的单元格的文本标题；如果为空，excel文件中就不输出标题
	 * @param recordSet
	 *            从数据库中查询出来的结果集。
	 * @param out
	 *            excel文件的输出流
	 */

	public static <T> void export(List<String> header, List<List<T>> recordSet, OutputStream out) {
		WritableWorkbook workbook = null;
		try {
			workbook = Workbook.createWorkbook(out);
			doExport(workbook, header, recordSet);
			workbook.write();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			close(workbook);
		}
	}
	private static <T> void doExport2(WritableWorkbook workbook, List<DataGridHeader> header, List<Map<String, T>> recordSet) throws Exception {
		WritableSheet sheet = workbook.createSheet("Sheet 1", 0);
		for (int i = 0; i < header.size(); i++) {
			Label label = new Label(i, 0, header.get(i).title);
			sheet.addCell(label);
		}
	}	
	
	private static <T> void doExport(WritableWorkbook workbook, List<String> header, Map<String, String> header_column, List<Map<String, T>> recordSet) throws Exception {
		WritableSheet sheet = workbook.createSheet("Sheet 1", 0);
		for (int i = 0; i < header.size(); i++) {
			Label label = new Label(i, 0, header.get(i));
			sheet.addCell(label);
		}
		for (int i = 0; i < recordSet.size(); i++) {
			Map<String, T> record = recordSet.get(i);
			for (int j = 0; j < header.size(); j++) {
				String head = header.get(j);
				if (!header_column.containsKey(head)) {
					logger.error("没有找到此head对应的column名字！ head = " + head);
					throw new IllegalStateException("没有找到此head对应的column名字！ head = " + head);
				}
				String column = header_column.get(head);
				if (!record.containsKey(column)) {
					String string = "";
					Set<Map.Entry<String, T>> set = record.entrySet();
					for (Iterator<Map.Entry<String, T>> it = set.iterator(); it.hasNext();) {
						Map.Entry<String, T> entry = (Map.Entry<String, T>) it.next();
						string += entry.getKey() + " = " + entry.getValue()+", ";
					}
					logger.error("没有找到此column对应的数据！ column = " + column + ", debug-info:" + string);
					throw new IllegalStateException("没有找到此column对应的数据！ column = " + column + ", debug-info:" + string);
				}
				
				T data = record.get(column);
				
				Label label = new Label(j, i + 1, String.valueOf(data));
				sheet.addCell(label);
			}
		}
	}

	private static <T> void doExport(WritableWorkbook workbook, List<String> header, List<List<T>> recordSet) throws Exception {
		WritableSheet sheet = workbook.createSheet("Sheet 1", 0);
		for (int i = 0; header != null && i < header.size(); i++) {
			Label label = new Label(i, 0, header.get(i));
			sheet.addCell(label);
		}
		final int headerRows = (header != null) ? 1 : 0;
		if (recordSet == null) {
			return;
		}
		for (int i = 0; i < recordSet.size(); i++) {
			List<T> record = recordSet.get(i);
			for (int j = 0; j < record.size(); j++) {
				T data = record.get(j);
				Label label = new Label(j, i + headerRows, String.valueOf(data));
				sheet.addCell(label);
			}
		}
	}

	private static void close(WritableWorkbook workbook) {
		try {
			if (workbook != null) {
				workbook.close();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		List<String> header = new ArrayList<String>();
		header.add("标题1");
		header.add("标题2");

		Map<String, String> header_column = new HashMap<String, String>();
		header_column.put("标题1", "title_1");
		header_column.put("标题2", "title_2");

		ArrayList<Map<String, String>> recordSet = new ArrayList<Map<String, String>>();
		Map<String, String> r1 = new HashMap<String, String>();
		r1.put("title_2", "第一行数据：这个是标题2对应的数据");
		r1.put("title_1", "第一行数据：这个是标题1对应的数据");

		Map<String, String> r2 = new HashMap<String, String>();
		r2.put("title_1", "第2行数据：这个是标题1对应的数据3489734892");
		r2.put("title_2", "第2行数据：这个是标题2对应的数据dhfahdhasdfhl");

		recordSet.add(r1);
		recordSet.add(r2);

		ArrayList<List<String>> recordSet2 = new ArrayList<List<String>>();
		List<String> record_1 = new ArrayList<String>();
		record_1.add("第一行数据：这个是标题1对应的数据");
		record_1.add("第一行数据：这个是标题2对应的数据");

		List<String> record_2 = new ArrayList<String>();
		record_2.add("第2行数据：这个是标题1对应的数据3489734892");
		record_2.add("第2行数据：这个是标题2对应的数据dhfahdhasdfhl");

		recordSet2.add(record_1);
		recordSet2.add(record_2);

		OutputStream out1 = new FileOutputStream("D:\\tmp\\a_1.xls");
		OutputStream out2 = new FileOutputStream("D:\\tmp\\a_2.xls");
		OutputStream out3 = new FileOutputStream("D:\\tmp\\a_3.xls");

		export(header, header_column, recordSet, out1);
		export(header, recordSet2, out2);
		export(null, recordSet2, out3);
	}
}
