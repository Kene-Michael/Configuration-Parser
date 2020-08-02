import java.util.Map;

public class Main {

	public static void main(String[] args) {
		ConfigParser newConfig = null;
		if(args.length == 0) {
			 newConfig = new ConfigParser("config.txt");
		}else if("staging".equals(args[0])) {
			newConfig = new ConfigParser("config.txt.staging");
		} else if("development".equals(args[0])) {
			newConfig = new ConfigParser("config.txt.dev");
		} else {
			System.out.println("Invalid input");
		}

		System.out.println(newConfig.get("dbname"));
		System.out.println(newConfig.get("host"));
		System.out.println(newConfig.get("application.name"));
	}

}
