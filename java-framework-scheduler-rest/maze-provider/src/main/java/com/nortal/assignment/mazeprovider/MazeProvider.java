package com.nortal.assignment.mazeprovider;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Joosep Lall.
 */
@Component
public class MazeProvider {

    private static final int INVOCATION_SPEED_LIMIT_MS = 1000;
    private static final int LOCKED_OUT_TIME = 10 * 60 * 1000;
    private long lastInvocation;
    private long lockedOutStartTime;

    //Start from random position
    private int indexToReturn = new Random().nextInt();

    private List<String> coordinateCombinations;

    public MazeProvider() {
        coordinateCombinations = getMaze();
    }

    public String getCoordinatesCombination() {

        long currentTime = System.currentTimeMillis();
        boolean tooFastRequestPace = currentTime - lastInvocation < INVOCATION_SPEED_LIMIT_MS;
        boolean stillLockedOut = currentTime - lockedOutStartTime < LOCKED_OUT_TIME;

        if (tooFastRequestPace || stillLockedOut) {
            lockedOutStartTime = currentTime;
            throw new LockedOutException("Smart don't rush, time is your enemy. Take the following 10 minutes to make a plan.");
        }

        indexToReturn = Math.floorMod(indexToReturn, coordinateCombinations.size());
        String coordinatesCombination = coordinateCombinations.get(indexToReturn).toString();
        indexToReturn++;
        lastInvocation = currentTime;
        return coordinatesCombination;
    }

    private List<String> getMaze() {
        return Arrays.asList(
                "R24,U24,S17,Z21,O5,A13,Q15,J1,D8,I11,I1,D1,F19,I21,O13",
                "A17,L22,Z1,H7,I3,Y10,Z17,K22,M12,O17,W24,G24,P5,Z6,Z26",
                "O16,S8,K16,E17,A9,J6,H6,Y14,O11,A25,R20,W14,S10,Z9,F6",
                "R26,L8,S3,J26,P1,A14,O20,T21,Y26,A24,Y15,G19,R10,N24,S1",
                "T14,D10,M18,P3,T8,L3,X26,T19,Z18,Q10,D4,W22,Z4,X22,H8",
                "X7,X18,Q11,L6,T3,Z13,B19,S5,U10,Z12,I24,K12,I18,E8,A8",
                "G13,S13,H13,P26,G15,A26,E15,E1,Q13,R17,J18,T16,Y5,N21,W3",
                "F4,M13,O15,Y20,K21,A5,S22,N7,N22,W4,X12,W21,T5,S6,W7",
                "M1,N1,R6,Z7,G10,L10,S12,U1,Z10,I5,I9,B26,K6,F22,L26",
                "W20,U22,W9,V17,S24,M15,L21,O24,G1,T1,O22,D6,K18,F24,Z22",
                "V19,A7,C20,N5,M16,K26,Q17,F11,W15,Z23,A16,A11,F3,L18,O18",
                "F26,Z19,K8,P22,R8,U17,E10,X17,O3,L1,M19,B3,L14,B5,Q21",
                "V12,M5,I10,Q16,Z20,L16,L19,S19,A19,H18,Z3,E18,K4,J24,K10",
                "G18,E26,N3,C23,D2,F16,V14,A18,Z14,A23,Q19,R5,K14,D5,V1",
                "W1,H16,Y24,Q22,S23,Z15,Q5,Y9,K24,G8,F10,H21,A15,W10,Z2",
                "C18,Z5,E13,M11,C14,J16,O19,U9,T17,Z16,Q26,E12,I23,L25,V7",
                "Q24,A1,X3,V3,U25,X20,U26,T26,B14,H5,P8,I16,I8,Q8,R15",
                "G3,D26,C17,U7,K3,J3,T12,C21,W5,M26,K1,A3,Q12,C25,W26",
                "H26,X24,M3,N26,B12,C8,G16,A10,W12,C16,U11,A22,Z8,J8,A6",
                "K11,A21,R1,E6,O25,U19,U8,O26,I22,V15,P7,E19,H24,Z11,N6",
                "I26,G26,W17,U5,E16,T22,D12,H1,O12,V20,B23,C19,O8,C26,O21",
                "I13,S26,Q3,G12,L24,L23,N18,U23,O10,F1,R19,Y1,F8,A20,G21",
                "Z24,C12,W13,C10,E22,H3,Q20,M10,E21,A4,V16,C1,U3,D3,A12",
                "E24,I15,T13,R3,X1,Q1,O14,O1,I20,K19,Q14,C9,W6,V26,B1"
        );
    }
}
