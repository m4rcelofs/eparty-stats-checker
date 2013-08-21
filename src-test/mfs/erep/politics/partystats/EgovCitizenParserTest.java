package mfs.erep.politics.partystats;

import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class EgovCitizenParserTest {
	public static void main(String[] args) {
		EgovCitizenParser parser = new EgovCitizenParser();
		try (InputStream in = new URL(
				"http://www.egov4you.info/citizen/history/5313713")
				.openStream()) {

			String html = IOUtils.toString(in);

			Integer xpInWeek = parser.parseWeeklyXP(html);

			System.out.println(xpInWeek);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
