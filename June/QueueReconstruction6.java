class QueueReconstruction6 {
    public int[][] reconstructQueue(int[][] people) {
			// sort array using Arrays.sort with custom comparator
            Arrays.sort(people, (p1, p2) -> p1[0c] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]); 
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < people.length; i++) {
                list.add(people[i][1], people[i]); // placing people based on the K value
            }
            return list.toArray(people); // convert list to array
        }
}
