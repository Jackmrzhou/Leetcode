package leetcodeJava;

class MyCalendarTwo {
    
    class Slot {
        int start, end;
        public Slot(int s, int e) {
            start = s;
            end = e;
        }
    }
    
    List<Slot> bookings;
    List<Slot> doubleBookings;

    public MyCalendarTwo() {
        bookings = new ArrayList<Slot>();
        doubleBookings = new ArrayList<Slot>();
    }
    
    private List<Slot> findIntersections(List<Slot> slots, Slot slot) {
        var res = new LinkedList<Slot>();
        for (int i = 0; i < slots.size(); i++) {
            var tmp = slots.get(i);
            if (tmp.end > slot.start && slot.end > tmp.start) {
                res.add(new Slot(Math.max(tmp.start, slot.start), Math.min(tmp.end, slot.end)));
            }
        }
        return res;
    }
    
    
    public boolean book(int start, int end) {
        for (var s : doubleBookings) {
            if (start < s.end && end > s.start) return false;
        }
        var slot = new Slot(start, end);
        var slots = findIntersections(bookings, slot);
        bookings.add(slot);
        for (var s : slots) {
            doubleBookings.add(s);
        }
       
        return true;
    }
}
