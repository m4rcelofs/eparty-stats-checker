package mfs.erep.politics.partystats;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class EgovAdapter {

	private static final String	baseURL	= "http://www.egov4you.info/citizen/history/{id}";

	public void fillMembersStats(List<PartyMember> members) {

		EgovCitizenParser parser = new EgovCitizenParser();

		int membersDownloaded = 0;
		for (PartyMember member : members) {
			boolean memberOk = false;
			do {
				String memberURL = baseURL.replace("{id}", member.getId());
				try (InputStream in = new URL(memberURL).openStream()) {

					String html = IOUtils.toString(in);

					parser.parseWeeklyXP(html, member);

					System.out.print("|");
					membersDownloaded++;
					if (membersDownloaded % 10 == 0)
						System.out.println();

					memberOk = true;
				} catch (Exception e) {
					System.err.println(e.getMessage());
					System.err
							.println("Erro ao carregar status para o jogador "
									+ member.getId()
									+ ", tentando novamente...");
				}

			} while (!memberOk);
		}

	}
}
