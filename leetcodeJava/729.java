package leetcodeJava;

class MyCalendar {
    
    class Slot {
        int start, end;
        public Slot(int s, int e) {
            start = s;
            end = e;
        }
    }
    
    List<Slot> bookings;

    public MyCalendar() {
        bookings = new ArrayList<Slot>();
    }
    
    public boolean book(int start, int end) {
        for (int i = bookings.size() - 1; i >= 0; i--) {
            var slot = bookings.get(i);
            if (slot.end <= start) {
                if (i == bookings.size() -1 || bookings.get(i+1).start >= end) {
                    bookings.add(i+1, new Slot(start, end));
                    return true;
                }
            }
        }
        if (bookings.isEmpty() || bookings.get(0).start >= end) {
            bookings.add(0, new Slot(start, end));
            return true;
        }  
        return false;
    }
}
