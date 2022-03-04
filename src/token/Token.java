package token;



public class Token {
    private Integer tokenid;
    private String vehiclenumber;
    private Integer floornum;
    private Integer slotid;
    private String bookingtime;
    private Integer gatenum;
    private TokenStatus status;

    public Token(Integer tokenid, String vehiclenumber, Integer floornum, Integer slotid, String bookingtime, Integer gatenum, TokenStatus status) {
        this.tokenid = tokenid;
        this.vehiclenumber = vehiclenumber;
        this.floornum = floornum;
        this.slotid = slotid;
        this.bookingtime = bookingtime;
        this.gatenum = gatenum;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenid=" + tokenid +
                ", vehiclenumber='" + vehiclenumber + '\'' +
                ", floornum=" + floornum +
                ", slotid=" + slotid +
                ", bookingtime='" + bookingtime + '\'' +
                ", gatenum=" + gatenum +
                ", status=" + status +
                '}';
    }

    public Integer getTokenid() {
        return tokenid;
    }

    public void setTokenid(Integer tokenid) {
        this.tokenid = tokenid;
    }

    public String getVehiclenumber() {
        return vehiclenumber;
    }

    public void setVehiclenumber(String vehiclenumber) {
        this.vehiclenumber = vehiclenumber;
    }

    public Integer getFloornum() {
        return floornum;
    }

    public void setFloornum(Integer floornum) {
        this.floornum = floornum;
    }

    public Integer getSlotid() {
        return slotid;
    }

    public void setSlotid(Integer slotid) {
        this.slotid = slotid;
    }

    public String getBookingtime() {
        return bookingtime;
    }

    public void setBookingtime(String bookingtime) {
        this.bookingtime = bookingtime;
    }

    public Integer getGatenum() {
        return gatenum;
    }

    public void setGatenum(Integer gatenum) {
        this.gatenum = gatenum;
    }

    public TokenStatus getStatus() {
        return status;
    }

    public void setStatus(TokenStatus status) {
        this.status = status;
    }
}


