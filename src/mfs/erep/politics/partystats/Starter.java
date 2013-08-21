package mfs.erep.politics.partystats;

import java.io.IOException;

public class Starter {

	private void start(String party) throws IOException {

		System.out
				.println("----- Status Partidarios 1.0 - Fenix -----");
		System.out.println("\nOla " + System.getProperty("user.name"));
		System.out
				.println("\n-----------------------------------------------------");
		System.out.println();

		long start = System.currentTimeMillis();

		System.out.println("Iniciando...");

		StatsController controller = new StatsController();
		controller.getStats(party);

		long end = System.currentTimeMillis();
		System.out.println();
		System.out
				.println("\n-----------------------------------------------------\n");
		System.out.println("Concluido. Tempo: ~" + (end - start) / 1000 + "s");

	}

	public static void main(String[] args) throws IOException {
//		new Starter().start("2275");
		
//		new Starter().start("1242");
//		new Starter().start("3064");
//		new Starter().start("2524");
//		new Starter().start("1112");
//		new Starter().start("2071");
//		new Starter().start("4222");
//		new Starter().start("2275");
//		new Starter().start("61");
//		new Starter().start("3044");
//		new Starter().start("2941");
//		new Starter().start("4303");
		
		new Starter().start("4004");
	}

}
