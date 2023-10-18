/**
 * 
 */
package com.nagarro.advancejava.assignment4.service.impl;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nagarro.advancejava.assignment4.dao.impl.TshirtDaoImpl;
import com.nagarro.advancejava.assignment4.entities.TshirtData;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

/**
 * @author komalsingh01
 *
 */
public class ReadCSV {
	List<TshirtData> tShirtList = new ArrayList<TshirtData>();

	/** The reader. */
	CSVReader reader = null;

	/**
	 * Gets the shirt list.
	 *
	 * @return the shirt list
	 */

	public void getShirtList() {
		try {

			List<String> filePath = new ArrayList<>();
			filePath.add(".\\Files\\Adidas.csv");
			filePath.add(".\\Files\\Nike.csv");
			filePath.add(".\\Files\\Puma.csv");

			for (String file : filePath) {
				// parsing a CSV file into CSVReader class constructor

				// reader = new CSVReader(new FileReader(file),'|');
				reader = new CSVReaderBuilder(new FileReader(file))
						.withCSVParser(new CSVParserBuilder().withSeparator('|').build()).build();
				String[] row;
				boolean firstLine = true;

				// reads one line at a time
				while ((row = reader.readNext()) != null) {

					// Skips first row..
					if (firstLine == true) {
						firstLine = false;
						continue;
					}

					TshirtData tShirt = new TshirtData();

					tShirt.setTshirtId(row[0]);
					tShirt.setModelName(row[1]);
					tShirt.setTshirtColor(row[2]);
					tShirt.setTshirtGender(row[3]);
					tShirt.setTshirtSize(row[4]);
					tShirt.setTshirtPrice(Double.parseDouble(row[5]));
					tShirt.setTshirtRating(Float.parseFloat(row[6]));
					tShirt.setTshirtAvailability(row[7]);
					tShirtList.add(tShirt);

				}
			}
			AbstractApplicationContext ctx =new ClassPathXmlApplicationContext("config.xml");
				TshirtDaoImpl tshirtDao=ctx.getBean(TshirtDaoImpl.class);
			tshirtDao.insertTshirt(tShirtList);

		} catch (Exception e) {
			System.out.println("Files are missing.Please check CSV files again..." + e.getMessage());
		}

	}
}
