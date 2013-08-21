package mfs.erep.politics.partystats;

public class PartyMember {

	private String	name;

	private String	id;

	private Long	totalXP;

	private Double	totalStrenght;

	private Integer	xpInWeek			= 0;

	private Integer	daysActiveInWeek	= 0;

	private Boolean	activeLastDay;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getXpInWeek() {
		return xpInWeek;
	}

	public void setXpInWeek(Integer xpInWeek) {
		this.xpInWeek = xpInWeek;
	}

	public Integer getDaysActiveInWeek() {
		return daysActiveInWeek;
	}

	public void setDaysActiveInWeek(Integer daysActiveInWeek) {
		this.daysActiveInWeek = daysActiveInWeek;
	}

	public void addDayActiveInWeek() {
		daysActiveInWeek++;
	}

	public void addXPinWeek(Integer xp) {
		xpInWeek += xp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(";");
		builder.append(id);
		builder.append(";");
		builder.append(xpInWeek);
		builder.append(";");
		builder.append(daysActiveInWeek);
		builder.append(";");
		builder.append(activeLastDay);
		builder.append(";");
		builder.append(isAdult());
		return builder.toString();
	}

	public Boolean getActiveLastDay() {
		return activeLastDay;
	}

	public void setActiveLastDay(Boolean activeLastDay) {
		this.activeLastDay = activeLastDay;
	}

	public Long getTotalXP() {
		return totalXP;
	}

	public void setTotalXP(Long totalXP) {
		this.totalXP = totalXP;
	}

	public boolean isAdult() {
		return totalStrenght != null && totalStrenght > 50;
	}

	public Double getTotalStrenght() {
		return totalStrenght;
	}

	public void setTotalStrenght(Double totalStrenght) {
		this.totalStrenght = totalStrenght;
	}

}
