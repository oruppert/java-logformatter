import java.util.Calendar;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Simple one line per log entry formatter.
 */
public final class LogFormatter extends Formatter {
	@Override
	public String format(LogRecord record) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(record.getMillis());
		return String.format(
				"%tF %1$tT [%s] %s(%d): %s\n",
				calendar,
				record.getLoggerName(),
				record.getLevel(),
				record.getThreadID(),
				record.getMessage()
		);

	}
}
