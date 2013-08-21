package mfs.erep.politics.partystats;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EgovCitizenParser {

	public Integer parseWeeklyXP(String html) {
		return parseWeeklyXP(html, null);
	}

	public Integer parseWeeklyXP(String html, PartyMember member) {
		Integer weeklyXP = 0;

		Document doc = Jsoup.parse(html);

		Elements rows = doc.getElementsByClass("highlight");

		for (int i = 0; i < 7 && i < rows.size(); i++) {
			Element row = rows.get(i);

			if (i == 0 && member != null) {
				Long totalXp = Long.valueOf(row.child(2).text()
						.replace(",", ""));
				member.setTotalXP(totalXp);

				Double totalStr = Double.valueOf(row.child(4).text()
						.replace(",", ""));
				member.setTotalStrenght(totalStr);
			}

			Element xpGainTd = row.child(3);
			String xpGainString = xpGainTd.text().replace(",", "");
			Integer xpGainValue = Integer.valueOf(xpGainString);
			weeklyXP += xpGainValue;

			if (member != null && xpGainValue > 0) {
				member.addXPinWeek(xpGainValue);
				member.addDayActiveInWeek();
				if (i == 0)
					member.setActiveLastDay(true);
			}

		}

		return weeklyXP;
	}

}
