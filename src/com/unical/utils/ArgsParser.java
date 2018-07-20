package com.unical.utils;

import java.io.File;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

public class ArgsParser {

	private JCommander jCommander;

	/************************
	 **** CLI Parameters ****
	 ************************/
	@Parameter(description = "File To Sign", converter = FileConverter.class)
	private File fileToSign;

	@Parameter(names = { "-p", "-password" }, description = "Token Password", password = true, required = true)
	private String password;

	@Parameter(names = { "-d",
			"-driver" }, converter = FileConverter.class, description = "PKCS#11 Driver", required = false, arity = 1 )
	private File driver;

	@Parameter(names = { "-h", "-help" }, help = true)
	private boolean help;

	public File getFileToSign() {
		return fileToSign;
	}

	public String getPassword() {
		return password;
	}

	public boolean isHelp() {
		return help;
	}

	public File getDriver() {
		return driver;
	}

	public ArgsParser(String[] args) {
		jCommander = new JCommander(this);
		jCommander.setProgramName("PKCS#11 Digital Signature Tool");
		try {
			jCommander.parse(args);
		} catch (ParameterException e) {
			System.err.println("Missing Parameter");
			e.printStackTrace();
		}
	}

	public void showHelp() {
		jCommander.usage();
	}


	/************************
	 ******** Converter *********
	 ************************/

	// create a file from a string
	public class FileConverter implements IStringConverter<File> {
		@Override
		public File convert(String value) {
			System.out.println(value);
			return new File(value);
		}
	}
}