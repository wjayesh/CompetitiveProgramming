public class DungeonGame21 {
    public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = m == 0 ? 0 : dungeon[0].length;
		int[][] minRequred = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			minRequred[i][n] = Integer.MAX_VALUE;
		}
		for (int j = 0; j < n + 1; j++) {
			minRequred[m][j] = Integer.MAX_VALUE;
		}
		minRequred[m][n - 1] = 0;
		minRequred[m - 1][n] = 0;
		
                for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				minRequred[i][j] = Math.max(
						Math.min(minRequred[i + 1][j], minRequred[i][j + 1]) - dungeon[i][j], 0);
			}
		}

		return minRequred[0][0] + 1;
    }
}

/**
This is because, in order to compute HP[i][j], you will need to make sure of two things:

your HP[i][j]+dungeon[i][j] should be >0
your HP[i][j]+dungeon[i][j] should be large enough, so that it will be sufficient to cover the minimum requirement on HP for the next step, be it right or down (take whichever requires smaller HP).
So you see, because of the second requirement, your calculation of HP[i][j] will depend on later steps that you could take. This is why you have to know these later steps ahead of time, thus calculating from the bottom right.
**/
