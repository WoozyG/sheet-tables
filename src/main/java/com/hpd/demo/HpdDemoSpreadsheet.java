package com.hpd.demo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;

import com.vaadin.flow.component.spreadsheet.Spreadsheet;
import com.vaadin.flow.component.spreadsheet.SpreadsheetTable;

/**
 * custom subclass to log table registrations
 */
public class HpdDemoSpreadsheet extends Spreadsheet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger();

	/**
	 * @param workbook
	 */
	public HpdDemoSpreadsheet(Workbook workbook) {
		super(workbook);
	}

	/**
	 * @param file
	 * @throws IOException
	 */
	public HpdDemoSpreadsheet(File file) throws IOException {
		super(file);
	}

	/**
	 * @param inputStream
	 * @throws IOException
	 */
	public HpdDemoSpreadsheet(InputStream inputStream) throws IOException {
		super(inputStream);
	}
	
	@Override
	public void registerTable(SpreadsheetTable table) {
		LOG.info("Registering table object {} for {}!{}", table.hashCode(), table.getSheet().getSheetName(), table.getFullTableRegion().toString());
		LOG.info("disabling table popups");
		table.getPopupButtons().forEach(pb-> {pb.setVisible(false); pb.setHeaderHidden(true);});
		super.registerTable(table);
		LOG.info("now {} tables", getTables().size());
	}
	
}
