import gate.*;
import slot.*;
import token.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        HashMap slots = new HashMap<SlotType, List<Slot>>();
        List<Slot> slotlistcom = new ArrayList<>();
        List<Slot> slotlistmed = new ArrayList<>();
        List<Slot> slotlistlarge = new ArrayList<>();
        List<Gate> gates = new ArrayList<Gate>();

        gates.add(new Gate(1, GateType.ENTRY));
        gates.add(new Gate(2, GateType.EXIT));

        slotlistcom.add(new Slot(1, 1, SlotType.COMPACT, SlotStatus.VACANT, null));
        slotlistcom.add(new Slot(1, 2, SlotType.COMPACT, SlotStatus.VACANT, null));
        slotlistcom.add(new Slot(1, 3, SlotType.COMPACT, SlotStatus.VACANT, null));
        slotlistmed.add(new Slot(1, 4, SlotType.MEDIUM, SlotStatus.VACANT, null));
        slotlistmed.add(new Slot(1, 5, SlotType.MEDIUM, SlotStatus.VACANT, null));
        slotlistmed.add(new Slot(1, 6, SlotType.MEDIUM, SlotStatus.VACANT, null));
        slotlistlarge.add(new Slot(1, 7, SlotType.LARGE, SlotStatus.VACANT, null));
        slotlistlarge.add(new Slot(1, 8, SlotType.LARGE, SlotStatus.VACANT, null));
        slotlistcom.add(new Slot(2, 9, SlotType.COMPACT, SlotStatus.VACANT, null));
        slotlistcom.add(new Slot(2, 10, SlotType.COMPACT, SlotStatus.VACANT, null));
        slotlistcom.add(new Slot(2, 11, SlotType.COMPACT, SlotStatus.VACANT, null));
        slotlistmed.add(new Slot(2, 12, SlotType.MEDIUM, SlotStatus.VACANT, null));
        slotlistmed.add(new Slot(2, 13, SlotType.MEDIUM, SlotStatus.VACANT, null));
        slotlistmed.add(new Slot(2, 14, SlotType.MEDIUM, SlotStatus.VACANT, null));
        slotlistlarge.add(new Slot(2, 15, SlotType.LARGE, SlotStatus.VACANT, null));
        slotlistlarge.add(new Slot(2, 16, SlotType.LARGE, SlotStatus.VACANT, null));

        slots.put(SlotType.COMPACT, slotlistcom);
        slots.put(SlotType.MEDIUM, slotlistmed);
        slots.put(SlotType.LARGE, slotlistlarge);

        ParkingLot parkingLot = new ParkingLot(2, slots, gates);
        Attendent attendent = new Attendent("Raju", 2, 2);

        // booking

        Token tokenrj = attendent.bookSlot(parkingLot, "RJ13", 1, SlotType.COMPACT);
        Token tokenup = attendent.bookSlot(parkingLot, "UP14", 1, SlotType.MEDIUM);

        System.out.println(tokenrj.toString());
        System.out.println(tokenup.toString());

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // confirm exit
        Double fee = attendent.confirmExit(parkingLot, tokenrj.getTokenid(), 40.04);
        System.out.println("Parking Fee : " + fee);

    }


}
