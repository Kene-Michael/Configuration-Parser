public class Main {

	public static void main(String[] args) {
		/**
		 * Checking if there is an argument passed and if yes, use it to determine file to read from.
		 */
		ConfigParser newConfig = null;
		if(args.length == 0) {
			 newConfig = new ConfigParser("config.txt");
		}else if("staging".equalsIgnoreCase(args[0])) {
			newConfig = new ConfigParser("config-staging.txt");
		} else if("development".equalsIgnoreCase(args[0])) {
			newConfig = new ConfigParser("config-dev.txt");
		} else {
			System.out.println("Invalid input");
		}

	}

}
