package mfs.erep.politics.partystats;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class APIAdapter {

	private static final String	apiBaseURL	= "http://dev.erpkapi.appspot.com/partyMembers?id={id}&key=Ih7Xlw";

	public List<PartyMember> getPartyMembersList(String partyId) {

		String apiURL = apiBaseURL.replace("{id}", partyId);
		JSONParser jsParser = new JSONParser();

		List<PartyMember> members = new ArrayList<>();

		boolean apiOk = false;
		do {

			try (InputStream in = new URL(apiURL).openStream()) {

				String json = IOUtils.toString(in);
				JSONArray jsonArray = (JSONArray) jsParser.parse(json);

				fillList(members, jsonArray);

				apiOk = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				System.err
						.println("Erro ao carregar lista de membros, tentando novamente... ");
			}
		} while (!apiOk);

		return members;

	}

	@SuppressWarnings("rawtypes")
	private void fillList(List<PartyMember> members, JSONArray jsonArray) {
		Iterator it = jsonArray.iterator();
		while (it.hasNext()) {
			JSONObject jsObj = (JSONObject) it.next();
			PartyMember member = new PartyMember();
			member.setId(jsObj.get("id").toString());
			member.setName(jsObj.get("name").toString());
			members.add(member);
		}
	}

}
