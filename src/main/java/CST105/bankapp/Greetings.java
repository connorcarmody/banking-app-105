package CST105.bankapp;

public class Greetings {

	public static void greetings() {
		String[] greetings = new String[14];
		greetings[0] = "Yeehaw! Let's bank on pardner!";
		greetings[1] = "Welcome, agent. Begin banking simulation.";
		greetings[2] = "Remember to always look both ways before committing tax fraud!";
		greetings[3] = "Thank you for banking with the Number 1 Bank at 33.5121° N, 112.1318° W!";
		greetings[4] = "When I was your age, we had to do our banking with rocks and dirt. So be thankful you have this.";
		greetings[5] = "Batman, your pithy strikes are like a summer's breeze!";
		greetings[6] = "If we lose your money there's really nothing we can do about that.";
		greetings[7] = "\"Banking is like poetry, it rhymes. Banking is the ebb and flow of life itself.\""
				+ "\n - Albert Einstien. ";
		greetings[8] = "Coming soon in the next update: Scratch 'n' Sniff mode!";
		greetings[9] = "As featured on MTV's \"Pimp my Bank\"! ";
		greetings[10] = "It's banking time, saddle up, and buckle up, and enjoy the ride, and have a good one,";
		greetings[11] = "Here at Grand Canyon Unionversity Bank, we pride ourselves on our\n\"Exception "
				+ "in thread: main. java.lang.NullPointerException.\"";
		greetings[12] = "Welcome back! Come cozy up by the fire, you little cutie pie... :) ";
		greetings[13] = "In a universe, in a supercluster, in a local group, in a galaxy, in a solar system, on a planet,\n"
				+ "on a continent, in a country, in a city, on a street, in a house, in a room, on a bed, lies you.\nBanking in your"
				+ " underwear.";

		int x = (int) (Math.random() * greetings.length);
		System.out.println(greetings[x]);

	}

}
