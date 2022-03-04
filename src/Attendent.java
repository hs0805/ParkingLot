import token.*;
import slot.*;

public class Attendent {
    private String name;
    private Integer id;
    private Integer gatenum;

    public Integer getGatenum() {
        return gatenum;
    }

    public void setGatenum(Integer gatenum) {
        this.gatenum = gatenum;
    }

    public Attendent(String name, Integer id, Integer gatenum) {
        this.name = name;
        this.id = id;
        this.gatenum = gatenum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Token bookSlot(ParkingLot parkingLot, String vehnumber, Integer floor, SlotType type) {
        Slot slot = parkingLot.getVacantSlot(type);
        if(slot == null) return null;
        Token token = parkingLot.generateToken(vehnumber, floor, slot.getId(), this.getGatenum());
        parkingLot.occupySlot(token.getTokenid(), slot);
        return token;
    }

    public Double confirmExit(ParkingLot parkingLot, Integer tokenid, Double rate) {
        Double fee = parkingLot.calculateFee(tokenid, rate);
        parkingLot.vacateSlot(tokenid);
        return fee;
    }

}
