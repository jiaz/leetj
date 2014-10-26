package com.jiaz.leetj;

import org.junit.Test;
import org.junit.Assert;
import java.lang.reflect.ParameterizedType;

import static com.jiaz.leetj.TestRunner.judge;

/**
 * Base Class for TestCases which provide infrastructure to run cases
 * @param <T> the class of the problem solver
 */
public abstract class AbstractTest<T> {

    protected abstract String solveProblem(String input, T solver);

    protected Class<T> solverType;

    /**
     * Super Type Token trick to get class of generic parameter.
     * http://gafter.blogspot.jp/2006/12/super-type-tokens.html
     */
    @SuppressWarnings("unchecked")
    protected AbstractTest() {
        solverType = (Class<T>)((ParameterizedType)(getClass().getGenericSuperclass()))
                .getActualTypeArguments()[0];
    }

    protected T createSolver() throws Exception {
        return solverType.newInstance();
    }

    @Test
    public void runCase() throws Exception {
        String problemSetName = solverType.getSimpleName().split("_")[0];
        judge(problemSetName, (input) -> {
            try {
                T solver = this.createSolver();
                return solveProblem(input, solver);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
