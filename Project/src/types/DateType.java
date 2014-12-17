package types;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.commands.CommandException;

public class DateType extends AbstractType<DateType> {
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	private Date data;

	public DateType(Date data) throws CommandException {
		this.data = data;
	}

	public DateType(String data) throws CommandException {
		Date date = new Date();
		try {
			date = format.parse(data.replaceAll("'", ""));
		} catch (ParseException e) {
			throw new CommandException("Incorrect date type.");
		}
		this.data = date;
	}

	public DateType(RandomAccessFile raf, long pointer) throws IOException {
		raf.seek(pointer);
		this.data = new Date(raf.readLong());
	}

	@Override
	public String getData() {
		return format.format(data);
	}

	@Override
	public void write(RandomAccessFile raf, long pointer)
			throws CommandException {
		try {
			raf.seek(pointer);
			raf.writeLong(data.getTime());
		} catch (IOException e) {
			throw new CommandException(
					"There was an error writing to the file.");
		}
	}

	@Override
	public int compareTo(DateType o) {
		return data.compareTo(o.data);
	}

}
