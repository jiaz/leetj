package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q093_RestoreIPAddressesTest extends AbstractTest<Q093_RestoreIPAddresses> {

    @Override
    protected String solveProblem(String input, Q093_RestoreIPAddresses solver) {
        return serializeList(solver.restoreIpAddresses(toStr(input)), StringSerializer.getInstance());
    }

} 
