package net.uint32.validation.validator;

import net.uint32.validation.config.ValiCtx;

import java.util.Arrays;

/**
 * desc
 *
 * @author tangmingyou
 * @date 2021-09-30 10:03
 */
public class MaxValidator implements StatelessValidator {
    @Override
    public boolean isValid(ValiCtx ctx, Object value, Object[] valiArgs) {
        int max = (int)valiArgs[0];
        int intValue = Integer.parseInt(String.valueOf(value));
        return intValue <= max;
    }

    @Override
    public Object[] parseValidatorArgs(String[] valiArgs) {
        if (valiArgs == null || valiArgs.length != 1) {
            throw new IllegalArgumentException("Max校验器参数有误 " + Arrays.toString(valiArgs));
        }
        try {
            return new Integer[]{Integer.valueOf(valiArgs[0])};
        }catch (Exception e) {
            throw new IllegalArgumentException("Max校验器参数有误 " + Arrays.toString(valiArgs));
        }
    }

    @Override
    public String message(String name, Object value, Object[] valiArgs) {
        return String.format("%s最大值为%d", name, (Integer)valiArgs[0]);
    }

}
