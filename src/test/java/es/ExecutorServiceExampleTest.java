package es;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ExecutorServiceExampleTest {

    @Test
    void printMessage() {
        assertTrue(regexDivSections("17"));
        assertTrue(regexDivSections("A1"));
        assertTrue(regexDivSections("J3"));
        assertTrue(regexDivSections("M4"));

        assertFalse(regexDivSections("12"));
        assertFalse(regexDivSections("M1"));
        assertFalse(regexDivSections("L0"));
        assertFalse(regexDivSections("I2"));
        assertFalse(regexDivSections("A3"));
    }

    private boolean regexDivSections(String divide) {
        String regex = "17|A[1479]|C[78]|D[9]|H[5-79]|I[4]|J[369]|K[1-9A]|L[1-8A-Z]|M[2-9]";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(divide).find();
    }

    @Test
    void main() {
        String all = "00,17,A1,A4,A7,A9,C7,C8,D9,H5,H6,H7,H9,I4,J3,J6,J9,K1,K2,K3,K4,K5,K6,K7,K8,K9,KA,L1,L2,L3,L4,L5,L6,L8,LA,LB,LC,LH,M2,M3,M4,M5,M6,M7,M8,M9,LI,LL,LM,LK,LN,LO,LP,LD,LG,LE,LF,LJ,LQ,LR,LS,LT,LU,LV,LW,LX,LY,LZ";
        String allSort = "00, 17, A1, A4, A7, A9, C7, C8, D9, H5, H6, H7, H9, I4, J3, J6, J9, K1, K2, K3, K4, K5, K6, K7, K8, K9, KA, L1, L2, L3, L4, L5, L6, L8, LA, LB, LC, LD, LE, LF, LG, LH, LI, LJ, LK, LL, LM, LN, LO, LP, LQ, LR, LS, LT, LU, LV, LW, LX, LY, LZ, M2, M3, M4, M5, M6, M7, M8, M9";

        String regex = "\\d{1}[07]|A[1479]|C[78]|D[9]|H[5-79]|I[4]|J[369]|K[1-9A]|L[1-8A-Z]|M[2-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("SUTRT17");

        System.out.println("res " + matcher.find());
        System.out.println(matcher.find() ?
                "I found '"+matcher.group()+"' starting at index "+matcher.start()+" and ending at index "+matcher.end()+"." :
                "I found nothing!");



        List<String> slist = Arrays.asList(all.split("\\s*,\\s*"));
        List<String> sortedList = slist.stream().sorted().collect(Collectors.toList());
        sortedList.forEach(System.out::print);
        System.out.println(sortedList);
    }

}