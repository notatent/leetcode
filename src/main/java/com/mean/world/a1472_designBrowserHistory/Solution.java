package com.mean.world.a1472_designBrowserHistory;

import java.util.Stack;

public class Solution {
    /**
     * ["BrowserHistory","forward","visit","visit","visit","forward","forward","visit","back","visit",
     * "visit","visit","forward","visit","visit","back","back","forward","visit","visit",
     * "back","forward","back","visit","forward","visit","visit","visit","back","forward",
     * "visit","visit","visit","back","visit","forward","forward","visit","visit","forward",
     * "forward","back","visit","forward","visit","visit","visit","forward","visit","visit",
     * "visit","forward","visit","forward","visit","visit","visit","visit","back","visit",
     * "visit","back","visit","visit","visit","visit","visit","forward","forward","back",
     * "visit","visit","visit","visit","visit","visit"]
     *
     * [["lbtj.com"],[8],["kojvhen.com"],["yhf.com"],["lvcs.com"],[10],[5],["ysd.com"],[4],["akumlj.com"],
     * ["rbrnbv.com"],["nsco.com"],[5],["xlwvcn.com"],["tnfpbk.com"],[8],[9],[9],["byuwdso.com"],["zla.com"],
     * [3],[8],[4],["atr.com"],[7],["vhn.com"],["rfbomi.com"],["vkuww.com"],[10],[4],
     * ["wzdoj.com"],["uvmcmz.com"],["uc.com"],[8],["aznqgd.com"],[3],[8],["wfq.com"],["htniic.com"],[3],
     * [2],[3],["xldeug.com"],[7],["kszu.com"],["sm.com"],["ct.com"],[9],["mbyfwrt.com"],["esbci.com"],
     * ["ft.com"],[6],["tjg.com"],[8],["crqje.com"],["cn.com"],["fedrfj.com"],["rpgq.com"],[2],["saftk.com"],
     * ["rysdgem.com"],[7],["gjqre.com"],["boyf.com"],["evsk.com"],["qkr.com"],["pbakqfu.com"],[10],[6],[7],
     * ["wnnbr.com"],["ebgog.com"],["svz.com"],["eltuy.com"],["bfv.com"],["agnv.com"]]
     */

//    [null,"lbtj.com",null,null,null,"lvcs.com","lvcs.com",null,"lbtj.com",null,
//    null,null,"nsco.com",null,null,"lbtj.com","lbtj.com","tnfpbk.com",null,null,
//    "xlwvcn.com","zla.com","nsco.com",null,"atr.com",null,null,null,"lbtj.com","nsco.com",
//    null,null,null,"lbtj.com",null,"aznqgd.com","aznqgd.com",null,null,"htniic.com",
//    "htniic.com","lbtj.com",null,"xldeug.com",null,null,null,"ct.com",null,null,
//    null,"ft.com",null,"tjg.com",null,null,null,null,"cn.com",null,
//    null,"mbyfwrt.com",null,null,null,null,null,"pbakqfu.com","pbakqfu.com","sm.com",
//    null,null,null,null,null,null]


//    [null,"lbtj.com",null,null,null,"lvcs.com","lvcs.com",null,"lbtj.com",null,
//    null,null,"nsco.com",null,null,"lbtj.com","lbtj.com","tnfpbk.com",null,null,
//    "xlwvcn.com","zla.com","nsco.com",null,"atr.com",null,null,null,"lbtj.com","atr.com",
//    null,null,null,"lbtj.com",null,"aznqgd.com","aznqgd.com",null,null,"htniic.com",
//    "htniic.com","lbtj.com",null,"xldeug.com",null,null,null,"ct.com",null,null,
//    null,"ft.com",null,"tjg.com",null,null,null,null,"cn.com",null,
//    null,"mbyfwrt.com",null,null,null,null,null,"pbakqfu.com","pbakqfu.com","sm.com",
//    null,null,null,null,null,null]
    public static void main(String[] args) {
        BrowserHistory obj = new BrowserHistory("lbtj.com");
        obj.forward(8);
        obj.visit("kojvhen.com");
        obj.visit("yhf.com");
        obj.visit("lvcs.com");
        obj.forward(10);

        obj.back(9);
        obj.visit("kttzxgh.com");
        obj.forward(7);
        obj.visit("crgje.com");
        obj.visit("iybch.com");
        obj.forward(5);
        obj.visit("uun.com");
        obj.back(10);
        obj.visit("hci.com");
        obj.visit("whula.com");
        obj.forward(10);
    }
}

class BrowserHistory {

    private Stack<String> back = new Stack();
    private Stack<String> forward = new Stack();
    private String homepage = "";

    public BrowserHistory(String homepage) {
        back.push(homepage);
    }

    public void visit(String url) {
        back.push(url);
        forward.removeAllElements();
    }

    public String back(int steps) {
        int realSteps = steps;
        if (steps > back.size()) {
            realSteps = back.size();
        }
        for (int i = 0; i < realSteps; i++) {
            forward.push(back.pop());
        }
        return back.isEmpty() ? this.homepage : back.peek();
    }

    public String forward(int steps) {
        int realSteps = steps;
        if (steps > forward.size()) {
            realSteps = forward.size();
        }
        for (int i = 0; i < realSteps; i++) {
            back.push(forward.pop());
        }
        return back.isEmpty() ? this.homepage : back.peek();
    }
}