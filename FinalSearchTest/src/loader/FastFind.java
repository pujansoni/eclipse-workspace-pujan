package loader;

import service.TST;

public class FastFind {
	public static int[][] search(String[] keywords) {

		int[][] frequencylist = new int[ServletContextClass.myTST.size()][2];
		TST<Integer> tst;
		for (int i = 0; i < ServletContextClass.myTST.size(); i++) {
			tst = ServletContextClass.myTST.get(i);
			frequencylist[i][0] = 0;
			frequencylist[i][1] = i;
			for (String w : keywords) {
				if (tst.contains(w)) {
					frequencylist[i][0] += tst.get(w);
				}
			}
		}
		return frequencylist;

	}


}
