package com.mark.oom2visualVM.oommatright;

import java.util.List;

public class ReplayApplication {
    public static void main(String[] args) throws InterruptedException {
        ReplayWithoutProblem replay2 = new ReplayWithoutProblem();
        List cache2 = replay2.loadMockRequest(10000);
        replay2.start(cache2);
    }
}
