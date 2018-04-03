public enum Layout {
	RED, BLACK, OTHER;

	public static final char[] DEFAULT_0;
	static {
		StringBuilder sbPattern = new StringBuilder();
		sbPattern.append("...........");
		sbPattern.append("....RRR....");
		sbPattern.append("...RRRRR...");
		sbPattern.append("..RR***RR..");
		sbPattern.append("..RR***RR..");
		sbPattern.append("..RR***RR..");
		sbPattern.append("...RRRRR...");
		sbPattern.append("....RRR....");
		sbPattern.append("...........");
		DEFAULT_0 = sbPattern.toString().toCharArray();
	}

	public static final char[] DEFAULT_1;
	static {
		StringBuilder sbPattern = new StringBuilder();
		sbPattern.append("...........");
		sbPattern.append("....RRR....");
		sbPattern.append("...RRRRR...");
		sbPattern.append("..RR*RRRR..");
		sbPattern.append("..R***RRR..");
		sbPattern.append("..RR*RRRR..");
		sbPattern.append("...RRRRR...");
		sbPattern.append("....RRR....");
		sbPattern.append("...........");
		DEFAULT_1 = sbPattern.toString().toCharArray();
	}

	public static final char[] DEFAULT_2;
	static {
		StringBuilder sbPattern = new StringBuilder();
		sbPattern.append("...........");
		sbPattern.append("....RRR....");
		sbPattern.append("...RR*RR...");
		sbPattern.append("..RR***RR..");
		sbPattern.append("..R*****R..");
		sbPattern.append("..RR***RR..");
		sbPattern.append("...RR*RR...");
		sbPattern.append("....RRR....");
		sbPattern.append("...........");
		DEFAULT_2 = sbPattern.toString().toCharArray();
	}

	public static final char[] DEFAULT_3;
	static {
		StringBuilder sbPattern = new StringBuilder();
		sbPattern.append("..........");
		sbPattern.append("....RR....");
		sbPattern.append("...RRRR...");
		sbPattern.append("..RR**RR..");
		sbPattern.append("..RR**RR..");
		sbPattern.append("..RR**RR..");
		sbPattern.append("...RRRR...");
		sbPattern.append("....RR....");
		sbPattern.append("..........");
		DEFAULT_3 = sbPattern.toString().toCharArray();
	}

	public static final char[] DEFAULT_4;
	static {
		StringBuilder sbPattern = new StringBuilder();
		sbPattern.append("...........");
		sbPattern.append("..R........");
		sbPattern.append(".RRR.......");
		sbPattern.append("RR*RR......");
		sbPattern.append(".RRR.......");
		sbPattern.append("..R........");
		sbPattern.append("...........");
		sbPattern.append("...........");
		sbPattern.append("...........");
		DEFAULT_4 = sbPattern.toString().toCharArray();
	}

	public static Layout[][] fill11x9(char[] linePattern) {
		if (linePattern.length != 11 * 9) {
			return null;
		}
		int chIndex = 0;
		Layout[][] pattern = new Layout[9][11];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 11; j++) {
				pattern[i][j] = Layout.toLayout(linePattern[chIndex]);
				chIndex++;
			}
		}
		return pattern;
	}

	public static Layout[][] fill10x9(char[] linePattern) {
		if (linePattern.length != 10 * 9) {
			return null;
		}
		int chIndex = 0;
		Layout[][] pattern = new Layout[9][10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 10; j++) {
				pattern[i][j] = Layout.toLayout(linePattern[chIndex]);
				chIndex++;
			}
		}
		return pattern;
	}

	public static Layout toLayout(char ch) {
		Layout layout;
		switch (ch) {
			case 'R': layout = RED;
				break;
			case '*': layout = BLACK;
				break;
			default: layout = OTHER;
				break;
		}
		return layout;
	}

	public static String toString(Layout layout) {
		String representation = "?";
		switch (layout) {
			case RED: representation = "R";
				break;
			case BLACK: representation = "*";
				break;
			case OTHER: representation = ".";
				break;
			default: break;
		}
		return representation;
	}
}