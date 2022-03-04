import slot.*;
import token.*;
import gate.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {

    private Integer numfloors;
    private HashMap<SlotType, List<Slot>> slots;
    private HashMap<Integer, Slot> bookedlist;
    private List<Gate> gates;

    public ParkingLot(Integer numfloors, HashMap<SlotType, List<Slot>> slots, List<Gate> gates) {
        this.numfloors = numfloors;
        this.slots = slots;
        this.gates = gates;
        bookedlist = new HashMap<>();
    }

    public boolean occupySlot(Integer tokenid, Slot slot) {
        slot.setBookingtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        this.bookedlist.put(tokenid, slot);
        slot.setStatus(SlotStatus.OCCUPIED);
        return true;
    }

    public Slot vacateSlot(Integer tokenid) {

        Slot slot = this.bookedlist.get(tokenid);
        slot.setBookingtime(null);
        slot.setStatus(SlotStatus.VACANT);
        this.bookedlist.remove(tokenid);
        return slot;
    }

    public Double calculateFee(Integer tokenid, Double rate) {
        Slot slot = this.bookedlist.get(tokenid);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date bookedtime = null;
        Date currtime = null;
        try {
            bookedtime = format.parse(slot.getBookingtime());
            currtime = format.parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long diffsec = (currtime.getTime() - bookedtime.getTime() + 1001) / 1000;
        long diffmin = (diffsec + 60 - 1) / 60;
        long diffhour = (diffmin + 60 - 1) / 60;
        Double fee = diffhour * rate;
        return fee;
    }

    public Token generateToken(String vehnumber, Integer floor, Integer slotid, Integer gatenum) {
        int id = (int)(Math.random() * 1000);
        String currtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return new Token(id, vehnumber, floor, slotid, currtime , gatenum, TokenStatus.VALID);
    }

    public Slot getVacantSlot(SlotType type) {
        List<Slot> typeslot = slots.get(type);
        for (int i = 0; i < typeslot.size(); i++) {
            if(typeslot.get(i).getStatus() == SlotStatus.VACANT)
                return typeslot.get(i);
        }
        return null;
    }
}

