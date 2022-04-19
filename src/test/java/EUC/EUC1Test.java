package EUC;

import static org.junit.jupiter.api.Assertions.*;

class EUC1Test {
    int[] nums;

    @org.junit.jupiter.api.BeforeAll
    static void setUpAll() {
        System.out.println("===========BeforeAll==========");
        int[] nums = new int[]{6,2,3,4,2};
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("===========BeforeEach==========");
        nums = new int[]{6,2,3,4,2};
    }

    @org.junit.jupiter.api.Test
    void comprobar1() {
        EUC1 ejer1 = new EUC1();
        boolean kk = ejer1.comprobar1(nums);
        assertEquals(kk,true);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("===========AfterEach==========");
        nums = null;
    }


}