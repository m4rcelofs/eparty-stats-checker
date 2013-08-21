package mfs.erep.politics.partystats;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatsController {

	public void getStats(String partyId) throws IOException {
		System.out.println("Carregando lista de membros...");

		List<PartyMember> partyMembers = new APIAdapter()
				.getPartyMembersList(partyId);

		System.out.println(partyMembers.size() + " partidarios encontrados");
		System.out.println("Carregando dados do egov4you...");

		new EgovAdapter().fillMembersStats(partyMembers);

		System.out.println("\nGravando resultados...");

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		saveStats(partyMembers, formatter.format(new Date()) + "-" + partyId
				+ ".csv");
	}

	private void saveStats(List<PartyMember> members, String folder,
			String... more) throws IOException {

		Path path = FileSystems.getDefault().getPath(folder, more);

		List<String> lines = new ArrayList<>();
		lines.add("Nome; ID; Ganho de XP na semana; Dias ativos na semana;Ativo no dia de ontem;Adult Citizen");
		for (PartyMember member : members)
			lines.add(member.toString());

		Files.write(path, lines, StandardCharsets.UTF_8);

	}
}
