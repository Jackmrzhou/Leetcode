package leetcodeJava;

class ExamRoom {
    
    private Set<Integer> seatedSet;
    private int cap;

    public ExamRoom(int N) {
        this.seatedSet = new TreeSet<>();
        this.cap = N;
    }

    public int seat() {
        if (seatedSet.size() >= cap) {
            return -1;
        }
        if (seatedSet.size() == 0) {
            seatedSet.add(0);
            return 0;
        }

        Iterator<Integer> iterator = seatedSet.iterator();
        int prev = iterator.next();
        int maxDist = prev;
        int seat = 0;

        while (iterator.hasNext()) {
            int seated = iterator.next();
            int dist = (seated - prev) / 2;
            if (dist > maxDist) {
                maxDist = dist;
                seat = prev + dist;
            }
            prev = seated;
        }

        if (cap - 1 - prev > maxDist) {
            seat = cap - 1;
        }

        seatedSet.add(seat);
        return seat;
    }

    public void leave(int p) {
        seatedSet.remove(p);
    }
}
