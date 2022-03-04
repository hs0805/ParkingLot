package slot;

public class Slot {
    private Integer floor;
    private Integer id;
    private SlotType type;
    private SlotStatus status;
    private String bookingtime;

    public Slot(Integer floor, Integer id, SlotType type, SlotStatus status, String bookingtime) {
        this.floor = floor;
        this.id = id;
        this.type = type;
        this.status = status;
        this.bookingtime = bookingtime;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SlotType getType() {
        return type;
    }

    public void setType(SlotType type) {
        this.type = type;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public void setStatus(SlotStatus status) {
        this.status = status;
    }

    public String getBookingtime() {
        return bookingtime;
    }

    public void setBookingtime(String bookingtime) {
        this.bookingtime = bookingtime;
    }
}
